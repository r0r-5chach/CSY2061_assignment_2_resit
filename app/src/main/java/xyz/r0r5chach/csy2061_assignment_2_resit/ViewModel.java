package xyz.r0r5chach.csy2061_assignment_2_resit;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.UserType;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<Integer> pressedButton = new MutableLiveData<>();
    private final MutableLiveData<Intent> intent = new MutableLiveData<>();
    private final MutableLiveData<UserType> userType = new MutableLiveData<>();

    public void setIntent(Intent intent) {
        this.intent.setValue(intent);
    }

    public  LiveData<Intent> getIntent() {
        return intent;
    }

    public void setPressedButton(Integer id) {
        pressedButton.setValue(id);
    }

    public LiveData<Integer> getPressedButton() {
        return pressedButton;
    }

    public void setUserType(UserType userType) {
        this.userType.setValue(userType);
    }

    public LiveData<UserType> getUserType() {
        return userType;
    }
}
