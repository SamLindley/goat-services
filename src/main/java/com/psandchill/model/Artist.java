package com.psandchill.model;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String imageUrl;
    private double flowAverage;
    private double wordplayAverage;
    private double totalScore;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ArtistRating> ratings;

    public Artist() {

    }

    public Artist(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ArtistRating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<ArtistRating> ratings) {
        this.ratings = ratings;
    }

    public double getFlowAverage() {
        return flowAverage;
    }

    public void setFlowAverage(double flowAverage) {
        this.flowAverage = flowAverage;
    }

    public double getWordplayAverage() {
        return wordplayAverage;
    }

    public void setWordplayAverage(double wordplayAverage) {
        this.wordplayAverage = wordplayAverage;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String infoString(){
        String info = "";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.name);

        JSONObject ratingJSON = new JSONObject();

        jsonObject.put("ratings", ratingJSON);

        info = jsonObject.toString();
        return info;

    }

    public String toString(){
        String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);

        JSONArray productArray = new JSONArray();
        if(this.ratings != null){
            this.ratings.forEach(product->{
                JSONObject subJson = new JSONObject();
                subJson.put("flow", product.getFlow());
                subJson.put("wordplay", product.getWordplay());
                productArray.put(subJson);
            });
        }
        jsonInfo.put("ratings", productArray);
        info = jsonInfo.toString();
        return info;
    }

    public void setAverages(){
        double totalW = 0;
        double totalF = 0;
        double count = 0;
        for (ArtistRating ratings :
                ratings) {
            totalF += ratings.getFlow();
            totalW += ratings.getWordplay();
            count++;
        }
        this.flowAverage = totalF/count;
        this.wordplayAverage = totalW/count;
        this.totalScore = (this.flowAverage + this.wordplayAverage) / 2;
    }
}
