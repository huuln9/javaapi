package vn.huuln.javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.huuln.javaweb.document.Acctress;
import vn.huuln.javaweb.document.Mv;
import vn.huuln.javaweb.document.Tag;
import vn.huuln.javaweb.dto.IdNameDto;
import vn.huuln.javaweb.dto.MvPostDto;
import vn.huuln.javaweb.repository.MvRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MvService {

    @Autowired
    private MvRepository repo;

    public void add(MvPostDto dto) {
        Mv mv = new Mv();

        // code
        mv.setCode(dto.getCode());

        // links
        mv.setLinks(dto.getLinks());

        // acctresses
        List<Acctress> acctresses = new ArrayList<>();
        for (IdNameDto acctressDto : dto.getAcctresses()) {
            Acctress acctress = new Acctress();
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
}
