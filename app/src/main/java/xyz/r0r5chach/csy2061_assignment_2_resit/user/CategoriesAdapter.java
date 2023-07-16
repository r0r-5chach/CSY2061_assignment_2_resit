package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import android.view.View;

import androidx.annotation.NonNull;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Category;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.EntityAdapter;

public class CategoriesAdapter extends EntityAdapter {

    public CategoriesAdapter(List<Entity> categories, KwesiFragment fragment) {
        super(categories, fragment);
        fragment.requireActivity().findViewById(R.id.name_only_category_item).setVisibility(View.VISIBLE);
        identifierId = R.id.name_only_category_item;
        buttonId = R.id.name_only_category_view_button;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = (Category) entities.get(position);

        holder.getIdentifier().setText(category.getName());
    }


}
