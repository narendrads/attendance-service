package com.ksdc.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private int userId;

    private String userName;

    private String email;

    private String password;
    
    private List<String> roles;
}