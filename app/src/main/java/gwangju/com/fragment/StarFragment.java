package gwangju.com.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;

import java.util.ArrayList;

import gwangju.com.AddStarActivity;
import gwangju.com.R;
import gwangju.com.SeletedThemeActivity;
import gwangju.com.adapter.StarListViewAdapter;
import gwangju.com.item.StarItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class StarFragment extends Fragment {


    public StarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_star, null);

        int cnt = 0;
        ArrayList<StarItem> starData = (ArrayList<StarItem>)getArguments().getSerializable("starData");

        // 리스트뷰에 아이템 넣기
        ListView starList = (ListView)view.findViewById(R.id.star_list);
        StarListViewAdapter adapter = new StarListViewAdapter();
        for(int i = 0; i < starData.size(); i++) {
            StarItem it = starData.get(i);
            adapter.addItem(it.getText(), it.getStarCnt());
            cnt += it.getStarCnt();
        }
        starList.setAdapter(adapter);

        // 평균별점을 구해 넣기
        RatingBar averageStar = (RatingBar)view.findViewById(R.id.average_star);
        averageStar.setNumStars(cnt / starData.size() + cnt % starData.size());

        // 버튼 클릭 시 이동
        Button addStar = (Button)view.findViewById(R.id.add_star_btn);
        addStar.bringToFront();
        Log.e("onCreate 가 멀쩡하게 되긴 하나.", "되네에ㅔㅔㅔㅔㅇ");
        addStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("눌러지냐냐냐ㅑ냐냐ㅑ", "눌러진다ㅏㅏ아아아아");
                SeletedThemeActivity act = (SeletedThemeActivity)getActivity();
                Intent intent = new Intent(act, AddStarActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public static StarFragment newInstance(ArrayList<StarItem> starData) {
        Bundle args = new Bundle();
        args.putSerializable("starData", starData);

        StarFragment fragment = new StarFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
