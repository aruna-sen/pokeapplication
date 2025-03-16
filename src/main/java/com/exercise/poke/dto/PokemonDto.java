package com.exercise.poke.dto;


public class PokemonDto {

    private String name;
    private String imageUrl;

    public PokemonDto(){}
    public PokemonDto(String name,String imageUrl){
        this.name=name;
        this.imageUrl=imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }*/

public String getImageUrl() {
    return imageUrl;
}

public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
}


}
