package com.example.stream.source;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMessageVerifier
public class BaseClass {

    @Autowired
    CampaignController controller;

    public void triggerSynchronizeDsp1CampaignMessage(){
        controller.sendMessage(0);
    }

}
