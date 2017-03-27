package test.java.com.springBootPetProject.web;

import com.google.common.collect.ImmutableList;
import com.springBootPetProject.model.StackOverflowWebsite;
import com.springBootPetProject.service.StackOverflowService;
import com.springBootPetProject.web.StackOverflowController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nolik on 21.03.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class StackOverflowControllerTest {


    @Mock
    private StackOverflowService stackOverflowService;

    @InjectMocks
    StackOverflowController sut;

        @Test
    public void getListOfWebSitesFromStackExchange() throws Exception {
        //prepare
        when(stackOverflowService.findAllFromStackExchangeClient()).thenReturn(ImmutableList.of());
        //testing call
        List<StackOverflowWebsite> stackOverflowWebsiteList = sut.getListOfWebSitesFromStackExchange();
        //validate
        verify(stackOverflowService).findAllFromStackExchangeClient();
    }

    @Test
    public void getListOfWebSitesFromDB() throws Exception {
        //prepare
        when(stackOverflowService.findAllFromDB()).thenReturn(ImmutableList.of());
        //testing call
        List<StackOverflowWebsite> stackOverflowWebsiteList = sut.getListOfWebSitesFromDB();
        //validate
        verify(stackOverflowService).findAllFromDB();
    }
}