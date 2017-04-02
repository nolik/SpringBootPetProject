package com.springBootPetProject.service;

import com.google.common.collect.ImmutableList;
import com.springBootPetProject.model.StackOverflowWebsite;
import com.springBootPetProject.persistence.StackoverflowWebsiteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nolik on 29.03.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class StackOverflowServiceTest {
    @Mock
    private StackoverflowWebsiteRepository stackoverflowWebsiteRepository;

    /**
     * Just testing calling of Repository calling.
     *
     * @throws Exception
     */
    @Test
    public void findAllFromDB() throws Exception {
        //prepare
        when(stackoverflowWebsiteRepository.findAll()).thenReturn(ImmutableList.of());
        //testing call
        List<StackOverflowWebsite> stackOverflowWebsiteList = stackoverflowWebsiteRepository.findAll();
        //validate
        verify(stackoverflowWebsiteRepository).findAll();
    }

    @Test
    public void forEverySitesStoredInDB() {
        //prepare
        StackOverflowWebsite stackOverflowWebsiteFirst = new StackOverflowWebsite(
                "first",
                "http://stackoverflow.com",
                "https://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
                "Stack Overflow",
                "professional and enthusiast programmers");
        StackOverflowWebsite stackOverflowWebsiteSecond = new StackOverflowWebsite(
                "second",
                "http://stackoverflow.com",
                "https://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
                "Stack Overflow",
                "professional and enthusiast programmers");

        List<StackOverflowWebsite> stackOverflowWebsiteList = new ArrayList<>();
        stackOverflowWebsiteList.add(stackOverflowWebsiteFirst);
        stackOverflowWebsiteList.add(stackOverflowWebsiteSecond);


        //testing call
        when(stackoverflowWebsiteRepository.save(notNull(List.class)))
                .thenReturn(stackOverflowWebsiteList);
//        when(stackoverflowWebsiteRepository.findAll()).thenReturn(stackOverflowWebsiteList);
        //assert
//        assertThat(stackoverflowWebsiteRepository.save(stackOverflowWebsiteFirst),
//                is(stackOverflowWebsiteFirst));
        assertThat(stackoverflowWebsiteRepository.save(stackOverflowWebsiteList),is(stackOverflowWebsiteList));
    }


    @Test
    public void ifNoSitesPassedEmptyListIsReturned() {
        assertThat(stackoverflowWebsiteRepository.insert(Collections.emptyList()), is(empty()));
    }

    @Test
    public void findAllFromStackExchangeClient() throws Exception {
        //TODO: realise this test
    }
}