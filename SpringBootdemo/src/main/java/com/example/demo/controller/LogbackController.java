package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {
    private final static Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @RequestMapping("/logger")
    public String home() {
        logger.info("logback 访问hello");
        logger.error("logback 访问hello");
        return "Hello World!";
    }
}