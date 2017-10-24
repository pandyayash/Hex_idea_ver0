package com.example.yk.hex_idea;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yk.hex_idea.tabfragment.Aboutus;
import com.example.yk.hex_idea.tabfragment.Account;
import com.example.yk.hex_idea.tabfragment.Champions;
import com.example.yk.hex_idea.tabfragment.Home;
import com.example.yk.hex_idea.tabfragment.Myidea;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomnavigation;
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.action_logout:
                Intent logiout=new Intent(getApplicationContext(),Login.class);
                startActivity(logiout);
                finish();
                break;
            case R.id.action_aboutus:
                break;

        }
        return true;
        //return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mtoolsbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolsbar);
        bottomnavigation= (BottomNavigationView) findViewById(R.id.navigation);
        bottomnavigation.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.home:
                                selectedFragment = Home.newInstance();
                                break;
                            case R.id.champ:
                                selectedFragment = Champions.newInstance();
                                break;
                            case R.id.myidea:
                                selectedFragment = Myidea.newInstance();
                                break;
                            case R.id.account:
                                selectedFragment = Account.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, Home.newInstance());
        transaction.commit();
    }


}
