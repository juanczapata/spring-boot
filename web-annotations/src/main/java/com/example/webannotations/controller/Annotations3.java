package com.example.webannotations.controller;
/**
 * Class examples of @PathParam
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Slf4j
@Controller
public class Annotations3 {
    @ResponseBody
    @RequestMapping(path = "/home3/{firstName}", method = RequestMethod.GET)
    public String home3(@PathVariable("firstName")String name) {
        return String.format("Welcome %s!", name);
    }

    @ResponseBody
    @RequestMapping(path = "/home3/city/{city}")
    public String home31(@PathVariable String city) {
        return String.format("The city entered is %s", city);
    }

    @ResponseBody
    @RequestMapping(path = "/home3/country/{country}")
    public String home32(@PathVariable(required = false) String country) {
        return String.format("The country entered is %s", Optional.of(country).orElse("None"));
    }
}
