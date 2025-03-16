package com.exercise.poke.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpriteDto {

    @JsonProperty("front_default")
    private String frontDefault;

    public SpriteDto(){}

    public SpriteDto(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

}
