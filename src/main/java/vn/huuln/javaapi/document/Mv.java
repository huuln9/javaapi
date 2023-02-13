package vn.huuln.javaapi.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "mv")
public class Mv {
    @Id
    private ObjectId id;
    private String code;
    private String thumbnail;
    private List<String> images;
    private List<String> links;
    private List<Acctress> acctresses;
    private List<Tag> tags;
}