package vn.huuln.javaapi.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import vn.huuln.javaapi.document.Actress;
import vn.huuln.javaapi.dto.ActressGetDto;
import vn.huuln.javaapi.dto.AcctressPostPutDto;
import vn.huuln.javaapi.repository.ActressRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ActressService {
    @Autowired
    private ActressRepository repo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Page<ActressGetDto> getList(String name, Pageable pageable) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (Objects.nonNull(name)) {
            query.addCriteria(criteria.orOperator(Criteria.where("name").regex(name.trim(), "i")));
        }
        query.with(pageable);
        List<ActressGetDto> acctressGetDtos = mongoTemplate.find(query, ActressGetDto.class);
        Page<ActressGetDto> page = PageableExecutionUtils.getPage(acctressGetDtos, pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), ActressGetDto.class));
        return page;
    }

    public void add(AcctressPostPutDto dto) {
        Actress acctress = new Actress();
        acctress.setName(dto.getName());
        acctress.setAvatar(dto.getAvatar());
        repo.save(acctress);
    }

    public void update(ObjectId id, AcctressPostPutDto dto) {
        Actress acctress = repo.findById(id).get();
        if (Objects.isNull(acctress)) return;
        acctress.setName(dto.getName());
        acctress.setAvatar(dto.getAvatar());
        repo.save(acctress);
    }

    public void delete(ObjectId id) {
        repo.deleteById(id);
    }
}
