package vn.huuln.javaweb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import vn.huuln.javaweb.document.Tag;

public interface TagRepository extends MongoRepository<Tag, ObjectId> {
}
