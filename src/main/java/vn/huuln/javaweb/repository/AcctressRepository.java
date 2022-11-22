package vn.huuln.javaweb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import vn.huuln.javaweb.document.Acctress;

public interface AcctressRepository extends MongoRepository<Acctress, ObjectId> {
}
