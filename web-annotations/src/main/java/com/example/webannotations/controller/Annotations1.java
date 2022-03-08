package com.example.webannotations.controller;
/**
 * In this controller we use @RequestMapping at method level
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller// Auto-detect implementations classes by scanning the classpath
public class Annotations1 {
    @RequestMapping(value = "annotations1/home", method = RequestMethod.GET)
    public String home() {
        log.info("Processing: Annotation.home");
        return "nextViewName";
    }
}
