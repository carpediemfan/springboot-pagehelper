package com.fyytest.repageinfo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public Integer id;
    public String name;
    public String pwd;
    public String perms;
}
