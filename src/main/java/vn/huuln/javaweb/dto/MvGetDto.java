package vn.huuln.javaweb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "mv")
public class MvGetDto {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String code;
    private List<String> links;
    private List<IdNameDto> acctresses;
    private List<IdNameDto> tags;
}
