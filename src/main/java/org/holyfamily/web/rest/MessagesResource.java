package org.holyfamily.web.rest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Controller for retrieving messages at runtime.
 */
@RestController
@RequestMapping("/messages")
public class MessagesResource {

    private
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getMessage(@RequestParam(name = "messageKey") String messageKey, @RequestParam(name = "locale", defaultValue = "en_US") Locale locale) {
        String retVal = getMessageSource().getMessage(messageKey, new Object[]{}, locale);
        if (StringUtils.isBlank(retVal)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok().body(retVal);
        }
    }


    public MessageSource getMessageSource() {
        return messageSource;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
