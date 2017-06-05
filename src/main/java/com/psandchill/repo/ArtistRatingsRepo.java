package com.psandchill.repo;

import com.psandchill.model.ArtistRating;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRatingsRepo extends CrudRepository<ArtistRating, Long> {
}
