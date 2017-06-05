package com.psandchill;

import com.psandchill.model.Artist;
import com.psandchill.model.ArtistRating;
import com.psandchill.repo.ArtistRatingsRepo;
import com.psandchill.repo.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class GoatServicesApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepo artistRepo;

	@Autowired
	private ArtistRatingsRepo artistRatingsRepo;

	public static void main(String[] args) {
		SpringApplication.run(GoatServicesApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		clearData();
		saveData();
		showData();
	}

	private void showData() {
		Iterable<Artist> artists = artistRepo.findAll();
		Iterable<ArtistRating> artistRatings = artistRatingsRepo.findAll();

		System.out.println(artists.toString());
		System.out.println(artistRatings.toString());
		for (Artist artist :
				artists) {
			System.out.println(artist.toString());
		}

	}

	@Transactional
	private void saveData() {
		Artist nas = new Artist("Nas");
		Artist biggie = new Artist("Biggie");
		Artist rakim = new Artist("Rakim");
		Artist kendrick = new Artist("Kendrick");
		Artist pac = new Artist("Pac");

		nas.setImageUrl("http://www.clashmusic.com/sites/default/files/field/image/Nas_%C2%A9DannyClinch2.jpg");
		biggie.setImageUrl("https://swh-schoolworkhelper.netdna-ssl.com/wp-content/uploads/2011/08/Biggie-Smalls.jpg?x37075");
		rakim.setImageUrl("https://lastfm-img2.akamaized.net/i/u/770x0/e19cbc1e186e49ae82770847676897cd.jpg");
		kendrick.setImageUrl("http://www.rap-up.com/app/uploads/2015/03/kendrick-lamar-i.jpg");
		pac.setImageUrl("http://cdn.hiphoplead.com/static/2010/09/2pac.jpg");

		ArtistRating nasRatings = new ArtistRating();
		ArtistRating biggieRatings = new ArtistRating();
		ArtistRating pacRatings = new ArtistRating();
		ArtistRating rakimRatings = new ArtistRating();
		ArtistRating kendrickRatings = new ArtistRating();

		nasRatings.setFlow(8.0);
		nasRatings.setWordplay(10.0);
		nasRatings.setArtist(nas);

		biggieRatings.setFlow(10.0);
		biggieRatings.setWordplay(7.0);
		biggieRatings.setArtist(biggie);

		pacRatings.setFlow(8.0);
		pacRatings.setWordplay(6.0);
		pacRatings.setArtist(pac);

		rakimRatings.setFlow(8.0);
		rakimRatings.setWordplay(9.0);
		rakimRatings.setArtist(rakim);

		kendrickRatings.setFlow(8.0);
		kendrickRatings.setWordplay(8.0);
		kendrickRatings.setArtist(kendrick);

		artistRepo.save(nas);
		artistRepo.save(biggie);
		artistRepo.save(rakim);
		artistRepo.save(kendrick);
		artistRepo.save(pac);

		artistRatingsRepo.save(nasRatings);
		artistRatingsRepo.save(biggieRatings);
		artistRatingsRepo.save(rakimRatings);
		artistRatingsRepo.save(kendrickRatings);
		artistRatingsRepo.save(pacRatings);
	}

	@Transactional
	private void clearData() {
		artistRepo.deleteAll();
		artistRatingsRepo.deleteAll();
	}


}
