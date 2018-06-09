package com.davissylvester.musicalstructuralappjava.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davissylvester.musicalstructuralappjava.Adapters.SongAdapter;
import com.davissylvester.musicalstructuralappjava.DomainClasses.Song;
import com.davissylvester.musicalstructuralappjava.R;
import com.davissylvester.musicalstructuralappjava.Services.Data.MusicListingService;


import java.util.List;


public class ArtistFragment extends Fragment {

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    private List<Song> data;

    public ArtistFragment() {

        data = new MusicListingService().Songs;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_artist, container, false);
        View view = inflater.inflate(R.layout.fragment_artist, container, false);
        mRecycleView = view.findViewById(R.id.rvTracks);
        // View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_artist, container, false);
        setDefaults(view);

        return view;
    }

    private void setDefaults(View view) {

        // mRecycleView = findViewById(R.id.rvTracks);

        mAdapter = new SongAdapter(data);

        mlayoutManager = new LinearLayoutManager(getContext());

        mRecycleView.setAdapter(mAdapter);

        mRecycleView.hasFixedSize();
        mRecycleView.setLayoutManager(mlayoutManager);

        }
    }


