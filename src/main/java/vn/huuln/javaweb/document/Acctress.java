package vn.huuln.javaweb.document;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "acctress")
public class Acctress {
    @Id
    private ObjectId id;
    private String name;
    private String avatar;
}
