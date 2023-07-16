package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Order;

public class OrdersFragment extends RVFragment {
    private final List<Entity> orders;

    public OrdersFragment(List<Entity> orders) {
        this.orders = orders;
    }

    @Override
    protected void initElements() {
        OrdersAdapter adapter = new OrdersAdapter(orders, this);
        initRV(adapter, R.id.list_display);
    }
}