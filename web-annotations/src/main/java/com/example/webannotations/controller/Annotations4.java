package com.example.webannotations.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
public class Annotations4 {

    @ResponseBody
    @RequestMapping(path = "/home4", method = RequestMethod.GET)
    public String home4(@RequestParam(name = "myVar", defaultValue = "no value")String var1) {
        log.error("in hom4 controller");
        return Optional.of(var1).orElse("No value entered");
    }
}
