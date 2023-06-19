package com.example.RegitserLogin.Service.impl;

import com.example.RegitserLogin.Dto.EmployeeDTO;
import com.example.RegitserLogin.Dto.LoginDTO;
import com.example.RegitserLogin.Entity.Employee;
import com.example.RegitserLogin.Repository.EmployeeRepository;
import com.example.RegitserLogin.Service.EmployeeService;
import com.example.RegitserLogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder =passwordEncoder;

    }

    @Override
    public String saveEmployee(EmployeeDTO employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getEmployeeName(),
                employeeDto.getEmail(),
                employeeDto.getPassword(),
                this.passwordEncoder.encode( employeeDto.getPassword())
        );
        employeeRepository.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepository.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }

    }
}
