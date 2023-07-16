package xyz.r0r5chach.csy2061_assignment_2_resit.user.profile;

import android.widget.Button;

import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class SettingsFragment extends KwesiFragment {

    public SettingsFragment() {
        super(R.layout.fragment_user_settings);
    }

    @Override
    protected void initElements() {
        //TODO: setup update button
        ((Button)requireView().findViewById(R.id.user_settings_button)).setText(R.string.text_update_account);
    }
}
