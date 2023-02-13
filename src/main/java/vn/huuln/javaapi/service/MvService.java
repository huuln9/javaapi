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
import vn.huuln.javaapi.document.Mv;
import vn.huuln.javaapi.document.Tag;
import vn.huuln.javaapi.dto.*;
import vn.huuln.javaapi.repository.MvRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MvService {

    @Autowired
    private MvRepository repo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Page<MvGetDto> getList(String code, Pageable pageable) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (Objects.nonNull(code)) {
            query.addCriteria(criteria.orOperator(Criteria.where("code").regex(code.trim(), "i")));
        }
        query.with(pageable);
        List<MvGetDto> mvGetDtos = mongoTemplate.find(query, MvGetDto.class);
        Page<MvGetDto> page = PageableExecutionUtils.getPage(mvGetDtos, pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), MvGetDto.class));
        return page;
    }


    public void add(MvPostPutDto dto) {
        Mv mv = new Mv();

        // code
        mv.setCode(dto.getCode());

        // links
        mv.setLinks(dto.getLinks());

        // acctresses
        List<Actress> acctresses = new ArrayList<>();
        for (IdNameDto acctressDto : dto.getAcctresses()) {
            Actress acctress = new Actress();
            acctress.setId(acctressDto.getId());
            acctress.setName(acctressDto.getName());
            acctresses.add(acctress);
        }
        mv.setAcctresses(acctresses);

        // tags
        List<Tag> tags = new ArrayList<>();
        for (IdNameDto tagDto : dto.getTags()) {
            Tag tag = new Tag();
            tag.setId(tagDto.getId());
            tag.setName(tagDto.getName());
            tags.add(tag);
        }
        mv.setTags(tags);

        repo.save(mv);
    }

    public void update(ObjectId id, MvPostPutDto dto) {
        Mv mv = repo.findById(id).get();
        if (Objects.isNull(mv)) return;

        // code
        mv.setCode(dto.getCode());

        // links
        mv.setLinks(dto.getLinks());

        // acctresses
        List<Actress> acctresses = new ArrayList<>();
        for (IdNameDto acctressDto : dto.getAcctresses()) {
            Actress acctress = new Actress();
            acctress.setId(acctressDto.getId());
            acctress.setName(acctressDto.getName());
            acctresses.add(acctress);
        }
        mv.setAcctresses(acctresses);

        // tags
        List<Tag> tags = new ArrayList<>();
        for (IdNameDto tagDto : dto.getTags()) {
            Tag tag = new Tag();
            tag.setId(tagDto.getId());
            tag.setName(tagDto.getName());
            tags.add(tag);
        }
        mv.setTags(tags);

        repo.save(mv);
    }

    public void delete(ObjectId id) {
        repo.deleteById(id);
    }
}
