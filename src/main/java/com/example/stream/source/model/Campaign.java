package com.example.stream.source.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Data
@Builder
public class Campaign {
    @JsonProperty("start.date")
    private Date date;
    @JsonProperty("entity.a")
    private EntityA entityA;
    @JsonProperty("entity.b")
    private EntityB entityB;

    public String getDate() {
        if(this.date != null) {
            log.info("[x]Date in campaign: {}", date);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            return df.format(this.date);
        }
        return null;
    }
}
