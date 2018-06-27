package com.example.swagmence.lasthope.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.swagmence.lasthope.Model.LocationWeatherApi;
import com.example.swagmence.lasthope.Model.ReadWrite;
import com.example.swagmence.lasthope.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static int titles = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        LocationWeatherApi weather = new LocationWeatherApi();
        weather.execute();
        String orig_string = getString(R.string.temperatura);
        TextView textView = findViewById(R.id.textView2);
        String to_set = "Temperatura Lá Fora(São Paulo): Falha ao Obter";
        try {
            JSONArray array = weather.jo.getJSONArray("consolidated_weather");
            JSONObject object = array.getJSONObject(0);
            double temp = object.getDouble("the_temp");
            //to_set = orig_string + weather.jo.getJSONObject("consolidated_weather").getJSONObject("0").getString("the_temp");
            to_set = orig_string + String.valueOf(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        textView.setText(to_set);

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
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent myIntent;

        switch (id){
            case R.id.nav_five:
                ReadWrite.writeToFile("5",this);
                myIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(myIntent);
                break;
            case R.id.nav_four:
                ReadWrite.writeToFile("4",this);
                myIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(myIntent);
                break;
            case R.id.nav_two:
                ReadWrite.writeToFile("2",this);
                myIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(myIntent);
                break;
            case R.id.nav_one:
                ReadWrite.writeToFile("1",this);
                myIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(myIntent);
                break;
        }

        /*if (id == R.id.nav_five) {
            // Handle the camera action
        } else if (id == R.id.nav_four) {

        } else if (id == R.id.nav_three) {

        } else if (id == R.id.nav_two) {

        } else if (id == R.id.nav_one) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
