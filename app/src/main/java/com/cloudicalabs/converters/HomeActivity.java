package com.cloudicalabs.converters;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.cloudicalabs.converters.fragments.AllConverters;
import com.cloudicalabs.converters.fragments.UniqueConverter;

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getColor(getApplicationContext(), R.color.colorPrimaryDark));
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        AllConverters allConverters = new AllConverters();
        allConverters.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, allConverters).commit();
    }

    public static final int getColor(Context context, int id) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return ContextCompat.getColor(context, id);
        } else {
            return context.getResources().getColor(id);
        }
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
        int position = 0;

        Fragment fragment;
        switch (id) {
            case R.id.temperature:
                position = 0;
                break;
            case R.id.weight:
                position = 1;
                break;
            case R.id.length:
                position = 2;
                break;
            case R.id.time:
                position = 3;
                break;
            case R.id.area:
                position = 4;
                break;
            case R.id.volume:
                position = 5;
                break;
            case R.id.storage:
                position = 6;
                break;
            case R.id.pressure:
                position = 7;
                break;
            case R.id.sound:
                position = 8;
                break;
            case R.id.energy:
                position = 9;
                break;
            case R.id.magnet:
                position = 10;
                break;
            case R.id.image:
                position = 11;
                break;
        }

        UniqueConverter uniqueConverter = UniqueConverter.setArguments(position);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, uniqueConverter).addToBackStack(null).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
