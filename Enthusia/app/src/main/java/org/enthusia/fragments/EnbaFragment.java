package org.enthusia.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.enthusia.R;
import org.enthusia.adapter.EnbaPagerAdapter;

public class EnbaFragment extends Fragment {

    protected EnbaPagerAdapter mAdapter;
    private ViewPager mViewPager;

    public EnbaFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enba, container, false);
        FragmentManager manager = getActivity().getSupportFragmentManager();

        mAdapter = new EnbaPagerAdapter(manager);
        mViewPager = view.findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        return view;
    }
}
