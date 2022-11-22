package vn.huuln.javaweb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import vn.huuln.javaweb.document.Mv;

public interface MvRepository extends MongoRepository<Mv, ObjectId> {
}
