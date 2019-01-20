package com.ensim.a24h;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(new HomeFragment());
                    Log.d("Home", "Homefragmennt");
                    return true;
                case R.id.navigation_dashboard:
                    showFragment(new ScenarioFragment());
                    Log.d("dashboard", "dashboardfragmennt");
                    return true;
                case R.id.navigation_notifications:
                    showFragment(new FavorisFragment());
                    Log.d("notifications", "notificationsfragmennt");
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        showFragment(new HomeFragment());



    }

    private void add(){
        showFragment(new ScenarioFragment());
        startActivity(new Intent(MainActivity.this, ScenarioChoicePatternActivity.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.actionbar, menu);

        return true;
    }



    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

}
