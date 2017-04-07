package gwangju.com.data.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gwangju.com.data.Util;
import gwangju.com.data.dto.JavaRoomsDto;

/**
 * Created by user on 2017-04-01.
 *
 */

public class RoomsData {
    public List<JavaRoomsDto> getAllinfo(){
        ArrayList<JavaRoomsDto> list = new ArrayList<JavaRoomsDto>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/rooms.jsp");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                String location= obj2.getString("location");
                int num = obj2.getInt("num");
                String name= obj2.getString("name");
                int feeMin= obj2.getInt("feeMin");
                int feeMax= obj2.getInt("feeMax");
                String kind= obj2.getString("kind");
                String phoneNum= obj2.getString("phoneNum");
                String lat = obj2.getString("lat");
                String lng = obj2.getString("lng");

                JavaRoomsDto dto = new JavaRoomsDto();
                dto.setNum(num);
                dto.setKind(kind);
                dto.setName(name);
                dto.setLocation(location);
                dto.setPhoneNum(phoneNum);
                dto.setFeeMin(feeMin);
                dto.setFeeMax(feeMax);
                dto.setLat(lat);
                dto.setLng(lng);

                list.add(dto);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }
    public List<JavaRoomsDto> getRoomsGeocode(Double lat, Double lng){
        ArrayList<JavaRoomsDto> list = new ArrayList<JavaRoomsDto>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/roomsLocaion.jsp?lat="+lat+"&lng="+lng);

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                String location= obj2.getString("location");
                int num = obj2.getInt("num");
                String phoneNum= obj2.getString("phoneNum");
                String lat2 = obj2.getString("lat");
                String lng2= obj2.getString("lng");

                JavaRoomsDto dto = new JavaRoomsDto();
                dto.setNum(num);
                dto.setLocation(location);
                dto.setPhoneNum(phoneNum);
                dto.setLat(lat2);
                dto.setLng(lng2);

                list.add(dto);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }




}
