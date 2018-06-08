package com.davissylvester.musicalstructuralappjava.Services.Data;

import com.davissylvester.musicalstructuralappjava.DomainClasses.Artist;
import com.davissylvester.musicalstructuralappjava.DomainClasses.Song;

import java.util.ArrayList;
import java.util.List;

public class MusicListingService  {

    public List<Artist> Artists;
    public List<Song>  Songs;

    public MusicListingService() {
        this.Songs = populateSongList();
        this.Artists = populateArtistList();
    }

    private List<Song> populateSongList() {

        List<Song> result = new ArrayList();

        result.add(new Song("Little Red Corvette", new Artist("Prince", "", "prince", "Prince"), "R&B", "https://www.youtube.com/watch?v=v0KpfrJE4zw"));
        result.add(new Song("Diamonds and Pearls", new Artist("Prince", "", "prince", "Prince"), "R&B", "https://www.youtube.com/watch?v=hwUKR_9Xdns" ));
        result.add(new Song("Take Me With U", new Artist("Prince", "", "prince", "Prince"), "R&B", "https://www.youtube.com/watch?v=c80mYF6dR7s" ));
        result.add(new Song("1999", new Artist("Prince", "", "prince", "Prince"), "R&B", "https://www.youtube.com/watch?v=rblt2EtFfC4" ));
        result.add(new Song("Raspberry Beret", new Artist("Prince", "", "prince", "Prince"), "R&B", "https://www.youtube.com/watch?v=l7vRSu_wsNc" ));
        result.add(new Song("International Lover", new Artist("Prince", "", "prince", "Prince"), "R&B", "https://www.youtube.com/watch?v=vuaj8ExTYOM" ));

        result.addAll(populateJayZSongs());
        result.addAll(populateDMXSongs());
        result.addAll(populateNASSongs());


        return result;
    }

    private List<Artist> populateArtistList() {

        List<Artist> result = new ArrayList();

        result.add(new Artist("Prince", "Nelson", "prince", "Prince"));
        result.add(new Artist("Earl", "Simmons", "dmx", "DMX"));
        result.add(new Artist("Nasir", "Jones", "nas", "NAS"));
        result.add(new Artist("Shawn", "Carter", "jayz", "Jay Z"));

        return result;
    }

    private List<Song> populateJayZSongs() {

        List<Song> result = new ArrayList();

        result.add(new Song("Dead Presidents", new Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "https://www.youtube.com/watch?v=6BCsxQg3NE4" ));
        result.add(new Song("Big Pimpin", new Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "https://www.youtube.com/watch?v=Cgoqrgc_0cM" ));
        result.add(new Song("Girls, Girls, Girls", new Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "https://www.youtube.com/watch?v=XhpVo23zC6Q" ));
        result.add(new Song("Holy Grail", new Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "https://www.youtube.com/watch?v=a6T5azW4qEA" ));
        result.add(new Song("03 Bunny and Clyde", new Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "https://www.youtube.com/watch?v=xm0Xba8eFTg" ));
        result.add(new Song("Jigga What, Jigga Who", new Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "https://www.youtube.com/watch?v=frIA7tuBqqY" ));
        result.add(new Song("Hard Knock Life", new Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "https://www.youtube.com/watch?v=VF-5uZ4krHE" ));

        return result;
    }

    private List<Song> populateDMXSongs() {

        List<Song> result = new ArrayList();

        result.add(new Song("X Gon Give it to Ya",  new Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "https://www.youtube.com/watch?v=fGx6K90TmCI" ));
        result.add(new Song("Where the Hood at", new Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "https://www.youtube.com/watch?v=6CqXgs-7ico" ));
        result.add(new Song("Get At me Dawg", new Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "https://www.youtube.com/watch?v=oM_lFtEFidA" ));
        result.add(new Song("Dog", new Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "https://www.youtube.com/watch?v=X_GT1MREo18"));
        result.add(new Song("What these Bitches Want", new Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "https://www.youtube.com/watch?v=nEwc29VaUYg" ));
        result.add(new Song("No Sunshine", new Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "https://www.youtube.com/watch?v=TEejWL5OVcM" ));
        result.add(new Song("X-Is COming", new Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "https://www.youtube.com/watch?v=_4q-TFd5SfU"));

        return result;
    }

    private List<Song> populateNASSongs(){

        List<Song> result = new ArrayList();

        result.add(new Song("One Mic", new Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "https://www.youtube.com/watch?v=JCOURZ-yx4E"));
        result.add(new Song("The Whole is Yours", new Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "https://www.youtube.com/watch?v=_srvHOu75vM"));
        result.add(new Song("Hate me Now", new Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "https://www.youtube.com/watch?v=n2-rN-98kFQ"));
        result.add(new Song("One Love", new Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "https://www.youtube.com/watch?v=hxce_qvhi5I"));
        result.add(new Song("Get Down", new Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "https://www.youtube.com/watch?v=cS_bDnxCnkc"));

        return result;
    }
}
