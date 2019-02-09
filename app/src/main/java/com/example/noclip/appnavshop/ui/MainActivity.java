package com.example.noclip.appnavshop.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.SearchView;

import com.example.noclip.appnavshop.R;
import com.example.noclip.appnavshop.fragment.CartFragment;
import com.example.noclip.appnavshop.fragment.DiscountFragment;
import com.example.noclip.appnavshop.fragment.FavoriteFragment;
import com.example.noclip.appnavshop.fragment.HomeFragment;
import com.example.noclip.appnavshop.fragment.ProfileFragment;

import java.util.Objects;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private FavoriteFragment favoriteFragment;
    private CartFragment cartFragment;
    private ProfileFragment profileFragment;
    private DiscountFragment discountFragment;
    public SearchView searchView;
    //    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentTransactionConfiguration();
        initMainFrame();
        initFragments();
        configureActivity();
    }

    private void fragmentTransactionConfiguration() {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main_frame, new HomeFragment());
        tx.commit();
    }

    private void configureActivity() {
        mMainNav.setSelectedItemId(R.id.nav_home);
        setFragment(homeFragment);
        mMainNav.setOnNavigationItemSelectedListener(this);
    }

    private void initMainFrame() {
        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_nav);
    }

    private void initFragments() {
        discountFragment = new DiscountFragment();
        cartFragment = new CartFragment();
        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_actionbar, menu);
        MenuItem menuItem = menu.findItem(R.id.search_food_bar);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (homeFragment.isVisible() || homeFragment.isResumed() || homeFragment.isAdded())
                    homeFragment.adapter.getFilter().filter(newText);

                if (cartFragment.isVisible())
                    cartFragment.adapter.getFilter().filter(newText);

                if (discountFragment.isVisible())
                    discountFragment.adapter.getFilter().filter(newText);

                if (favoriteFragment.isVisible())
                    favoriteFragment.adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
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
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, fragment)
                .commit();
    }


    public void switchContent(Fragment fragment) {
        if(fragment != null && !fragment.isVisible()) {
            Logger.getLogger(getClass().getName()).info("adasdasdsadas");
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }

        setFragment(fragment);
    }

    //Жай метод поставить титул из фрагмента
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void showActionBar() {
        Objects.requireNonNull(getSupportActionBar()).show();
    }

    public void hideWhenFragment() {
        hideKeyboard();
        searchView.clearFocus();
        searchView.setQuery("", false);
        searchView.setIconified(true);
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_discount:
                switchContent(discountFragment);
                setActionBarTitle("Акции и скидки");
                showActionBar();
                hideWhenFragment();
                return true;

            case R.id.nav_cart:
                switchContent(cartFragment);
                setActionBarTitle("Ваша корзина");
                showActionBar();
                hideWhenFragment();
                return true;

            case R.id.nav_home:
                switchContent(homeFragment);
                setActionBarTitle("All inclusive");
                showActionBar();
                hideWhenFragment();

                return true;

            case R.id.nav_favorite:
                switchContent(favoriteFragment);
                setActionBarTitle("Список желаемого");
                showActionBar();
                hideWhenFragment();
                return true;

            case R.id.nav_profile:
                switchContent(profileFragment);
                setActionBarTitle("Профиль [profile_name]");
                showActionBar();
                hideWhenFragment();
                return true;

            default:

                return false;
        }
    }
}

