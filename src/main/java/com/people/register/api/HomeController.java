package com.people.register.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home() {
        String helloMessage = "<h2>Hello, guys!</h2><br/>";
        helloMessage += "<b>To get access to repository check <a href=\"http://people-register.herokuapp.com/source\">this</a>.</b><br/>";
        helloMessage += "<b>To access API documentation check <a href=\"http://people-register.herokuapp.com/swagger-ui.html\">this</a>.</b>";
        return helloMessage;
    }

    @GetMapping("source")
    @ApiOperation(value = "Service to get URL to source code repository")
    public String source() {
        return "https://github.com/godoineto/register";
    }
}
