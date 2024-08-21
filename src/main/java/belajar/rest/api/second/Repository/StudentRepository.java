package belajar.rest.api.second.Repository;

import belajar.rest.api.second.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
}
