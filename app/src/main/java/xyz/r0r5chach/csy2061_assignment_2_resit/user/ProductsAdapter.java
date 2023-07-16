package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.BtnOnClickListener;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.PriceType;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Product;

public class ProductsAdapter extends EntityAdapter {

    public ProductsAdapter(List<Entity> products, RVFragment fragment) {
        super(products, fragment);
        itemLayoutId = R.layout.products_item;
    }

    @Override
    public void onBindViewHolder(@NonNull EntityAdapter.ViewHolder holder, int position) {
        Product product = (Product) entities.get(position);

        ((ProductsAdapter.ViewHolder)holder).getName().setText(String.valueOf(product.getName()));
        ((ProductsAdapter.ViewHolder)holder).getPrice().setText(String.valueOf(product.getPrice(PriceType.ACTUAL)));
    }

    public static class ViewHolder extends EntityAdapter.ViewHolder {
        private final TextView name, price;

        public ViewHolder(@NonNull View v, FragmentActivity fragmentActivity) {
            super(v, fragmentActivity, -1, -1);
            name = v.findViewById(R.id.products_item_name);
            price = v.findViewById(R.id.products_item_price);
            v.findViewById(R.id.products_item_view_button).setOnClickListener(new BtnOnClickListener(fragmentActivity));
        }

        public TextView getName() {
            return name;
        }

        public TextView getPrice() {
            return price;
        }
    }
}
