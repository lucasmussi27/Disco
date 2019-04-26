package com.java.disco.dto;

import Lombok.Data;
import Lombok.Builder;

@Data
@Builder
public class ArtistDTO {
    private int id;
    private String name;
    private String genre;

    public void setName(String name) throws Exception {
        if(name.length() < 2)
            throw new Exception("You've choosen a short name for the artist name!");
        this.name = name;
    }

    public void setGenre(String genre) throws Exception {
        if(genre.length() < 3)
            throw new Exception("You've choosen a short name for the artist genre");
        this.genre = genre;
    }
}