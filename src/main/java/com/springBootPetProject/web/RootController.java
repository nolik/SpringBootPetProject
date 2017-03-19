package com.springBootPetProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nolik on 19.03.17.
 */
@Controller
public class RootController {

    @RequestMapping("/hello")
    public String showHello(){
        return "hello";
    }
}
