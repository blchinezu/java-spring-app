//package com.spring.gameloft.domain;
//
//import lombok.*;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//public class Employees {
//    @Id
//    @NotNull
//    @Column(name = "employeenumber")
//    Integer employeeNumber;
//
//    @OneToMany(mappedBy = "customers")
//    List<Customers> customers;
//
//    @NotNull
//    @Column(name = "lastname")
//    String lastName;
//
//    @NotNull
//    @Column(name = "firstname")
//    String firstName;
//
//    @NotNull
//    @Column(name = "extension")
//    String extension;
//
//    @NotNull
//    @Column(name = "email")
//    String email;
//
//    @NotNull
//    @Column(name = "officecode")
//    String officeCode;
//
//    @Column(name = "reportsto")
//    Integer reportsTo;
//
//    @NotNull
//    @Column(name = "jobtitle")
//    String jobTitle;
//
////  KEY `reportsTo` (`reportsTo`),
////  KEY `officeCode` (`officeCode`),
////  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`reportsTo`) REFERENCES `employees` (`employeeNumber`),
////  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`officeCode`) REFERENCES `offices` (`officeCode`)
//}
