package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import xyz.r0r5chach.csy2061_assignment_2_resit.BtnOnClickListener;
import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiActivity;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.UserType;

public class UserActivity extends KwesiActivity {

    public UserActivity() {
        super(R.layout.layout_user);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        super.initView(savedInstanceState, R.id.user_fragment_view, HomeFragment.class);
        super.initViewModel(null, new PressedButtonObserver(getSupportFragmentManager()), UserType.valueOf(getIntent().getStringExtra("type")));
        initElements();
    }

    private void initElements() {
        int[] buttonIds = {R.id.nav_basket_button, R.id.nav_home_button, R.id.nav_orders_button, R.id.nav_settings_button, R.id.nav_shop_button};
        BtnOnClickListener listener = new BtnOnClickListener(this);
        if (getIntent().getStringExtra("type").equals("ADMIN")) {
            Button adminButton = findViewById(R.id.nav_admin_button);
            adminButton.setOnClickListener(listener);
            adminButton.setVisibility(View.VISIBLE);
        }
        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

}
