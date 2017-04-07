package gwangju.com.data.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gwangju.com.data.Util;
import gwangju.com.data.dto.Gu8Dto;
import gwangju.com.data.dto.Gu8SubDto;

/**
 * Created by user on 2017-04-01.
 *
 */

public class GU8Data {
    public List<Gu8Dto> getAllGu8info(){
        ArrayList<Gu8Dto> list = new ArrayList<Gu8Dto>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/Gu8.jsp");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                int num = obj2.getInt("num");
                String gu= obj2.getString("gu");
                int guNum =obj2.getInt("guNum");
                String name= obj2.getString("name");
                String address= obj2.getString("address");
                String lat= obj2.getString("lat");
                String lng= obj2.getString("lng");
                String ex= obj2.getString("ex");

                Gu8Dto dto = new Gu8Dto();
                dto.setNum(num);
                dto.setGu(gu);
                dto.setGuNum(guNum);
                dto.setName(name);
                dto.setAddress(address);
                dto.setLat(lat);
                dto.setLng(lng);
                dto.setEx(ex);

                list.add(dto);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }
    public List<Gu8SubDto> getAllGu8Subinfo(){
        ArrayList<Gu8SubDto>  list = new ArrayList<Gu8SubDto> ();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/Gu8Sub.jsp");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                int num = obj2.getInt("num");
                int subNum =obj2.getInt("subNum");
                String name= obj2.getString("name");
                String nameInfo= obj2.getString("nameInfo");
                String subname= obj2.getString("subname");
                String lat= obj2.getString("lat");
                String lng= obj2.getString("lng");

                Gu8SubDto dto = new Gu8SubDto();
                dto.setNum(num);
                dto.setSubNum(subNum);
                dto.setName(name);
                dto.setNameInfo(nameInfo);
                dto.setSubName(subname);
                dto.setLat(lat);
                dto.setLng(lng);

                list.add(dto);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }




}
