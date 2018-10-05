package org.enthusia.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.enthusia.EnbaPoolFragment;
import org.enthusia.R;
import org.enthusia.adapter.EnbaPagerAdapter;
import org.w3c.dom.Text;

public class EnbaFragment extends Fragment {

    protected EnbaPagerAdapter mAdapter;
    private ViewPager mViewPager;

    public EnbaFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.enba, container, false);
        FragmentManager manager = getActivity().getSupportFragmentManager();

        mAdapter = new EnbaPagerAdapter(manager);
        mViewPager = view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(mAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        return view;
    }
}
