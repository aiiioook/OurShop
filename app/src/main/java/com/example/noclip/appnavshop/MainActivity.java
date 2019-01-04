package com.example.noclip.appnavshop;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private FavoriteFragment favoriteFragment;
    private CartFragment cartFragment;
    private ProfileFragment profileFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        // кнопку назад энейблит


        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        cartFragment = new CartFragment();
        profileFragment = new ProfileFragment();



        // Менюшка навигейшн бара (внизу)
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_home:

                        setFragment(homeFragment);
                        return true;
                    case R.id.nav_favorite:

                        setFragment(favoriteFragment);
                        return true;
                    case R.id.nav_cart :

                        setFragment(cartFragment);
                        return true;
                    case R.id.nav_profile:

                        setFragment(profileFragment);
                        return true;

                     default: return false;

                }

            }
        });
    }
// Менюшка экшн бара
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_nav_menu_fragment1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_search:

                return true;

            case R.id.nav_filter:

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }

}
