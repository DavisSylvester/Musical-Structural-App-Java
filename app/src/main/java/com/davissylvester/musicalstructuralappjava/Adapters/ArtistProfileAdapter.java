package com.davissylvester.musicalstructuralappjava.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.davissylvester.musicalstructuralappjava.DomainClasses.Song;
import com.davissylvester.musicalstructuralappjava.R;

import java.util.List;

public class ArtistProfileAdapter extends RecyclerView.Adapter<ArtistProfileAdapter.ViewHolder> {

    private List<Song> songs;
    private final Context context;

    public ArtistProfileAdapter(List<Song> songs, Context context) {
        this.songs = songs;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtistProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.profile_artist_song_item, parent, false);

        ViewHolder vh = new ArtistProfileAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindSong(songs.get(position), context);
    }

    @Override
    public int getItemCount() {
        return songs.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSongName;
        // VideoView videoPlayer;


        public ViewHolder(View itemView) {
            super(itemView);
            txtSongName = itemView.findViewById(R.id.txtSongName);
            //videoPlayer = itemView.findViewById(R.id.vPlayer);

        }

        private void bindSong(Song song, Context context) {

            txtSongName.setText(song.Name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        //videoPlayer.setVideoPath(song.Url);
                        //videoPlayer.start();
                }
            });


        }
    }
}
