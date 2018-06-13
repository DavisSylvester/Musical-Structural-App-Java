package com.davissylvester.musicalstructuralappjava;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.davissylvester.musicalstructuralappjava.Adapters.ArtistProfileAdapter;
import com.davissylvester.musicalstructuralappjava.DomainClasses.AppConfig;
import com.davissylvester.musicalstructuralappjava.DomainClasses.Artist;
import com.davissylvester.musicalstructuralappjava.DomainClasses.Song;
import com.davissylvester.musicalstructuralappjava.Services.Data.MusicListingService;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.List;
import java.util.stream.Collectors;


public class ArtistDetail extends AppCompatActivity {

    private List<Song> SongsByArtist;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private YouTubePlayerSupportFragment vv;
    private YouTubePlayer.OnInitializedListener youTubeListener;
    private YouTubePlayer player;

    private final static List<Song> allSongs = new MusicListingService().Songs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);

        Intent i = getIntent();

        Artist artist = i.getParcelableExtra("DATA_ARTIST");
        BindToView(artist);

        Log.d("FINDME", artist.toString());

        this.SongsByArtist = PopulateSongsByArtist(artist.StageName);

        setDefaults();




    }

    private void setDefaults() {

        mRecycleView = findViewById(R.id.rvSongs);

        vv = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.vPlayer);



        youTubePlayerInit();

        mAdapter = new ArtistProfileAdapter(SongsByArtist, this);

        mlayoutManager = new LinearLayoutManager(this);

        mRecycleView.setAdapter(mAdapter);

        mRecycleView.hasFixedSize();

        mRecycleView.setLayoutManager(mlayoutManager);
    }

    private List<Song> PopulateSongsByArtist(String stageName) {

         List<Song> test =  allSongs.stream().filter( x -> x.Artist.StageName.toLowerCase().equalsIgnoreCase(stageName.toLowerCase())).collect(Collectors.toList());
//        List<Song> test = new ArrayList();
//
//        for (int i = 0; i < allSongs.size(); i++) {
//            Song s = allSongs.get(i);
//
//            if (s.Artist.StageName.equalsIgnoreCase(stageName))
//                test.add(s);
//        }


        return test;
    }

    private void youTubePlayerInit() {

        youTubeListener = new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

//                            youTubePlayer.loadVideo("vuaj8ExTYOM");
                            player = youTubePlayer;
                            player.loadVideo("vuaj8ExTYOM");
                        }

                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                        }
                    };

                    vv.initialize(AppConfig.getAPI_KEY(), youTubeListener);
    }

    private void BindToView(Artist artist) {

        ImageView artistPic = findViewById(R.id.imgArtist);
        TextView stageName = findViewById(R.id.txtStageName);
        TextView artistName = findViewById(R.id.txtArtistName);


        int resourceId = getResources().getIdentifier(artist.Photo,
                "drawable",
                getPackageName());

        artistPic.setImageResource(resourceId);
        stageName.setText(artist.StageName);
        artistName.setText(artist.FirstName + "" + artist.LastName);


    }

}
