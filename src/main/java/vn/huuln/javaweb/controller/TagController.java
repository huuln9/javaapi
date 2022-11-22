package vn.huuln.javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.huuln.javaweb.dto.TagPostDto;
import vn.huuln.javaweb.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService service;

    @PostMapping
    private void add(@RequestBody TagPostDto data) {
        service.add(data);
    }
}
