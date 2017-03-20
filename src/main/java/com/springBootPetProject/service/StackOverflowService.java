package com.springBootPetProject.service;

import com.springBootPetProject.model.StackOverflowWebsite;
import com.springBootPetProject.persistence.StackoverflowWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nolik on 19.03.17.
 */

@Service
public class StackOverflowService {

    @Autowired
    private StackoverflowWebsiteRepository stackoverflowWebsiteRepository;


    //it's bed style, but it's for show
//    private static List<StackOverflowWebsite> items = new ArrayList<>();
//
//    static {
//        items.add(new StackOverflowWebsite("stackoverflow", "http://stackoverflow.com",
//                "http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico", "Stack Overflow (StackExchange)",
//                "for professional adventurist programmers"));
//        items.add(new StackOverflowWebsite("serverfault", "http://serverfault.com",
//                "http://cdn.sstatic.net/Sites/serverfault/img/favicon.ico", "Stack Overflow (StackExchange)",
//                "for professional adventurist programmers"));
//    }
//
//    @PostConstruct
//    public void init(){
//        stackoverflowWebsiteRepository.save(items);
//    }

    public List<StackOverflowWebsite> findAll() {
        return stackoverflowWebsiteRepository.findAll();
    }
}
