package vn.huuln.javaweb.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import vn.huuln.javaweb.document.Acctress;
import vn.huuln.javaweb.dto.AcctressGetDto;
import vn.huuln.javaweb.dto.AcctressPostPutDto;
import vn.huuln.javaweb.repository.AcctressRepository;

import java.util.List;
import java.util.Objects;

@Service
public class AcctressService {
    @Autowired
    private AcctressRepository repo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Page<AcctressGetDto> getList(String name, Pageable pageable) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (Objects.nonNull(name)) {
            query.addCriteria(criteria.orOperator(Criteria.where("name").regex(name.trim(), "i")));
        }
        query.with(pageable);
        List<AcctressGetDto> acctressGetDtos = mongoTemplate.find(query, AcctressGetDto.class);
        Page<AcctressGetDto> page = PageableExecutionUtils.getPage(acctressGetDtos, pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), AcctressGetDto.class));
        return page;
    }

    public void add(AcctressPostPutDto dto) {
        Acctress acctress = new Acctress();
        acctress.setName(dto.getName());
        acctress.setAvatar(dto.getAvatar());
        repo.save(acctress);
    }

    public void update(ObjectId id, AcctressPostPutDto dto) {
        Acctress acctress = repo.findById(id).get();
        if (Objects.isNull(acctress)) return;
        acctress.setName(dto.getName());
        acctress.setAvatar(dto.getAvatar());
        repo.save(acctress);
    }

    public void delete(ObjectId id) {
        repo.deleteById(id);
    }
}
