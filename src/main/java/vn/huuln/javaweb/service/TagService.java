package vn.huuln.javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.huuln.javaweb.document.Tag;
import vn.huuln.javaweb.dto.TagPostDto;
import vn.huuln.javaweb.repository.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository repo;

    public void add(TagPostDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        repo.save(tag);
    }
}
