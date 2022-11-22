package vn.huuln.javaweb.dto;

import lombok.Data;
import vn.huuln.javaweb.document.Acctress;
import vn.huuln.javaweb.document.Tag;

import java.util.List;

@Data
public class MvPostDto {
    private String code;
    private List<String> links;
    private List<Acctress> acctresses;
    private List<Tag> tags;
}
