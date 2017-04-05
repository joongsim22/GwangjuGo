package gwangju.com.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import gwangju.com.fragment.IntroduceFragment;
import gwangju.com.fragment.PictureFragment;
import gwangju.com.fragment.StarFragment;
import gwangju.com.item.DetailItem;
import gwangju.com.item.StarItem;

/**
 * Created by Beaver on 2017-04-04.
 */

public class DetailFragmentAdapter extends FragmentPagerAdapter {

    private DetailItem data;
    private ArrayList<StarItem> starData;

    public DetailFragmentAdapter(FragmentManager fm, DetailItem data, ArrayList<StarItem> starData) {
        super(fm);
        this.data = data;
        this.starData = starData;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PictureFragment.newInstance(data);
            case 1:
                return IntroduceFragment.newInstance(data);
            case 2:
                return StarFragment.newInstance(starData);
            default:
                return null;
        }
    }

    private static int PAGE_NUMBER = 3;

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "사진";
            case 1:
                return "소개";
            case 2:
                return "별점";
            default:
                return null;
        }
    }
}
