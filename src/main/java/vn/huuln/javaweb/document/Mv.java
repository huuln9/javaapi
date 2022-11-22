package vn.huuln.javaweb.document;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "mv")
public class Mv {
    @Id
    private ObjectId id;
    private String code;
    private List<String> links;
    private List<Acctress> acctresses;
    private List<Tag> tags;
}