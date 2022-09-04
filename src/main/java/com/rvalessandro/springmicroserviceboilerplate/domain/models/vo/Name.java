package com.rvalessandro.springmicroserviceboilerplate.domain.models.vo;

import lombok.Getter;

@Getter
public class Name {
    private String value;

    public Name(String name)  {
//        if(name.length() > 30) {
//            throw new Exception("Name is too long");
//        }
//        if (name.length() < 1) {
//            throw new Exception("Name is too short");
//        }

        value = name;
    }
}
