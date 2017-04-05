package gwangju.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import gwangju.com.R;
import gwangju.com.data.JavaRoomsDto;
import gwangju.com.item.StarItem;

public class StarListViewAdapter extends BaseAdapter {
    ArrayList<StarItem> list = new ArrayList<StarItem>();

    // 리스트뷰아이템 개수
    @Override
    public int getCount() {
        return list.size();
    }

    //해당 position 에 있는 데이터 가져오기
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //position에 위치한 데이터를 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.star_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView starListText = (TextView) convertView.findViewById(R.id.star_list_text);
        RatingBar starListStar = (RatingBar) convertView.findViewById(R.id.star_list_rating_item);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        StarItem listViewItem = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        starListText.setText(listViewItem.getText());
        starListStar.setNumStars(listViewItem.getStarCnt());

        convertView.setTag(position);

        return convertView;
    }

    public void addItem(String text, int starCnt) {
        StarItem addStarItem = new StarItem(text, starCnt);
        list.add(addStarItem);
    }

}
