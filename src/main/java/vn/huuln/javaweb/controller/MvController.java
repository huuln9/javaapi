package vn.huuln.javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.huuln.javaweb.dto.MvPostDto;
import vn.huuln.javaweb.service.MvService;

@RestController
@RequestMapping("/mv")
public class MvController {

    @Autowired
    MvService service;

    @PostMapping
    private void add(@RequestBody MvPostDto data) {
        service.add(data);
    }

}
