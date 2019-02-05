package com.example.user301.androidlibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user301.androidlibrary.ContactFragment.ContactFragment;
import com.example.user301.androidlibrary.InformationsFragment.InformationFragment;
import com.example.user301.androidlibrary.JavaFragment.JavaFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManagerJavaList = getSupportFragmentManager();
        Fragment rFragment = fragmentManagerJavaList .findFragmentById(R.id.fragment_container);
        if (rFragment == null) {
            rFragment = new JavaFragment();
            fragmentManagerJavaList.beginTransaction()
                    .add(R.id.fragment_container, rFragment)
                    .commit();
        }

        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item
                .getItemId();
        Fragment rFragment;

        if (id == R.id.nav_java_file) {
            FragmentManager fragmentManagerJavaList = getSupportFragmentManager();
            rFragment = fragmentManagerJavaList
                    .findFragmentById(R.id.fragment_container);
            if (rFragment != null) {
                rFragment = new JavaFragment();
                fragmentManagerJavaList
                        .beginTransaction()
                        .replace(R.id.fragment_container, rFragment)
                        .commit();
            }
        } else
            if (id == R.id.nav_android_file) {
            FragmentManager fragmentManagerAndroidList = getSupportFragmentManager();
            rFragment = fragmentManagerAndroidList
                    .findFragmentById(R.id.fragment_container);
            if (rFragment != null) {
                rFragment = new ContactFragment();
                fragmentManagerAndroidList
                        .beginTransaction()
                        .replace(R.id.fragment_container, rFragment)
                        .commit();
            }

        } else
            if (id == R.id.nav_manage) {
            FragmentManager fragmentManagerManage = getSupportFragmentManager();
            rFragment = fragmentManagerManage
                    .findFragmentById(R.id.fragment_container);
            if (rFragment != null){
                rFragment = new ContactFragment();
                fragmentManagerManage
                        .beginTransaction()
                        .replace(R.id.fragment_container, rFragment)
                        .commit();
            }

        } else
            if (id == R.id.nav_information) {
                FragmentManager fragmentManagerInformations = getSupportFragmentManager();
                rFragment = fragmentManagerInformations
                        .findFragmentById(R.id.fragment_container);
                if (rFragment != null) {
                    rFragment = new InformationFragment();
                    fragmentManagerInformations
                            .beginTransaction()
                            .replace(R.id.fragment_container, rFragment)
                            .commit();
                }
            } else
                if (id == R.id.nav_contacts) {
            FragmentManager fragmentManagerContacts = getSupportFragmentManager();
            rFragment = fragmentManagerContacts
                    .findFragmentById(R.id.fragment_container);
            if (rFragment != null){
                rFragment = new ContactFragment();
                fragmentManagerContacts
                        .beginTransaction()
                        .replace(R.id.fragment_container, rFragment)
                        .commit();
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    }

