package gwangju.com.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import gwangju.com.fragment.IntroduceFragment;
import gwangju.com.fragment.PictureFragment;
import gwangju.com.fragment.StarFragment;
import gwangju.com.item.DetailItem;

/**
 * Created by Beaver on 2017-04-04.
 */

public class DetailFragmentAdapter extends FragmentPagerAdapter {

    DetailItem data;

    public DetailFragmentAdapter(FragmentManager fm, DetailItem data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PictureFragment.newInstance(data);
            case 1:
                return IntroduceFragment.newInstance(data);
            case 2:
                return StarFragment.newInstance();
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
