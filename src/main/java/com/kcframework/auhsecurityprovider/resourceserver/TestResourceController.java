/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.resourceserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jayan
 */
@RestController
public class TestResourceController {

    @RequestMapping("/sayHello/{name}")
    public String HellowController(@RequestParam("name") String name) {
        return "Hello this is " + name;
    }

}
