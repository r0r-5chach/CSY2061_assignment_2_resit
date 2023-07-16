package xyz.r0r5chach.csy2061_assignment_2_resit.user.shop;

import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Category;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.RVFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.CategoriesAdapter;

public class CategoriesFragment extends RVFragment {
    @Override
    protected void initElements() {
        CategoriesAdapter adapter = new CategoriesAdapter(db.crud(new Category(), DBProcess.READ_ALL), this);
        initRV(adapter, R.id.list_display);
    }
}
