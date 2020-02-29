package www.nabil.tugasempat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView btmNav;
    private Fragment selectedFragment = new HeroFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmNav = findViewById(R.id.activitymain_bottomnav);

        btmNav.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);

    }

    //inimah yang timbul di pojok kanan atas 2 biji kalau diaktifin
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu_bottomnav,menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_movie:
                selectedFragment = new HeroFragment();
                break;

            case R.id.menu_tvshow:
                selectedFragment = new BioFragment();
                break;

        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {

        if (selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_container,selectedFragment)
                    .commit();
            return true;
        }else{
            return false;
        }
    }



}
