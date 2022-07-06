package com.rest.api.two.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/get-greeting")
    public String greetUser() {
        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/user/{name}")
    public String welcomeUser(@PathVariable("name") String userName) {
        String result = messageSource.getMessage("hello.user", null, LocaleContextHolder.getLocale());
        return result + " " + userName;
    }
}
