package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String GetHello() {
        return "get hello";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET) // 이렇게 해도 되는데 이러면 GET/POST/PUT 다 돌아감
    public String hi() {
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{name} 을 받아볼 거
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id")String pathName) {
        System.out.println("PathVariable : "+pathName);
        return pathName;
    }

    // http://localhost:8080:/api/get/query-param?user=steve&email=steve@gmail.com&age=39
    @GetMapping(path ="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();

            sb.append(entry.getKey() + " = " + entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }

}
