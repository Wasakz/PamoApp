package com.example.pamoapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pamoapp.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        EditText editTextHeight = (EditText) findViewById(R.id.editTextNumber);
        Log.i("info", editTextHeight.getText().toString());
    }


    public void clickCalc(View view) {
        EditText editTextHeight = (EditText) findViewById(R.id.editTextNumber);
        EditText editTextWeight = (EditText) findViewById(R.id.editTextNumber2);
        TextView calculatedText = (TextView) findViewById(R.id.textView3);

        double heightVal = Integer.parseInt(editTextHeight.getText().toString());
        double weightVal = Integer.parseInt(editTextWeight.getText().toString());
        double heightInMeter = heightVal/100;
        double bmi = (weightVal/Math.pow(heightInMeter, 2));
        calculatedText.setText(new DecimalFormat("#.##").format(bmi));
    }

}