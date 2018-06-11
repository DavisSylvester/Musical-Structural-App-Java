package com.davissylvester.musicalstructuralappjava.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davissylvester.musicalstructuralappjava.ArtistDetail;
import com.davissylvester.musicalstructuralappjava.DomainClasses.Artist;
import com.davissylvester.musicalstructuralappjava.R;

import java.util.List;


public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {

    private Context context;
    private List<Artist> data;

    public ArtistAdapter(List<Artist> artists, Context ctx) {
        data = artists;
        context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.artist_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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

        private void bindSong(Artist artist, Context context) {

            int resourceId = context.getResources().getIdentifier(artist.Photo,
                    "drawable",
                    context.getPackageName());

            artistImage.setImageResource(resourceId);

            txtArtistName.setText("" + artist.FirstName + " " + artist.LastName);
            txtStageName.setText(artist.StageName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ArtistDetail.class);
                    intent.putExtra("DATA_ARTIST", artist);
                    context.startActivity(intent);

                }
            });


        }
    }
}
