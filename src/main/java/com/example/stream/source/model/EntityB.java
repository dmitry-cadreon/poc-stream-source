package com.example.stream.source.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityB {
    @JsonProperty("field.string")
    private String fieldString;
}
