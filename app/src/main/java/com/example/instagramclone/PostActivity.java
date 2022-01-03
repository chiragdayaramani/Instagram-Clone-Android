package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.instagramclone.databinding.ActivityPostBinding;
import com.example.instagramclone.databinding.ActivityRegisterBinding;

public class PostActivity extends AppCompatActivity {

    ActivityPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}