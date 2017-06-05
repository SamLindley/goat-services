package com.psandchill.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ArtistRating {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    private Double flow;
    private Double wordplay;

    public ArtistRating() {
    }

    public ArtistRating(Artist artist, Double flow, Double wordplay) {
        this.artist = artist;
        this.flow = flow;
        this.wordplay = wordplay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getWordplay() {
        return wordplay;
    }

    public void setWordplay(Double wordplay) {
        this.wordplay = wordplay;
    }
}
