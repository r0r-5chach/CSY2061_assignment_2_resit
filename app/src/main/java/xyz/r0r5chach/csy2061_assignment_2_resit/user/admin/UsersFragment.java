package xyz.r0r5chach.csy2061_assignment_2_resit.user.admin;

import xyz.r0r5chach.csy2061_assignment_2_resit.BtnOnClickListener;
import xyz.r0r5chach.csy2061_assignment_2_resit.R;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.User;
import xyz.r0r5chach.csy2061_assignment_2_resit.user.RVFragment;

public class UsersFragment extends RVFragment {

    @Override
    protected void initElements() {
        UsersAdapter adapter = new UsersAdapter(db.crud(new User(), DBProcess.READ_ALL), this);
        initRV(adapter, R.id.list_display);
        initRVButton(R.string.text_add_user, new BtnOnClickListener(getActivity())); //TODO: add listner to add new user
    }
}
