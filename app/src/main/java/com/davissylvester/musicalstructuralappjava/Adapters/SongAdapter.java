package com.davissylvester.musicalstructuralappjava.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davissylvester.musicalstructuralappjava.DomainClasses.Song;
import com.davissylvester.musicalstructuralappjava.R;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private List<Song> data;
    private Context context;


    public SongAdapter(List<Song> songs, Context ctx)  {
        data = songs;
        context = ctx;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.artist_item, parent, false);

        ViewHolder vh = new SongAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        holder.bindSong(data.get(position), context);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView artistImage;
        TextView txtArtistName;
        TextView txtStageName;

        public ViewHolder(View itemView) {
            super(itemView);

            artistImage = itemView.findViewById(R.id.artistPic);
            txtArtistName = itemView.findViewById(R.id.txtArtistName);
            txtStageName = itemView.findViewById(R.id.txtStageName);

        }

        public void bindSong(Song song, Context context) {

            int resourceId = context.getResources().getIdentifier(song.Artist.Photo,
                    "drawable",
                    context.getPackageName());

            artistImage.setImageResource(resourceId);

            txtArtistName.setText("${song.Artist.FirstName} ${song.Artist.LastName}");
            txtStageName.setText(song.Name);
        }
    }
}
