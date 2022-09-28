package com.chiyume.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    private int roleId;
    private String roleName;
    private String roleDesc;
    private int roleState;
}
