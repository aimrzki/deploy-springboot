package belajar.rest.api.second.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String uuid;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String username;
    private String password;
}
