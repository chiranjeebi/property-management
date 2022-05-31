package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

@Id                         //in order to make something as primary key column we have to tell the JPA that this the annotation @Id
@GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;            //this column act as a primary key column of our table
    @Column(name = "PROPERTY_TITLE",nullable = false)
    private String title;
    private String descripition;
    private String ownerName;
    @Column(name = "EMAIL",nullable = false)
    private String ownerEmail;
    private Double price;
    private String address;



}
