package com.zadd.controller;

import com.zadd.common.annotation.DontResult;
import com.zadd.ro.TestRO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public Object test(@Validated TestRO ro) {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "hello");
        map.put("name", ro.getName());
        return map;
    }

    @GetMapping("/test2/{name}")
    @DontResult
    public Object test2(@PathVariable("name") String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "hello");
        map.put("name2", name);
        return map;
    }
}
