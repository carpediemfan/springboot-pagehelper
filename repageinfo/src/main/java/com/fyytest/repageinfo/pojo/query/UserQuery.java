package com.fyytest.repageinfo.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery {
    public Integer pageNum = 1;
    public Integer pageSize =2;
    public String name;
}
