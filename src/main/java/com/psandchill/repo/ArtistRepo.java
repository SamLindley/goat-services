package com.psandchill.repo;

import com.psandchill.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepo extends CrudRepository<Artist, Long>{
    Artist findById(Long id);
}
