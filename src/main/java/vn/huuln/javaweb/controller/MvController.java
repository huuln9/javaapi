package vn.huuln.javaweb.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vn.huuln.javaweb.dto.MvGetDto;
import vn.huuln.javaweb.dto.MvPostPutDto;
import vn.huuln.javaweb.dto.TagPostPutDto;
import vn.huuln.javaweb.service.MvService;

@RestController
@RequestMapping("/mv")
public class MvController {

    @Autowired
    MvService service;

    @GetMapping
    private Page<MvGetDto> getList(@RequestParam(name = "code", required = false) String code, Pageable pageable) {
        return service.getList(code, pageable);
    }

    @PostMapping
    private void add(@RequestBody MvPostPutDto data) {
        service.add(data);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable(value = "id", required = true) ObjectId id, @RequestBody MvPostPutDto data) {
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable(value = "id", required = true) ObjectId id) {
        service.delete(id);
    }
}
