package xyz.r0r5chach.csy2061_assignment_2_resit.login;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import xyz.r0r5chach.csy2061_assignment_2_resit.ActivityChangeObserver;


public class LoginObserver extends ActivityChangeObserver {
    public LoginObserver(Activity activity) {
        super(activity);
    }

    @Override
    public void onChanged(Intent intent) {
        try {
            super.onChanged(intent);
            activity.finish();
        }
        catch (NullPointerException e) {
            Toast.makeText(activity, "Login Unsuccessful", Toast.LENGTH_LONG).show();
        }
    }
}
