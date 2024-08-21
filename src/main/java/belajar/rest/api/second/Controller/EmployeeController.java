package belajar.rest.api.second.Controller;

import belajar.rest.api.second.Model.Employee;
import belajar.rest.api.second.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private View error;

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee signUpEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public List <Employee> getEmployeeByEmployeeId(@PathVariable String employeeId){
        return employeeService.getEmployeeByEmployeeId(employeeId);
    }

//    @PatchMapping("/{employeeId}/email")
//    @ResponseStatus(HttpStatus.OK)
//    public Employee updateEmail(@PathVariable String employeeId, @RequestBody String newEmail) {
//        Employee updatedEmployee = employeeService.updateEmailEmployeeByEmployeeId(employeeId, newEmail);
//        if (updatedEmployee == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
//        }
//        return updatedEmployee;
//    }

    @PatchMapping("/{employeeId}/email")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmail(@PathVariable String employeeId, @RequestBody Map<String, String> requestBody) {
        String newEmail = requestBody.get("newEmail");
        Employee updatedEmployee = employeeService.updateEmailEmployeeByEmployeeId(employeeId, newEmail);
        if (updatedEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return updatedEmployee;
    }


}
