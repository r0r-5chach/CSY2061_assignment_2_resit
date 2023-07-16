package xyz.r0r5chach.csy2061_assignment_2_resit.user.admin;

import java.util.ArrayList;

import xyz.r0r5chach.csy2061_assignment_2_resit.BtnOnClickListener;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Order;

public class OrdersFragment extends xyz.r0r5chach.csy2061_assignment_2_resit.user.OrdersFragment {

    public OrdersFragment() {
        super(new ArrayList<>()); //TODO: get all orders
    }

    @Override
    public void initElements() {
        super.initElements();

        initRVButton(R.string.text_add_order, new BtnOnClickListener(getActivity())); //TODO: add listner to add new order
    }
}
