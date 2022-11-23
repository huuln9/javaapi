package vn.huuln.javaweb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.huuln.javaweb.document.Acctress;

@Repository
public interface AcctressRepository extends MongoRepository<Acctress, ObjectId> {
}
