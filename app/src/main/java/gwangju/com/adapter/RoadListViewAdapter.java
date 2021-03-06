package gwangju.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import gwangju.com.R;
import gwangju.com.data.dto.OmeGwangjuRoadDetailDto;
import gwangju.com.data.dto.OmeGwangjuRoadDto;
import gwangju.com.data.dto.OmeGwangjuRoadTotalDto;
import gwangju.com.item.RoomsListViewItem;

/**
 * Created by PC on 2017-04-12.
 */

public class RoadListViewAdapter extends BaseAdapter{
        // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
        private ArrayList<OmeGwangjuRoadDto> listViewItemList = new ArrayList<OmeGwangjuRoadDto>() ;
//        private ArrayList<OmeGwangjuRoadTotalDto> listViewItemList = new ArrayList<OmeGwangjuRoadTotalDto>() ;
    TextView fee;
        // ListViewAdapter의 생성자
        public RoadListViewAdapter() {

        }

        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return listViewItemList.size() ;
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.road_item2, parent,false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            TextView title = (TextView) convertView.findViewById(R.id.textView1) ;
//            TextView detail = (TextView) convertView.findViewById(R.id.textView2) ;
             fee= (TextView) convertView.findViewById(R.id.textView2) ;

            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            OmeGwangjuRoadDto listViewItem = listViewItemList.get(position);

            // 아이템 내 각 위젯에 데이터 반영
            title.setText(listViewItem.getTourName());
//            detail.setText(listViewItem.getEx());
            fee.setText(listViewItem.getFee());

            return convertView;
        }

        // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
        @Override
        public long getItemId(int position) {
            return position ;
        }


    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return listViewItemList.get(position) ;
        }

        // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
        public void addItem(String title, String fee) {
            OmeGwangjuRoadDto item = new OmeGwangjuRoadDto();

            item.setTourName(title);
            item.setFee(fee);

            listViewItemList.add(item);
        }
        public void addItem_Nofee(String title) {

            OmeGwangjuRoadDto item = new OmeGwangjuRoadDto();


            item.setTourName(title);

            listViewItemList.add(item);
        }

    }



