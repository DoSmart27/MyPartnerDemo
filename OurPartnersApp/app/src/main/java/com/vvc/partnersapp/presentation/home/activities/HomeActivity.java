package com.vvc.partnersapp.presentation.home.activities;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.vvc.partnersapp.R;
import com.vvc.partnersapp.common.BaseActivity;
import com.vvc.partnersapp.presentation.home.fragments.AccountFragment;
import com.vvc.partnersapp.presentation.home.fragments.EarningsFragment;
import com.vvc.partnersapp.presentation.home.fragments.HomeFragment;
import com.vvc.partnersapp.presentation.home.fragments.MenuFragment;

public class HomeActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private boolean doubleBackToExitPressedOnce = false;
    private BottomNavigationView bottomNavigationView;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    public void initGUI() {
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        removeNavigationShiftMode(bottomNavigationView);
        fragmentManager.beginTransaction().add(R.id.fragment_container, HomeFragment.newInstance()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                replaceFragment(HomeFragment.newInstance());
                return true;
            case R.id.navigation_menu:
                replaceFragment(MenuFragment.newInstance());
                return true;
            case R.id.navigation_earnings:
                replaceFragment(EarningsFragment.newInstance());
                return true;
            case R.id.navigation_account:
                replaceFragment(AccountFragment.newInstance());
                return true;
        }
        return false;
    }

    private void replaceFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId() == R.id.navigation_home) {
           /* super.onBackPressed();
            finish();*/
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                finish();
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, getString(R.string.press_back), Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
        } else {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    @SuppressLint("RestrictedApi")
    public static void removeNavigationShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        menuView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        menuView.buildMenuView();
    }
}
