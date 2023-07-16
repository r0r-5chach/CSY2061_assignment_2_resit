package xyz.r0r5chach.csy2061_assignment_2_resit.user.admin;

import android.view.View;

import androidx.annotation.NonNull;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.StringType;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.User;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.EntityAdapter;

public class UsersAdapter extends EntityAdapter {
    public UsersAdapter(List<Entity> users, KwesiFragment fragment) {
        super(users, fragment);
        fragment.requireActivity().findViewById(R.id.name_only_user_item).setVisibility(View.VISIBLE);
        identifierId = R.id.name_only_user_item;
        buttonId = R.id.name_only_user_view_button;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = (User) entities.get(position);
        holder.getIdentifier().setText(user.getString(StringType.EMAIL));
    }
}
