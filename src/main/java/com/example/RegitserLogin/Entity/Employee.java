package com.example.RegitserLogin.Entity;

import jakarta.persistence.*;

@Entity()
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" , length = 45)
    private int id;
    @Column(name="employeeName" , length = 255)
    private String employeeName;

    @Column(name="email" , length = 255)
    private String email;

    @Column(name="password" , length = 255)
    private String password;

    public Employee(int id, String employeeName, String email, String password) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;
    }

    public Employee() {

    }

    public Employee(int id, String employeeName, String email, String password, String encode) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.password = encode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
