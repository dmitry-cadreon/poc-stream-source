package com.example.stream.source;

import com.example.stream.source.model.Campaign;
import com.example.stream.source.model.EntityA;
import com.example.stream.source.model.EntityB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Random;

@Slf4j
@Service
public class CampaignController {
    private Random r = new Random();

    @Autowired
    private MultiOutputSource source;


    @Scheduled(fixedRate = 5000)
    public void doWork(){
        this.sendMessage(Math.floorMod(r.nextInt(10) + 1, 2));
    }

    public void sendMessage(int i){
        if(i == 0)
            source.dsp1out().send(this.generateMessage(1));
        else
            source.dsp2out().send(this.generateMessage(2));
    }

    private GenericMessage<Campaign> generateMessage(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.OCTOBER, 15, 0,0,0);
        Campaign c = Campaign.builder()
            .date(calendar.getTime())
            .entityA(EntityA.builder().fieldInt(9999).build()) // new Random().nextInt(10 * n) + 1
            .entityB(EntityB.builder().fieldString("Random String").build()) //String.format("Random String #%d",new Random().nextInt(10 * n) + 1)
            .build();
        log.info("[x]DSP{} -> Sending campaign: {}",n,c);
        return new GenericMessage<>(c);
    }

}
