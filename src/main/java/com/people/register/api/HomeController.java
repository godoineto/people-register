package com.people.register.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public void home() {}

    @GetMapping("source")
    public String source() {
        return "https://github.com/godoineto/register";
    }
}
