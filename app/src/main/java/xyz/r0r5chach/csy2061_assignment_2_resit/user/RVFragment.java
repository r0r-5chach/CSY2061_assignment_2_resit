package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import xyz.r0r5chach.csy2061_assignment_2_resit.BtnOnClickListener;
import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBHandler;

public abstract class RVFragment extends KwesiFragment {
    protected DBHandler db;
    public RVFragment() {
        super(R.layout.fragment_list_display);
        db = new DBHandler(requireView().getContext());
    }

    @Override
    protected void initElements() {
        super.initElements();
    }

    protected void initRV(EntityAdapter adapter, int rvId) {
        RecyclerView list = requireView().findViewById(rvId);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(requireActivity()));
        adapter.notifyItemRangeChanged(0, adapter.getItemCount());
    }

    protected void initRVButton(int displayTextId, BtnOnClickListener listener) {
        Button btn = requireView().findViewById(R.id.list_display_button);
        btn.setText(displayTextId);
        btn.setVisibility(View.VISIBLE);
        buttonIds = new int[] {R.id.list_display_button};
        this.listener = listener;
        super.initElements();
    }

}
