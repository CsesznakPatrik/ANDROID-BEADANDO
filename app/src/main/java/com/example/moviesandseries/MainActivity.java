package com.example.moviesandseries;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);

        if (savedInstanceState == null) {
            loadFragment(new MoviesList());
        }
    }

    private void loadFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private boolean onNavigationItemSelected(MenuItem item){
        Fragment selectedFragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.nav_first){
            selectedFragment = new MoviesList();
        }
        else if (itemId == R.id.nav_second){
            selectedFragment = new SeriesList();
        }
        else if (itemId == R.id.nav_third)
        {
            selectedFragment = new FavList();
        }

        if (selectedFragment != null){
            loadFragment(selectedFragment);
            return true;
        }
        return false;
    }
}