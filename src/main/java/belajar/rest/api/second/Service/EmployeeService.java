package belajar.rest.api.second.Service;


import belajar.rest.api.second.Model.Employee;
import belajar.rest.api.second.Repository.EmployeeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public Employee addEmployee(Employee employee){
        employee.setUuid(UUID.randomUUID().toString().split("-")[0]);
        employee.setEmployeeId(UUID.randomUUID().toString().split("-")[0]);
        String hashedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(hashedPassword);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByEmployeeId(String employeeId){
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public Employee updateEmailEmployeeByEmployeeId(String employeeId, String newMail){
        List<Employee> employees = employeeRepository.findByEmployeeId(employeeId);
        if(employees.isEmpty()){
            return null;
        }
        Employee employee = employees.get(0);
        employee.setEmail(newMail);
        return employeeRepository.save(employee);
    }


}
