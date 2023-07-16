package xyz.r0r5chach.csy2061_assignment_2_resit.login;

import android.os.Bundle;

import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiActivity;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class LoginActivity extends KwesiActivity {

    public LoginActivity() {
        super(R.layout.layout_login);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        super.initView(savedInstanceState, R.id.login_fragment_view, LoginFragment.class);
        super.initViewModel(new LoginObserver(this), new PressedButtonObserver(getSupportFragmentManager()), null);
    }


}
