package vn.huuln.javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.huuln.javaweb.document.Mv;
import vn.huuln.javaweb.dto.MvPostDto;
import vn.huuln.javaweb.repository.MvRepository;

@Service
public class MvService {

    @Autowired
    MvRepository repo;

    public void add(MvPostDto dto) {
        Mv mv = new Mv();
        mv.setCode(dto.getCode());
        mv.setTags(dto.getTags());
        mv.setAcctresses(dto.getAcctresses());
        mv.setLinks(dto.getLinks());
        repo.save(mv);
    }
}
