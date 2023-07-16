package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import androidx.fragment.app.FragmentManager;

import xyz.r0r5chach.csy2061_assignment_2_resit.FragmentChangeObserver;
import xyz.r0r5chach.csy2061_assignment_2_resit.FragmentChangeView;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.admin.AdminButtons;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.admin.CategoriesFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.admin.ProductsFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.admin.UsersFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.profile.SettingsFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.shop.BasketFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.profile.OrdersFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.shop.ProductFragment;

public class PressedButtonObserver extends FragmentChangeObserver {

    public PressedButtonObserver(FragmentManager fragmentManager) {
        super(fragmentManager, R.id.user_fragment_view);
    }



    protected void initViews() {
        buttons.add(new FragmentChangeView(UserButtons.basket_button, new BasketFragment()));
        buttons.add(new FragmentChangeView(UserButtons.orders_button, new OrdersFragment()));
        buttons.add(new FragmentChangeView(UserButtons.home_button, new HomeFragment()));
        buttons.add(new FragmentChangeView(UserButtons.shop_button, new xyz.r0r5chach.csy2061_assignment_2_resit.user.shop.CategoriesFragment()));
        buttons.add(new FragmentChangeView(UserButtons.settings_button, new SettingsFragment()));
        buttons.add(new FragmentChangeView(UserButtons.admin_button, new xyz.r0r5chach.csy2061_assignment_2_resit.user.admin.HomeFragment()));

        buttons.add(new FragmentChangeView(AdminButtons.categories_button, new CategoriesFragment()));
        buttons.add(new FragmentChangeView(AdminButtons.users_button, new UsersFragment()));
        buttons.add(new FragmentChangeView(AdminButtons.orders_button, new xyz.r0r5chach.csy2061_assignment_2_resit.user.admin.OrdersFragment()));
        buttons.add(new FragmentChangeView(AdminButtons.products_button, new ProductsFragment()));

        buttons.add(new FragmentChangeView(UserButtons.products_item_view_button, new ProductFragment()));
        //TODO: add buttons that change fragments
    }


}
