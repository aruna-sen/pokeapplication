package com.exercise.poke.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonStatsDto {
    @JsonProperty("base_stat")
    private int baseStat;

    private StatDto stat;

    public PokemonStatsDto(){}

    public PokemonStatsDto(int baseStat, StatDto stat) {
        this.baseStat = baseStat;
        this.stat = stat;
    }

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public StatDto getStat() {
        return stat;
    }

    public void setStat(StatDto stat) {
        this.stat = stat;
    }

}
