package vn.huuln.javaweb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tag")
public class TagGetDto {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String name;
}
