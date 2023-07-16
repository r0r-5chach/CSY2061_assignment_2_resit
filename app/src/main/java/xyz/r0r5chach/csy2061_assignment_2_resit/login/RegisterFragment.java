package xyz.r0r5chach.csy2061_assignment_2_resit.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class RegisterFragment extends KwesiFragment {

    public RegisterFragment() {
        super(R.layout.fragment_user_settings);
    }

    @Override
    protected void initElements() {
        View view = requireView();
        ((Button)view.findViewById(R.id.user_settings_button)).setText(R.string.text_register);
        TextView[] fields = new TextView[]{view.findViewById(R.id.user_settings_name_input), view.findViewById(R.id.user_settings_email_input), view.findViewById(R.id.user_settings_password_input), view.findViewById(R.id.user_settings_doorNumber_input), view.findViewById(R.id.user_settings_address_input), view.findViewById(R.id.user_settings_postCode_input)};
        BtnOnClickListener listener = new BtnOnClickListener(requireActivity(), fields);
        view.findViewById(R.id.user_settings_button).setOnClickListener(listener);
    }

}
