package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.R;

public class UserButtons {
    public static final List<Integer> home_button = List.of(new Integer[]{R.id.nav_home_button});
    public static final List<Integer> basket_button = List.of(new Integer[]{R.id.home_button2, R.id.nav_basket_button});
    public static final List<Integer> orders_button = List.of(new Integer[]{R.id.home_button3, R.id.nav_orders_button});
    public static final List<Integer> shop_button = List.of(new Integer[]{R.id.home_button1, R.id.nav_shop_button});
    public static final List<Integer> settings_button = List.of(new Integer[]{R.id.home_button4, R.id.nav_settings_button});
    public static final List<Integer> admin_button = List.of(new Integer[]{R.id.nav_admin_button});

    public static final List<Integer> products_item_view_button = List.of(new Integer[]{R.id.products_item_view_button});

    //TODO: add button ids for fragment-changing buttons

}
