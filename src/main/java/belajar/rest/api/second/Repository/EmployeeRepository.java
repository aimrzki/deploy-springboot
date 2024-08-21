package belajar.rest.api.second.Repository;

import belajar.rest.api.second.Model.Employee;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee>findByEmployeeId(String employeeId);
}
