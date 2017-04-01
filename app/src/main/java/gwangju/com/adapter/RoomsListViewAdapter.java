package gwangju.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import gwangju.com.R;
import gwangju.com.list.RoomsListViewItem;

public class RoomsListViewAdapter extends BaseAdapter {

    //adapter에 추가된 데이터들 저장.
    private ArrayList<RoomsListViewItem> listViewItemList = new ArrayList<RoomsListViewItem>();

    // 리스트뷰아이템 개수
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    //해당 position 에 있는 데이터 가져오기
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //position에 위치한 데이터를 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.rooms_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView roomsClassificationView = (TextView) convertView.findViewById(R.id.roomsClassification);
        TextView roomsTitleView = (TextView) convertView.findViewById(R.id.roomsTitle);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        RoomsListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        roomsClassificationView.setText(listViewItem.getRoomsClassification());
        roomsTitleView.setText(listViewItem.getRoomsTitle());

        convertView.setTag(position);

        return convertView;
    }

    public void addItem(String classification, String title) {
        RoomsListViewItem item = new RoomsListViewItem();

        item.setRoomsClassification(classification);
        item.setRoomsTitle(title);

        listViewItemList.add(item);
    }

}
