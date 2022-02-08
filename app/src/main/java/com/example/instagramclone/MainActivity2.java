package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.instagramclone.Fragments.HomeFragment;
import com.example.instagramclone.Fragments.NotificationFragment;
import com.example.instagramclone.Fragments.ProfileFragment;
import com.example.instagramclone.Fragments.SearchFragment;
import com.example.instagramclone.databinding.ActivityMain2Binding;
import com.example.instagramclone.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    private Fragment selectorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectorFragment=new HomeFragment();
                        break;
                    case R.id.nav_search:
                        selectorFragment=new SearchFragment();
                        break;
                    case R.id.nav_add:
                        selectorFragment=null;
                        startActivity(new Intent(MainActivity2.this,PostActivity.class));
                        break;
                    case R.id.nav_heart:
                        selectorFragment=new NotificationFragment();
                        break;
                    case R.id.nav_profile:
                        selectorFragment=new ProfileFragment();
                        break;
                }

                if(selectorFragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectorFragment).commit();
                }
                return true;

            }
        });
        Bundle intent=getIntent().getExtras();
        if(intent!=null){
            String profilId=intent.getString("publisherId");

            getSharedPreferences("PROFILE",MODE_PRIVATE).edit().putString("profileId",profilId).apply();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();

            binding.bottomNavigation.setSelectedItemId(R.id.nav_profile);
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
}