package com.cloudicalabs.converters;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.cloudicalabs.converters.fragments.AllConverters;
import com.cloudicalabs.converters.fragments.Area;
import com.cloudicalabs.converters.fragments.Energy;
import com.cloudicalabs.converters.fragments.Image;
import com.cloudicalabs.converters.fragments.Length;
import com.cloudicalabs.converters.fragments.Magnet;
import com.cloudicalabs.converters.fragments.Pressure;
import com.cloudicalabs.converters.fragments.Sound;
import com.cloudicalabs.converters.fragments.Storage;
import com.cloudicalabs.converters.fragments.Temperature;
import com.cloudicalabs.converters.fragments.Time;
import com.cloudicalabs.converters.fragments.Volume;
import com.cloudicalabs.converters.fragments.Weight;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        AllConverters allConverters = new AllConverters();
        allConverters.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, allConverters).commit();
    }


    public void openFragment(Fragment fragment) {
        if (fragment != null)
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment;
        switch (id) {
            case R.id.temperature:
                fragment = new Temperature();
                break;
            case R.id.weight:
                fragment = new Weight();
                break;
            case R.id.length:
                fragment = new Length();
                break;
            case R.id.time:
                fragment = new Time();
                break;
            case R.id.area:
                fragment = new Area();
                break;
            case R.id.volume:
                fragment = new Volume();
                break;
            case R.id.storage:
                fragment = new Storage();
                break;
            case R.id.pressure:
                fragment = new Pressure();
                break;
            case R.id.sound:
                fragment = new Sound();
                break;
            case R.id.energy:
                fragment = new Energy();
                break;
            case R.id.magnet:
                fragment = new Magnet();
                break;
            case R.id.image:
                fragment = new Image();
                break;
            default:
                fragment = new Temperature();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
