package com.springBootPetProject.persistence;

import com.springBootPetProject.model.StackOverflowWebsite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nolik on 20.03.17.
 */

@Repository
public interface StackoverflowWebsiteRepository extends MongoRepository<StackOverflowWebsite, String> {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//    public List<StackOverflowWebsite> findAll() {
//        return mongoTemplate.findAll(StackOverflowWebsite.class);
//    }

}
