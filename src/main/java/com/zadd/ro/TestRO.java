package com.zadd.ro;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class TestRO {

    @Length(min = 10, message = "name's length must over 10")
    private String name;
}
