package com.example.sharemyjourney;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomnav=(BottomNavigationView) findViewById(R.id.mynavbar);
        bottomnav.setOnNavigationItemSelectedListener(navListener);

        mAuth = FirebaseAuth.getInstance();
        selectedFragment =new HomeFragment();
        FirebaseUser firebaseUser=mAuth.getCurrentUser();
        if(firebaseUser==null){
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.nav_home :
                    selectedFragment=new HomeFragment();
                    break;
                case R.id.nav_account :
                    selectedFragment=new AccountFragment();
                    break;
                case R.id.nav_add :
                    selectedFragment=new AddFragment();
                    break;
                case R.id.nav_search :
                    selectedFragment=new SearchFragment();
                    break;
                case R.id.nav_settings :
                    selectedFragment=new SettingsFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dot_menu,menu);
        return true;
    }
}
