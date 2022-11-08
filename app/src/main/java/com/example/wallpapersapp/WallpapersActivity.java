package com.example.wallpapersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class WallpapersActivity extends AppCompatActivity {

    Dialog dialog;
    ImageView imageView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpapers);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("imagename"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = (ImageView)findViewById(R.id.wallpaper);
        TextView textView = (TextView)findViewById(R.id.wallpapertext);

        imageView.setImageResource(getIntent().getIntExtra("image",0));
        textView.setText(getIntent().getStringExtra("imagename"));

        Button button = findViewById(R.id.applybtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });


    }

    public void dialog(){
        dialog = new Dialog(WallpapersActivity.this);
        dialog.setContentView(R.layout.setwallpaperdialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        Button home = dialog.findViewById(R.id.homebtn);
        Button lock = dialog.findViewById(R.id.lockbtn);
        Button homelock = dialog.findViewById(R.id.homelockbtn);

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView.getDrawable();
        bitmap = bitmapDrawable.getBitmap();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(getApplicationContext(),"Wallpaper Set",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });

        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        wallpaperManager.setBitmap(bitmap, null, false, WallpaperManager.FLAG_LOCK);
                    }
                    Toast.makeText(getApplicationContext(), "Wallpaper Set", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });

        homelock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        wallpaperManager.setBitmap(bitmap, null , false, WallpaperManager.FLAG_LOCK);
                    }
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(getApplicationContext(), "Wallpaper Set", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        dialog.show();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
// Respond to the action bar's Up/Home button
            case android.R.id.home:
                super.onBackPressed();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}