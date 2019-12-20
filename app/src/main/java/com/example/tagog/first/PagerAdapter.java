package com.example.tagog.first;


/**
 * Created by Bashir on 10/10/2017.
 */

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

//        import com.neelain.una.R;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Register_student tab2 = new Register_student();
                return tab2;
            case 1:
                Register_teacher tab1 = new Register_teacher();
                return tab1;
            case 2:
                Register_there tab3 = new Register_there();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


    public static class Register_teacher extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
            return inflater.inflate(R.layout.news, container, false);
        }
    }

    public static class Register_student extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_add_j3, container, false);
        }
    }

    public static class Register_there extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_main, container, false);
        }
    }

}