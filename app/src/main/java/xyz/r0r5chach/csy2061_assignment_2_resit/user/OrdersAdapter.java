package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import android.view.View;

import androidx.annotation.NonNull;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Order;

public class OrdersAdapter extends EntityAdapter {

    public OrdersAdapter(List<Entity> orders, KwesiFragment fragment) {
        super(orders, fragment);
        fragment.requireActivity().findViewById(R.id.name_only_order_item).setVisibility(View.VISIBLE);
        identifierId = R.id.name_only_order_item;
        buttonId = R.id.name_only_order_view_button;
    }

    @Override
    public void onBindViewHolder(@NonNull EntityAdapter.ViewHolder holder, int position) {
        Order order = (Order) entities.get(position);

        holder.getIdentifier().setText(String.valueOf(order.getId()));
    }
}