package xyz.r0r5chach.csy2061_assignment_2_resit.user.admin;

import xyz.r0r5chach.csy2061_assignment_2_resit.BtnOnClickListener;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class CategoriesFragment extends xyz.r0r5chach.csy2061_assignment_2_resit.user.shop.CategoriesFragment {
    @Override
    protected void initElements() {
        super.initElements();
        initRVButton(R.string.text_add_category, new BtnOnClickListener(getActivity())); //TODO: add onclick listener for add category
    }
}
