package xyz.r0r5chach.csy2061_assignment_2_resit.login;

import androidx.fragment.app.FragmentManager;

import xyz.r0r5chach.csy2061_assignment_2_resit.FragmentChangeObserver;
import xyz.r0r5chach.csy2061_assignment_2_resit.FragmentChangeView;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class PressedButtonObserver extends FragmentChangeObserver {

    public PressedButtonObserver(FragmentManager fragmentManager) {
        super(fragmentManager, R.id.login_fragment_view);
    }

    protected void initViews() {
        buttons.add(new FragmentChangeView(LoginButtons.login_register_button, new RegisterFragment()));
        buttons.add(new FragmentChangeView(LoginButtons.register_button, new LoginFragment()));
    }


}