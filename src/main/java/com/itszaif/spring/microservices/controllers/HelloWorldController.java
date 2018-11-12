package com.itszaif.spring.microservices.controllers;

import com.itszaif.spring.microservices.models.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HelloWorldController
{
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
}
