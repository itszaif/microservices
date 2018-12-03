package com.itszaif.spring.microservices.controllers;

import com.itszaif.spring.microservices.models.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/users")
public class HelloWorldController
{

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/hello")
    public String getHelloWorld()
    {
        return "Hello World";
    }


    @GetMapping(value = "/hello/bean")
    public HelloWorldBean getHelloWorldBean()
    {
        return new HelloWorldBean("Hell World");
    }

    @GetMapping(value = "/hello/bean/path-variable/{name}")
    public HelloWorldBean getHelloWorldBeanPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hell World, %s", name));
    }

    @GetMapping(value = "/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale)
    {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
