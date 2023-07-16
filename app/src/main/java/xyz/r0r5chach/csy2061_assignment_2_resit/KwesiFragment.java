package xyz.r0r5chach.csy2061_assignment_2_resit;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class  KwesiFragment extends Fragment {
    protected BtnOnClickListener listener;
    protected int[] buttonIds;

    public KwesiFragment(int fragmentLayoutId) {
        super(fragmentLayoutId);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initElements();
    }

    protected void initElements() {
        for(int id: buttonIds) {
            requireView().findViewById(id).setOnClickListener(listener);
        }
    }
}
