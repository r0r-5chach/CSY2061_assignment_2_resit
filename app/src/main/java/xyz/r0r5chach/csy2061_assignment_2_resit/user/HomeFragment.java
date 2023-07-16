package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import android.view.View;
import android.widget.Button;

import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class HomeFragment extends xyz.r0r5chach.csy2061_assignment_2_resit.HomeFragment {


    @Override
    protected void initElements() {
        requireView().findViewById(R.id.home_row1).setVisibility(View.VISIBLE);
        requireView().findViewById(R.id.home_row2).setVisibility(View.VISIBLE);
        buttonIds = new int[] {R.id.home_button1, R.id.home_button2, R.id.home_button3, R.id.home_button4};

        super.initElements();
        for(int id : buttonIds) {
            int text = -1;
            if (id == buttonIds[0]) {
                text = R.string.text_shop;
            }
            else if (id == buttonIds[1]) {
                text = R.string.text_basket;
            }
            else if (id == buttonIds[2]) {
                text = R.string.text_orders;
            }
            else if (id == buttonIds[3]) {
                text = R.string.text_settings;
            }
            ((Button)requireView().findViewById(id)).setText(text);
        }
    }

}
