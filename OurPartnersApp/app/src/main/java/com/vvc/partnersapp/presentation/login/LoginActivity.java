package com.vvc.partnersapp.presentation.login;

import android.content.Intent;
import android.view.View;

import com.vvc.partnersapp.R;
import com.vvc.partnersapp.common.BaseActivity;
import com.vvc.partnersapp.presentation.home.activities.HomeActivity;

public class LoginActivity extends BaseActivity {
    @Override
    public int setLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    public void initGUI() {

        findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }

    @Override
    public void initData() {

    }
}
