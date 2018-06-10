package com.davissylvester.musicalstructuralappjava.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davissylvester.musicalstructuralappjava.Adapters.ArtistAdapter;
import com.davissylvester.musicalstructuralappjava.Adapters.SongAdapter;
import com.davissylvester.musicalstructuralappjava.DomainClasses.Artist;
import com.davissylvester.musicalstructuralappjava.DomainClasses.Song;
import com.davissylvester.musicalstructuralappjava.R;
import com.davissylvester.musicalstructuralappjava.Services.Data.MusicListingService;


import java.util.List;


public class ArtistFragment extends Fragment {

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    private List<Artist> data;

    public ArtistFragment() {

        data = new MusicListingService().Artists;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_artist, container, false);
        mRecycleView = view.findViewById(R.id.rvTracks);

        setDefaults(view);

        return view;
    }

    private void setDefaults(View view) {

        mAdapter = new ArtistAdapter(data, getContext());

        mlayoutManager = new LinearLayoutManager(getContext());

        mRecycleView.setAdapter(mAdapter);

        mRecycleView.hasFixedSize();

        mRecycleView.setLayoutManager(mlayoutManager);

        }
    }


