package xyz.r0r5chach.csy2061_assignment_2_resit.user.admin;

import android.view.View;
import android.widget.Button;

import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class HomeFragment extends xyz.r0r5chach.csy2061_assignment_2_resit.HomeFragment {

    @Override
    protected void initElements() {
        requireView().findViewById(R.id.admin_row1).setVisibility(View.VISIBLE);
        requireView().findViewById(R.id.admin_row2).setVisibility(View.VISIBLE);
        buttonIds = new int[] {R.id.admin_home_button1, R.id.admin_home_button2, R.id.admin_home_button3, R.id.admin_home_button4};
        super.initElements();
        for(int id : buttonIds) {
            int text = -1;
            if (id == buttonIds[0]) {
                text = R.string.text_products;
            }
            else if (id == buttonIds[1]) {
                text = R.string.text_categories;
            }
            else if (id == buttonIds[2]) {
                text = R.string.text_orders;
            }
            else if (id == buttonIds[3]) {
                text = R.string.text_users;
            }
            ((Button)requireView().findViewById(id)).setText(text);
        }
    }
}
