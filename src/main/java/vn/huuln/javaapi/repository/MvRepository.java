package vn.huuln.javaapi.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import vn.huuln.javaapi.document.Mv;

public interface MvRepository extends MongoRepository<Mv, ObjectId> {
}
