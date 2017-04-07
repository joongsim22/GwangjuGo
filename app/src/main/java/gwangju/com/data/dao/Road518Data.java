package gwangju.com.data.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gwangju.com.data.Util;
import gwangju.com.data.dto.JavaRoomsDto;
import gwangju.com.data.dto.Road518Dto;

/**
 * Created by user on 2017-04-01.
 *
 */

public class Road518Data {
    public List<Road518Dto> getAll518info(){
        ArrayList<Road518Dto> list = new ArrayList<Road518Dto>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/Road518.jsp");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                int num = obj2.getInt("num");
                String tourname= obj2.getString("tourname");
                String tourkindnum= obj2.getString("tourkindnum");
                int subtournum = obj2.getInt("subtourenum");
                String ex= obj2.getString("ex");
                String info= obj2.getString("info");
                String subkindname = obj2.getString("subkindname");
                String lat = obj2.getString("lat");
                String lng = obj2.getString("lng");
                String subEx= obj2.getString("subEx");

                Road518Dto dto = new Road518Dto();
                dto.setNum(num);
                dto.setTourname(tourname);
                dto.setTourkindNum(tourkindnum);
                dto.setSubTourNum(subtournum);
                dto.setEx(ex);
                dto.setInfo(info);
                dto.setSubkindname(subkindname);
                dto.setLat(lat);
                dto.setLng(lng);
                dto.setSubEx(subEx);


                list.add(dto);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }




}
