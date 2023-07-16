package xyz.r0r5chach.csy2061_assignment_2_resit.user.admin;


import java.util.ArrayList;

import xyz.r0r5chach.csy2061_assignment_2_resit.BtnOnClickListener;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Product;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.ProductsAdapter;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.RVFragment;

public class ProductsFragment extends RVFragment {

    @Override
    protected void initElements() {
        ProductsAdapter adapter = new ProductsAdapter(db.crud(new Product(), DBProcess.READ_ALL), this);
        initRV(adapter, R.id.list_display);

       initRVButton(R.string.text_add_product, new BtnOnClickListener(getActivity())); //TODO: add onclick listener for add product
    }
}
