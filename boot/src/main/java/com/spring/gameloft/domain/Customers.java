//package com.spring.gameloft.domain;
//
//import lombok.*;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;
//import java.math.BigDecimal;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//public class Customers {
//    @Id
//    @NotNull
//    @Column(name="customernumber")
//    Integer customerNumber;
//
//    @NotNull
//    @Column(name="customername")
//    String customerName;
//
//    @NotNull
//    @Column(name="contactlastname")
//    String contactLastName;
//
//    @NotNull
//    @Column(name="contactfirstname")
//    String contactFirstName;
//
//    @NotNull
//    @Column(name="phone")
//    String phone;
//
//    @NotNull
//    @Column(name="addressline1")
//    String addressLine1;
//
//    @Column(name="addressline2")
//    String addressLine2;
//
//    @NotNull
//    @Column(name="city")
//    String city;
//
//    @Column(name="state")
//    String state;
//
//    @Column(name="postalcode")
//    String postalCode;
//
//    @NotNull
//    @Column(name="country")
//    String country;
//
//    @ManyToOne
//    Employees employee;
//
//    @Column(name="creditlimit")
//    BigDecimal creditLimit;
//
////  KEY `salesRepEmployeeNumber` (`salesRepEmployeeNumber`),
////  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`salesRepEmployeeNumber`) REFERENCES `employees` (`employeeNumber`)
//}
