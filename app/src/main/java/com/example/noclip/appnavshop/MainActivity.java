package com.example.noclip.appnavshop;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private FavoriteFragment favoriteFragment;
    private CartFragment cartFragment;
    private ProfileFragment profileFragment;
    private DiscountFragment discountFragment;
    private SearchView search_bar;
    private ListView search_food;
    public  SearchView searchView;
    //    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main_frame, new HomeFragment());
        tx.commit();

//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        // кнопку назад энейблит

        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_nav);

        discountFragment = new DiscountFragment();
        cartFragment = new CartFragment();
        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();

//        search_food = findViewById(R.id.search_food_bar);
//        search_bar = findViewById(R.id.search_food_bar);
        // Менюшка навигейшн бара (внизу)
        mMainNav.setSelectedItemId(R.id.nav_home);
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("WrongConstant")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_discount:
                        setFragment(discountFragment);
                        setActionBarTitle("Акции и скидки");
                        showActionBar();
                        return true;

                    case R.id.nav_cart :
                        setFragment(cartFragment);
                        setActionBarTitle("Ваша корзина");
                        showActionBar();
                        return true;

                    case R.id.nav_home:
                        setFragment(homeFragment);
                        setActionBarTitle("All inclusive");
                        showActionBar();
                        return true;

                    case R.id.nav_favorite:
                        setFragment(favoriteFragment);
                        setActionBarTitle("Список желаемого");
                        showActionBar();
                        return true;

                    case R.id.nav_profile:
                        setFragment(profileFragment);
                        setActionBarTitle("Профиль [profile_name]");
                        showActionBar();
                        return true;

                     default:

                         return false;

                }

            }
        });


//Подключение поиска и списка

//        ArrayList<String> array_food = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.my_foods)));
//        adapter = new ArrayAdapter<String>(
//                MainActivity.this,
//                android.R.layout.simple_list_item_1,
//                array_food
//        );
//        search_food.setAdapter(adapter);


    }

    // Менюшка экшн бар

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
//        return true;
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
              discountFragment.adapter.getFilter().filter(newText);
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
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
//Жай метод поставить титул из фрагмента
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void showActionBar(){
        getSupportActionBar().show();
    }

}

