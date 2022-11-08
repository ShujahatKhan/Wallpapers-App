package com.example.wallpapersapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpapersapp.Models.WallpaperModel;
import com.example.wallpapersapp.R;
import com.example.wallpapersapp.WallpapersActivity;

import java.util.ArrayList;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.viewHolder> {

    ArrayList<WallpaperModel> list;
    Context context;

    public WallpaperAdapter(ArrayList<WallpaperModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperAdapter.viewHolder holder, int position) {
        WallpaperModel wallpaperModel = list.get(position);
        holder.imageView.setImageResource(wallpaperModel.getPic());
        holder.textView.setText(wallpaperModel.getText());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WallpapersActivity.class);
                intent.putExtra("image",wallpaperModel.getPic() );
                intent.putExtra("imagename",wallpaperModel.getText());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
        }
    }

}
