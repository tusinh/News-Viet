package vn.com.newsviet.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import vn.com.newsviet.Utils.MyLog;
import vn.com.newsviet.fragment.FragmentIOS;
import vn.com.newsviet.fragment.FragmentListNews;
import vn.com.newsviet.fragment.FragmentPhp;
import vn.com.newsviet.model.News;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<News> dataNews;


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ArrayList<News> getDataNews() {
        return dataNews;
    }

    public void setDataNews(ArrayList<News> dataNews) {
        this.dataNews = dataNews;
    }

    @Override
    public Fragment getItem(int position) {
        MyLog.Log("Fragmetn: " + position);
        Fragment frag = null;
        for (int i = 0; i < dataNews.size(); i++) {
            if (i == position) {
                frag = new FragmentListNews();
                Bundle bundle = new Bundle();
                bundle.putString("link", dataNews.get(i).link);
                frag.setArguments(bundle);
            }

        }

//        switch (position) {
//            case 0:
//                frag = new FragmentListNews();
//                break;
//            case 1:
//                frag = new FragmentIOS();
//                break;
//            case 2:
//                frag = new FragmentPhp();
//                break;
//        }
        return frag;
    }

    @Override
    public int getCount() {
        return dataNews.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        String title = "";
//        switch (position) {
//            case 0:
//                title = "Tin Tuc";
//                break;
//            case 1:
//                title = "IOS";
//                break;
//            case 2:
//                title = "PHP";
//                break;
//        }
//
//        return title;
//    }
}
