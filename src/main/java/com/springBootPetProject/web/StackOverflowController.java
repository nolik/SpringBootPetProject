package com.springBootPetProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nolik on 19.03.17.
 */

@Controller
public class StackOverflowController {

    @RequestMapping(value = "/api/stackoverflow/", method = RequestMethod.GET)
    public @ResponseBody
    List<StackOverflowWebsite> getListOfWebSites() {

        List<StackOverflowWebsite> stackOverflowWebsites = null;
        return stackOverflowWebsites;
    }
}
