package com.dyne.viid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author cm_fighting
 * @create 2022-06-22 上午10:32
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello 1400";
    }

    @GetMapping("/VIID/hello")
    public String helloViid() {
        return "hello viid";
    }

}
