package chapter1.kai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/filter")
    public String index() {
        return "Hello, Filter";
    }
}
