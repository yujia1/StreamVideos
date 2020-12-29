package com.laioffer.jupiter.entity;//package com.laioffer.jupiter.entity;
//
//public class Game {
//    private String name;
//    private String develop;
//    private int price;
//    public Game(){}
//    public Game(gameBuilder gameBuilder) {
//        this.name = gameBuilder.name;
//        this.develop = gameBuilder.develop;
//        this.price = gameBuilder.price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDevelop() {
//        return develop;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//
//    //nest class
//    public static class gameBuilder{
//        private String name;
//        private String develop;
//        private int price;
//
//        public void setName(String name) {
//            this.name = name;
//        }
//        public void setDevelop(String develop) {
//            this.develop = develop;
//        }
//        public void setPrice(int price) {
//            this.price = price;
//        }
//        public Game build(){
//            return new Game(this);
//        }
//    }
//
//    public static void main(String[] args) {
//        gameBuilder gameBuilder = new gameBuilder();
//        gameBuilder.setName("yujia");
//        gameBuilder.setDevelop("laioffer");
//        gameBuilder.setPrice(10);
//        gameBuilder.setName("aoqi");
//        Game game1 = gameBuilder.build();
//
//        System.out.println(game1.name);
//    }
//}

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * jackson can convert json to object
 * */

@JsonIgnoreProperties(ignoreUnknown = true) // unknow 就不convert
@JsonInclude(JsonInclude.Include.NON_NULL) // null dont convet
@JsonDeserialize(builder = Game.Builder.class) // use builder to create object

public class Game {
    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("box_art_url")
    private final String boxArtUrl;
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBoxArtUrl() {
        return boxArtUrl;
    }
    private Game(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.boxArtUrl = builder.boxArtUrl;
    }
    @JsonIgnoreProperties(ignoreUnknown = true) // unknow 就不convert
    @JsonInclude(JsonInclude.Include.NON_NULL) // null dont convet
    public static class Builder {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("box_art_url")
        private String boxArtUrl;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder boxArtUrl(String boxArtUrl) {
            this.boxArtUrl = boxArtUrl;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
