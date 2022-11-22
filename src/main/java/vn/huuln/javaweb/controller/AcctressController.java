package vn.huuln.javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.huuln.javaweb.dto.AcctressPostDto;
import vn.huuln.javaweb.dto.TagPostDto;
import vn.huuln.javaweb.service.AcctressService;
import vn.huuln.javaweb.service.TagService;

@RestController
@RequestMapping("/acctress")
public class AcctressController {
    @Autowired
    AcctressService service;

    @GetMapping
    private String getList() {
        return "danh sach";
    }

    @PostMapping
    private void add(@RequestBody AcctressPostDto data) {
        service.add(data);
    }
}
