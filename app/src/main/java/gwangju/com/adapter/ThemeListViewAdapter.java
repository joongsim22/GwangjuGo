package gwangju.com.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gwangju.com.R;
import gwangju.com.list.ThemeListViewItem;

public class ThemeListViewAdapter extends BaseExpandableListAdapter {

    private ArrayList<ThemeListViewItem> groupList = null;
    private ArrayList<ArrayList<String>> childList = null;
    private LayoutInflater inflater = null;
    private ViewHolder viewHolder = null;

    public ThemeListViewAdapter(Context c, ArrayList<ThemeListViewItem> groupList,
                                ArrayList<ArrayList<String>> childList) {
        super();
        this.inflater = LayoutInflater.from(c);
        this.groupList = groupList;
        this.childList = childList;
    }

    // 그룹 포지션 반환
    @Override
    public ThemeListViewItem getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    // 그룹 사이즈 반환
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    // 그룹 ID 반환
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    // 그룹 각각의 row 정하기
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null){
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.theme_item, parent, false);
            viewHolder.gTthemeIcon = (ImageView) v.findViewById(R.id.themeIcon);
            viewHolder.gThemeTitle = (TextView) v.findViewById(R.id.themeTitle);
            viewHolder.gThemeExplain = (TextView) v.findViewById(R.id.themeExplain);
            v.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)v.getTag();
        }

        // 그룹을 펼칠때와 닫을때 아이콘을 변경해 준다.
        if(isExpanded){
            viewHolder.gTthemeIcon.setImageResource(R.drawable.up);
        }else{
            viewHolder.gTthemeIcon.setImageResource(R.drawable.down);
        }
        viewHolder.gThemeTitle.setText(getGroup(groupPosition).getThemeTitle());
        viewHolder.gThemeExplain.setText(getGroup(groupPosition).getThemeExplain());

        return v;
    }

    // 자식 포지션 반환
    @Override
    public String getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    // 자식 크기 반환
    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    // 자식 ID 반환
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    // 자식 각각의 row 정하기
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.theme_item, null);
            viewHolder.cThemeTitle = (TextView) v.findViewById(R.id.childThemeTitle);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        viewHolder.cThemeTitle.setText(getChild(groupPosition, childPosition));

        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    class ViewHolder {
        public ImageView gTthemeIcon;
        public TextView gThemeTitle;
        public TextView gThemeExplain;
        public TextView cThemeTitle;
    }

}
