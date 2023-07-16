package xyz.r0r5chach.csy2061_assignment_2_resit;

import android.app.Activity;
import android.content.Intent;
import androidx.lifecycle.Observer;

public class ActivityChangeObserver implements Observer<Intent> {
    protected final Activity activity;

    public ActivityChangeObserver(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onChanged(Intent intent) throws NullPointerException{

        if (intent != null) {
            activity.startActivity(intent);
        }
        else {
            throw new NullPointerException();
        }
    }
}
