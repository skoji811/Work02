package com.example.demo.entity;

import lombok.Data;

@Data 
public class Todo {

    private Long id;

   @NotBlank
    private String task;
}