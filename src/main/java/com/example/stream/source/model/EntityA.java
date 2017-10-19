package com.example.stream.source.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityA {
    @JsonProperty("field.int")
    private int fieldInt;
}
