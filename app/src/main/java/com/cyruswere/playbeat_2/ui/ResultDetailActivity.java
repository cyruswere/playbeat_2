package com.cyruswere.playbeat_2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.cyruswere.playbeat_2.R;
import com.cyruswere.playbeat_2.adapter.ResultPagerAdapter;
import com.cyruswere.playbeat_2.models.Result;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private ResultPagerAdapter adapterViewPager;
    List<Result> mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_detail);
        ButterKnife.bind(this);

        mResult = Parcels.unwrap(getIntent().getParcelableExtra("result"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ResultPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mResult);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}