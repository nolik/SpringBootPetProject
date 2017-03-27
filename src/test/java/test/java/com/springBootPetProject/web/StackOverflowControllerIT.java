package test.java.com.springBootPetProject.web;

import com.google.common.collect.ImmutableList;
import com.springBootPetProject.Application;
import com.springBootPetProject.model.StackOverflowWebsite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;

/**
 * Created by nolik on 21.03.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class StackOverflowControllerIT {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void before() {
        mongoTemplate.dropCollection(StackOverflowWebsite.class);
        mongoTemplate.save(new StackOverflowWebsite("website1", "http://stackoverflow.com",
                "http://cdn.sstatic.net/Sites/stackoverf low/img/favicon.ico", "Stack Overflow (StackExchange)",
                "for professional adventurist programmers"));
        mongoTemplate.save(new StackOverflowWebsite("website2", "http://stackoverflow.com",
                "http://cdn.sstatic.net/Sites/stackoverf low/img/favicon.ico", "Stack Overflow (StackExchange)",
                "for professional adventurist programmers"));
    }


  private   TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void getListOfWebSitesFromStackExchange() throws Exception {
        ResponseEntity<List<StackOverflowWebsite>> responseEntity =
                testRestTemplate.exchange("http://localhost:8099/api/stackoverflow/", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<StackOverflowWebsite>>() {
                        });
        List<StackOverflowWebsite> actualList = responseEntity.getBody();

        //validate
        assertThat(actualList.size(), is(2));
        List<String> actualIdList = actualList.stream()
                .map(StackOverflowWebsite::getId)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        assertThat(actualIdList, containsInAnyOrder("website1", "website2"));
    }
}