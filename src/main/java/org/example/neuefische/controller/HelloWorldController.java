package org.example.neuefische.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {

    // GET /api/hello
    @GetMapping()
    public String helloWorld(@RequestParam("sort") String sort) {
        return "Hello World " + sort ;
    }

    // GET /api/hello/id
    @GetMapping("/{id}")
    public String helloWorld2(@PathVariable String id) {
        return "Hello " + id;
    }
}
