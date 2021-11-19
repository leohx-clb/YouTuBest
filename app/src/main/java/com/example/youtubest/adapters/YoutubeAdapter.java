package com.example.youtubest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubest.R;
import com.example.youtubest.pojos.YoutubeVideo;

import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.YoutubeViewHolder> {

    private List<YoutubeVideo> youtubeVideos;

    private OnItemClickListener onItemClickListener;

    // basé sur le layout de l'item
    public class YoutubeViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitre;
        public TextView tvDescription;
        public TextView tvURL;
        public TextView tvCategorie;

        public YoutubeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitre = itemView.findViewById(R.id.tvTitre);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvURL = itemView.findViewById(R.id.tvURL);
            tvCategorie = itemView.findViewById(R.id.tvCategorie);
        }

    }
    // construteur qui reseigne la liste de todos
    public YoutubeAdapter(List<YoutubeVideo> youtubeVideos, OnItemClickListener onItemClickListener){
        this.youtubeVideos = youtubeVideos;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //crée l'object vue à partir du layout servant à afficher un item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.youtube_item, parent, false);
        return  new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, int position) {

        //récupére L'objet todo qui à l'index en cours
        YoutubeVideo youtubeVideo = youtubeVideos.get(position);

        // bind les données qui proviennent de l'objet todo dans les éléments de la vue
        holder.tvTitre.setText(youtubeVideo.getTitre());
        holder.tvDescription.setText(youtubeVideo.getDescription());
        holder.tvURL.setText(youtubeVideo.getUrl());
        holder.tvCategorie.setText(youtubeVideo.getCategorie());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(youtubeVideo);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // retourn le nombre d'élément de la liste de todos
        return youtubeVideos.size();
    }

    public interface OnItemClickListener {
        void onItemClick(YoutubeVideo youtubeVideo);
    }


}
