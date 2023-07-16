package xyz.r0r5chach.csy2061_assignment_2_resit;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class FragmentChangeObserver implements Observer<Integer> {
    private final FragmentManager fragmentManager;
    protected KwesiFragment newFragment;
    protected final Bundle newFragmentBundle;
    protected final List<FragmentChangeView> buttons;
    private final int fragmentViewId;


    public FragmentChangeObserver(FragmentManager fragmentManager, int fragmentViewId) {
        this.fragmentManager = fragmentManager;
        this.fragmentViewId = fragmentViewId;
        this.newFragmentBundle = null;
        buttons = new ArrayList<>();
        initViews();
    }

    @Override
    public void onChanged(Integer buttonId) {
        for (FragmentChangeView button : buttons) {
            if (button.viewIds().contains(buttonId)) {
                newFragment = (KwesiFragment) button.fragmentClass();
            }
        }
        changeFragment();
    }

    protected void changeFragment() {
        if (newFragment != null) {
            fragmentManager.beginTransaction().replace(fragmentViewId, newFragment.getClass(), newFragmentBundle).commit();
        }
    }

    protected abstract void initViews();
}
