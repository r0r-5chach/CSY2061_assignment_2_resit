package xyz.r0r5chach.csy2061_assignment_2_resit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.UserType;

public class KwesiActivity extends AppCompatActivity {
    public KwesiActivity(int layoutId) {
        super(layoutId);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initView(Bundle savedInstanceState, Integer fragmentViewId, Class<? extends Fragment> firstFragment) {
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(fragmentViewId, firstFragment, savedInstanceState).commit();
    }

    protected void initViewModel(ActivityChangeObserver intentObserver, FragmentChangeObserver fragmentObserver, UserType type) {
        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.setUserType(type);
        viewModel.getIntent().observe(this, intentObserver);
        viewModel.getPressedButton().observe(this, fragmentObserver);
    }
}
