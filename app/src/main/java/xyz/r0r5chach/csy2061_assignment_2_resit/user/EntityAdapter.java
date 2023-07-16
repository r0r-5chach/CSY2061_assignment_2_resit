package xyz.r0r5chach.csy2061_assignment_2_resit.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.KwesiFragment;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;

public abstract class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.ViewHolder> {
    protected final List<? extends Entity> entities;
    protected int itemLayoutId;
    protected int identifierId;
    protected int buttonId;
    protected final KwesiFragment fragment;

    public EntityAdapter(List<? extends Entity> entities, KwesiFragment fragment) {
        this.entities = entities;
        this.fragment = fragment;
        itemLayoutId = R.layout.name_only_item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayoutId, parent, false);
        return new EntityAdapter.ViewHolder(v, fragment.getActivity(), identifierId, buttonId);
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView identifier;

        public ViewHolder(@NonNull View v, FragmentActivity fragmentActivity, int identifierId, int buttonId) {
            super(v);
            v.findViewById(R.id.name_only_category_view_button); //TODO: Add to BtnOnClickListener to view order/category/user
            identifier = v.findViewById(identifierId);
        }

        public TextView getIdentifier() {
            return identifier;
        }
    }
}
