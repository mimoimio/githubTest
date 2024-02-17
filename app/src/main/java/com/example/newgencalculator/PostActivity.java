package com.example.newgencalculator;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.Set;

public class PostActivity extends AppCompatActivity {
    int sizeImagesFolder = 10;
    int currentImage = 0;
    int maximum = sizeImagesFolder-1;
    int minimum = 0;
    int[] photoIDs = new int[sizeImagesFolder];


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        //prevent ss
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        int i = 0;
        Set<Integer> generatedIDs = new HashSet<>(); // Replace with the actual image URL



        while (i < sizeImagesFolder) {
            int randomNum = (int) (Math.random() * (sizeImagesFolder));

            // Check if the generated ID is not in the set of generated IDs
            if (!generatedIDs.contains(randomNum)) {
                photoIDs[i] = getResources().getIdentifier("_" + randomNum, "drawable", getPackageName());
                generatedIDs.add(randomNum);
                i++;
            }
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(photoIDs[0]);
        }
//        ImageView myImageView = findViewById(R.id.imageView);
//        String imageUrl = "https://media.discordapp.net/attachments/855813233355784235/1171036998052614175/Screenshot_2023-10-24_145140.png";
//        Picasso.get().load(imageUrl).into(myImageView);
//        Picasso.get()
//                .load(imageUrl)
//                .error(R.drawable._9) // Set an error image resource
//                .into(myImageView, new Callback() {
//                    @Override
//                    public void onSuccess() {
//                        // Image loaded successfully
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        // Handle the error (e.g., log the error message)
//                        Log.e("Picasso Error", e.getMessage());
//                    }
//                });

    }
    public void onClick(View v){
        finish();
    }
    public void onClickRight(View view){
        ImageView imageView = findViewById(R.id.imageView);
        currentImage =currentImage+1;
        currentImage = Math.min(maximum, Math.max(minimum, currentImage));
//        int ResId = getResources().getIdentifier("_"+currentImage,"drawable",getPackageName());
        int ResId = photoIDs[currentImage];
        imageView.setImageResource(ResId);

    }
    public void onClickLeft(View view){
        ImageView imageView = findViewById(R.id.imageView);
        currentImage = currentImage-1;
        currentImage = Math.min(maximum, Math.max(minimum, currentImage));
//        int ResId = getResources().getIdentifier("_"+currentImage,"drawable",getPackageName());
        int ResId = photoIDs[currentImage];
        imageView.setImageResource(ResId);
    }
}
