package xyz.r0r5chach.csy2061_assignment_2_resit;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBHandler;

public class BtnOnClickListener implements View.OnClickListener {
    protected final ViewModel viewModel;
    protected final DBHandler db;

    public BtnOnClickListener(FragmentActivity fragmentActivity) {
        viewModel = new ViewModelProvider(fragmentActivity).get(ViewModel.class);
        db = new DBHandler(fragmentActivity);
    }

    @Override
    public void onClick(View view) {
        viewModel.setPressedButton(view.getId());
    }
}
