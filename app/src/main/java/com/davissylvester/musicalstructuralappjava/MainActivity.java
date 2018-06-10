package com.davissylvester.musicalstructuralappjava;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


import com.davissylvester.musicalstructuralappjava.Fragments.ArtistFragment;
import com.davissylvester.musicalstructuralappjava.Fragments.TracksFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navMenu;
    FragmentManager gls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navMenu = findViewById(R.id.fragBottomNav);
        gls = getSupportFragmentManager();


        navMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_artist:
                        ArtistFragment af = new ArtistFragment();
                        startFragment(af);
                        return true;

                    case R.id.nav_tracks:
                        TracksFragment tf = new TracksFragment();
                        startFragment(tf);
                        return true;
                }
                return false;
            }
        });

        StartInitialFragment();

    }

    private <T extends Fragment>  void startFragment(T frag) {

        gls.beginTransaction()
                .replace(R.id.csMainContainer, frag)
                .commit();
    }

    private void StartInitialFragment() {
        ArtistFragment tracks = new ArtistFragment();
        startFragment(tracks);
    }




}
