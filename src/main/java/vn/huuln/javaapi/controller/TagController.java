package vn.huuln.javaapi.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vn.huuln.javaapi.dto.TagGetDto;
import vn.huuln.javaapi.dto.TagPostPutDto;
import vn.huuln.javaapi.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService service;

    @GetMapping
    private Page<TagGetDto> getList(@RequestParam(name = "name", required = false) String name, Pageable pageable) {
        return service.getList(name, pageable);
    }

    @PostMapping
    private void add(@RequestBody TagPostPutDto data) {
        service.add(data);
    }


    @PutMapping("/{id}")
    private void update(@PathVariable(value = "id", required = true) ObjectId id, @RequestBody TagPostPutDto data) {
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable(value = "id", required = true) ObjectId id) {
        service.delete(id);
    }
}
