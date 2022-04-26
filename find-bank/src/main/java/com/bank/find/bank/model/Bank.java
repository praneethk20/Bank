package com.bank.find.bank.model;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
public class Bank {
   private Integer Id;
   private String name;
   private String type;
   private String city;
   private String state;
   private Integer zipCode;

}
