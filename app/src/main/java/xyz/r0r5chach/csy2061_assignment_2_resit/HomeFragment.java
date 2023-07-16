package xyz.r0r5chach.csy2061_assignment_2_resit;

public class HomeFragment extends KwesiFragment {
    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    protected void initElements() {
        listener = new BtnOnClickListener(requireActivity());
        super.initElements();
    }
}
