package com.example.RegitserLogin.Service;

import com.example.RegitserLogin.Dto.EmployeeDTO;
import com.example.RegitserLogin.Dto.LoginDTO;
import com.example.RegitserLogin.response.LoginResponse;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    String saveEmployee(EmployeeDTO employeeDto);

    LoginResponse loginEmployee (LoginDTO loginDTO);
}
