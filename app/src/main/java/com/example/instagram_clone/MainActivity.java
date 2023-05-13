package com.example.instagram_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.instagram_clone.data.PostItemData;
import com.example.instagram_clone.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

String jsonFileString = getJsonFromAssets(getApplicationContext(), "posts.json");
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<PostItemData>>() { }.getType();

        List<PostItemData> posts = gson.fromJson(jsonFileString, listUserType);

        PostListAdapter adapter = new PostListAdapter(posts);

        binding.rvItems.setHasFixedSize(true);
        binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItems.setAdapter(adapter);
    }

    static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
}