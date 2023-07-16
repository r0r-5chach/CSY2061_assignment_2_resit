package xyz.r0r5chach.csy2061_assignment_2_resit.login;

import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class LoginFragment extends KwesiFragment {

    public LoginFragment() {
        super(R.layout.fragment_login);
    }

    protected void initElements() {
        listener = new BtnOnClickListener(requireActivity(), requireView().findViewById(R.id.login_email_input), requireView().findViewById(R.id.login_password_input));
        buttonIds = new int[] {R.id.login_login_button, R.id.login_register_button};
        super.initElements();
    }
}
