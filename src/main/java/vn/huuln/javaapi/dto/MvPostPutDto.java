package vn.huuln.javaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class MvPostPutDto {
    private String code;
    private List<String> links;
    private List<IdNameDto> acctresses;
    private List<IdNameDto> tags;
}
