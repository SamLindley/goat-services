package com.psandchill.controller;

import com.psandchill.model.Artist;
import com.psandchill.model.ArtistRating;
import com.psandchill.repo.ArtistRatingsRepo;
import com.psandchill.repo.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class ArtistController {

    @Autowired
    private ArtistRepo artistRepo;

    @Autowired
    private ArtistRatingsRepo artistRatingsRepo;

    @GetMapping(value = "/artists")
    public ArrayList<Artist> findAllArtists(){
        ArrayList<Artist> artists = (ArrayList<Artist>) artistRepo.findAll();
        for (Artist artist :
                artists) {
            artist.setAverages();
        }
        return artists;
    }

    @PostMapping(value = "/rating/{id}")
    public ArtistRating addRating(@RequestBody ArtistRating artistRatings,
                                  @PathVariable Long id){
        artistRatings.setArtist(artistRepo.findById(id));
        return artistRatingsRepo.save(artistRatings);

    }

    @GetMapping(value = "/artists/{id}")
    public Artist findArtist(@PathVariable Long id) {
        return artistRepo.findById(id);
    }

}
