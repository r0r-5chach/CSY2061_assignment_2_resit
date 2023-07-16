package xyz.r0r5chach.csy2061_assignment_2_resit.user.shop;

import java.util.ArrayList;

import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.ProductsAdapter;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.RVFragment;

public class ResultsFragment extends RVFragment {
    @Override
    protected void initElements() {
        ProductsAdapter adapter = new ProductsAdapter(new ArrayList<>(), this); //TODO: generate all products from category
        initRV(adapter, R.id.list_display);
    }
}
