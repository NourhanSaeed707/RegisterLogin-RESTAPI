package com.example.RegitserLogin.EmployeeController;

import com.example.RegitserLogin.Dto.EmployeeDTO;
import com.example.RegitserLogin.Dto.LoginDTO;
import com.example.RegitserLogin.Service.EmployeeService;
import com.example.RegitserLogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")

public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDto) {
         String id =  employeeService.saveEmployee(employeeDto);
         return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
       return  ResponseEntity.ok(loginResponse);
    }
}
