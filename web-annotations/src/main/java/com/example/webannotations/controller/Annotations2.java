package com.example.webannotations.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Combining @RequestMapping at class level and method level
 */
@Slf4j
@Controller
@RequestMapping(value="/annotations2", method = RequestMethod.GET)
public class Annotations2 {
    @RequestMapping("/home")
    public @ResponseBody String home() {
        log.info("Processing: Annotations2.home");
        return "viewName";
    }
    @RequestMapping("/home2")
    public @ResponseBody String home2() {
        log.info("Processing Annotations2.home2");
        return "viewName2";
    }
}