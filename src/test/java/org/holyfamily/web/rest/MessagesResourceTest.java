package org.holyfamily.web.rest;

import org.holyfamily.HolyfamilyApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HolyfamilyApp.class)
public class MessagesResourceTest {
    private MockMvc restMessagesMockMvc;

    private StaticMessageSource messageSource = new StaticMessageSource();
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        MessagesResource messagesResource = new MessagesResource();
        messagesResource.setMessageSource(messageSource);
        this.restMessagesMockMvc = MockMvcBuilders
            .standaloneSetup(messagesResource)
            .build();
    }

    @Test
    public void getAllLogs()throws Exception {
        String testKey = "testKey";
        String testMessage = "Testing.";
        messageSource.addMessage(testKey, Locale.getDefault(), testMessage);
        restMessagesMockMvc.perform(get("/messages/").param("messageKey", testKey).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
