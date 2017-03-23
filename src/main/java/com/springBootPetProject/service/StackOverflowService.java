package com.springBootPetProject.service;

import com.google.common.collect.ImmutableList;
import com.springBootPetProject.model.SiteDTO;
import com.springBootPetProject.model.StackOverflowWebsite;
import com.springBootPetProject.persistence.StackoverflowWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Created by nolik on 19.03.17.
 */

@Service
public class StackOverflowService {

    @Autowired
    private StackoverflowWebsiteRepository stackoverflowWebsiteRepository;

    @Autowired
    private StackExchangeClient stackExchangeClient;


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

    /**
     *  Service method for finding all information about StackOverFlowSites from MongoDB.
     *
     * @return List of StackOverflowWebsites
     */
    public List<StackOverflowWebsite> findAllFromDB() {
        return stackoverflowWebsiteRepository.findAll();
    }

    /**
     * Service method for finding all information about StackOverFlowSites through StackExchangeClient.
     *
     * @return List of StackOverflowWebsites
     */
    public List<StackOverflowWebsite> findAllFromStackExchangeClient() {
        return stackExchangeClient.getSites().stream()
                .map(this::toStackoverflowWebsite)
                .filter(this::ignoreMeta)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(StackOverflowWebsite stackoverflowWebsite) {
        return !stackoverflowWebsite.getId().startsWith("meta.");
    }

    private StackOverflowWebsite toStackoverflowWebsite(SiteDTO input) {
        return new StackOverflowWebsite(
                input.getSite_url().substring("http://".length(), input.getSite_url().length() - ".com".length()),
                input.getSite_url(),
                input.getFavicon_url(),
                input.getName(),
                input.getAudience());
    }
}
