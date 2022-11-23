package vn.huuln.javaweb.dto;

import lombok.Data;

import java.util.List;

@Data
public class MvPostDto {
    private String code;
    private List<String> links;
    private List<IdNameDto> acctresses;
    private List<IdNameDto> tags;
}
