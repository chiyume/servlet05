package com.chiyume.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private int roleId;
    private String userName;
    private String password;
    private String trueName;
    private String gender;
    private String phone;
    private String address;
    private String identity;
    private int status;
}
