package com.exercise.poke.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonAbilityDto {
    private AbilityDto ability;

    public PokemonAbilityDto(){}
    public PokemonAbilityDto(AbilityDto ability) {
        this.ability = ability;
    }

    public AbilityDto getAbility() {
        return ability;
    }

    public void setAbility(AbilityDto ability) {
        this.ability = ability;
    }


}
