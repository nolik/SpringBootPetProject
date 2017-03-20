package com.springBootPetProject.web;

import com.springBootPetProject.model.StackOverflowWebsite;
import com.springBootPetProject.service.StackOverflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nolik on 19.03.17.
 */

@RestController
public class StackOverflowController {

    @Autowired
    private StackOverflowService stackOverflowService;

    @RequestMapping(value = "/api/stackoverflow/", method = RequestMethod.GET)
    public List<StackOverflowWebsite> getListOfWebSites() {


        return stackOverflowService.findAll();
    }
}
