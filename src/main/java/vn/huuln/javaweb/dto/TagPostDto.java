package vn.huuln.javaweb.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class TagPostDto {
    private String name;
}
