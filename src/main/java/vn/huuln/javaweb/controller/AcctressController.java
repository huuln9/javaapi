package vn.huuln.javaweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acctress")
public class AcctressController {

    @GetMapping
    private String getList() {
        return "danh sach";
    }

    @PostMapping
    private String add() {
        return "post";
    }
}
