package com.example.tugaskuliahmobile;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tugaskuliahmobile.fragment.BeverageFragment;
import com.example.tugaskuliahmobile.fragment.FoodFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class OrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Inisialisasi BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigate);

        // Load fragment default (FoodFragment)
        replaceFragment(new FoodFragment());

        // Setup listener untuk BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (R.id.kontak == item.getItemId()) {
                selectedFragment = new FoodFragment();
            } else if (R.id.mhs == item.getItemId()) {
                selectedFragment = new BeverageFragment();
            } else if (R.id.extra == item.getItemId()) {
                selectedFragment = new BeverageFragment();
            } else {
                selectedFragment = new FoodFragment();
            }

            if (selectedFragment != null) {
                replaceFragment(selectedFragment);
            }
            return true;
        });
    }

    // Fungsi untuk mengganti fragment
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}

