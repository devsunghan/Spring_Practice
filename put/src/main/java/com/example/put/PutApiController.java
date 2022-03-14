package com.example.put;

import com.example.put.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public void put(@RequestBody PutRequestDto request, @PathVariable(name = "userId") Long id) {
        System.out.println(id);
        return request;
    }

}
