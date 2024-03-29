package vn.huuln.javaapi.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.huuln.javaapi.document.Actress;

@Repository
public interface ActressRepository extends MongoRepository<Actress, ObjectId> {
}
