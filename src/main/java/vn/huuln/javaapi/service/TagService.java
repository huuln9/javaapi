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
import vn.huuln.javaapi.document.Tag;
import vn.huuln.javaapi.dto.TagGetDto;
import vn.huuln.javaapi.dto.TagPostPutDto;
import vn.huuln.javaapi.repository.TagRepository;

import java.util.List;
import java.util.Objects;

@Service
public class TagService {

    @Autowired
    private TagRepository repo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Page<TagGetDto> getList(String name, Pageable pageable) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (Objects.nonNull(name)) {
            query.addCriteria(criteria.orOperator(Criteria.where("name").regex(name.trim(), "i")));
        }
        query.with(pageable);
        List<TagGetDto> tagGetDtos = mongoTemplate.find(query, TagGetDto.class);
        Page<TagGetDto> page = PageableExecutionUtils.getPage(tagGetDtos, pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), TagGetDto.class));
        return page;
    }

    public void add(TagPostPutDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        repo.save(tag);
    }

    public void update(ObjectId id, TagPostPutDto dto) {
        Tag tag = repo.findById(id).get();
        if (Objects.isNull(tag)) return;
        tag.setName(dto.getName());
        repo.save(tag);
    }

    public void delete(ObjectId id) {
        repo.deleteById(id);
    }
}
