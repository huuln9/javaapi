package vn.huuln.javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.huuln.javaweb.document.Acctress;
import vn.huuln.javaweb.document.Tag;
import vn.huuln.javaweb.dto.AcctressPostDto;
import vn.huuln.javaweb.dto.TagPostDto;
import vn.huuln.javaweb.repository.AcctressRepository;

@Service
public class AcctressService {
    @Autowired
    AcctressRepository repo;

    public void add(AcctressPostDto dto) {
        Acctress acctress = new Acctress();
        acctress.setName(dto.getName());
        acctress.setAvatar(dto.getAvatar());
        repo.save(acctress);
    }
}
