package xyz.r0r5chach.csy2061_assignment_2_resit.login;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import java.time.LocalDate;

import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.StringType;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.User;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.UserType;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.UserActivity;

public class BtnOnClickListener extends xyz.r0r5chach.csy2061_assignment_2_resit.BtnOnClickListener {

    private TextView loginEmail, loginPassword;
    private TextView[] registerFields;

    public BtnOnClickListener(FragmentActivity fragmentActivity, TextView loginEmail, TextView loginPassword) {
        super(fragmentActivity);
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
    }

    public BtnOnClickListener(FragmentActivity fragmentActivity, TextView[] registerFields) {
        super(fragmentActivity);
        this.registerFields = registerFields;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (LoginButtons.login_button.contains(id)) {
            login(view);
        }
        else if (LoginButtons.register_button.contains(id)) {
            register();
        }
        else {
            super.onClick(view);
        }
    }

    private void login(View view) {
        User query = new User(loginEmail.getText().toString(), loginPassword.getText().toString());
        User user;
        try {
             user = (User) db.crud(query, DBProcess.READ).get(0);
        }
        catch (IndexOutOfBoundsException e) {
            Toast.makeText(view.getContext(), "User does not exist", Toast.LENGTH_LONG).show();
            user = null;
        }

        if (user != null && user.getString(StringType.PASSWORD).equals(query.getString(StringType.PASSWORD))) {
            Intent userActivity = new Intent(view.getContext(), UserActivity.class);
            userActivity.putExtra("email", loginEmail.getText().toString());
            userActivity.putExtra("type", user.getType().toString());
            userActivity.addCategory("fromLogin");
            viewModel.setIntent(userActivity);
        }
        else {
            viewModel.setIntent(null);
        }
    }

    private void register() {
        String response;

        if (validateRegistration()) {
            User newUser = new User(registerFields[0].getText().toString(), registerFields[1].getText().toString(), registerFields[2].getText().toString(), registerFields[3].getText().toString(), registerFields[5].getText().toString(), LocalDate.now(), UserType.ADMIN, registerFields[4].toString());
            db.crud(newUser, DBProcess.CREATE);
            response = "Registration Successful";
        }
        else {
            response = "Registration UnSuccessful";
        }
        Toast.makeText(registerFields[0].getContext(), response, Toast.LENGTH_LONG).show();
        viewModel.setPressedButton(R.id.user_settings_button);
    }

    private boolean validateRegistration() {
        //TODO: registration validation
        for (TextView field : registerFields) {
            if (field.getText().toString().equals("")) {
                return false;
            }
        }
        return true;
    }
}
