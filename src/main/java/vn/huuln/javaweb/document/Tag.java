package vn.huuln.javaweb.document;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tag")
public class Tag {
    @Id
    private ObjectId id;
    private String name;
}
