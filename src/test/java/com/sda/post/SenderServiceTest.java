package com.sda.post;

import org.junit.Assert;
import org.junit.Test;

public class SenderServiceTest {

    @Test
    public void shouldSendNewMessageSuccessfully(){
        //Given:
        SenderService senderService = new SenderService();
        String message = "Hello world";
        String from = "qwerty";
        String to = "abc";


        //When:
        boolean result = senderService.sendMessage(from, to, message);

        //Then:
        Assert.assertTrue("Message was not sent.", result);

    }

}
