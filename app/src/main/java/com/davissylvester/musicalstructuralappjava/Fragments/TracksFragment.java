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
import com.davissylvester.musicalstructuralappjava.DomainClasses.Song;
import com.davissylvester.musicalstructuralappjava.R;
import com.davissylvester.musicalstructuralappjava.Services.Data.MusicListingService;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TracksFragment extends Fragment {

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    private List<Song> data;

    public TracksFragment() {
        data = new MusicListingService().Songs;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_tracks, container, false);

        // ArtistAdapter.ViewHolder vh = new ArtistAdapter.ViewHolder(v);
        new ArtistAdapter.ViewHolder(v);
        setDefaults(v);
        return v;
    }

    private void setDefaults(View view) {

        mRecycleView = view.findViewById(R.id.rvArtist);

        mAdapter = new SongAdapter(data);

        mlayoutManager = new LinearLayoutManager(getContext());

        mRecycleView.setAdapter(mAdapter);

        mRecycleView.hasFixedSize();
        mRecycleView.setLayoutManager(mlayoutManager);

    }


}
