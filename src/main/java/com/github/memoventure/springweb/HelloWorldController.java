package com.github.memoventure.springweb;
import org.springframework.web.bind.annotation.*;

@RestController // Indicates that the class is a controller capable of handling
// HTTP requests and combines the @Controller and @ResponseBody annotations
// to facilitate returning data as HTTP responses.
@RequestMapping("/api") // Assigns a URL path to a method or controller -
// in this case, /api is considered as the prefix for the class endpoints.
public class HelloWorldController {
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello my beloved World";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloWithName(@PathVariable String name)
    {
        return "Hello my beloved " + name;
    }
}
