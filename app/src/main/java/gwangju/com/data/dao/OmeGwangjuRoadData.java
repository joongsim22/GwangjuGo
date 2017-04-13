package gwangju.com.data.dao;

import android.util.Log;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gwangju.com.data.Util;
import gwangju.com.data.dto.OmeGwangjuRoadDetailDto;
import gwangju.com.data.dto.OmeGwangjuRoadDto;
import gwangju.com.data.dto.OmeGwangjuRoadTotalDto;

/**
 * Created by user on 2017-04-01.
 *
 */

public class OmeGwangjuRoadData {
    public List<OmeGwangjuRoadDto> getAllRoadinfo(){
        ArrayList<OmeGwangjuRoadDto> list = new ArrayList<>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String jsonStr= Util.request("http://ayj1002.cafe24.com/OmeGwangjuRoad.jsp");


        try {
            JSONArray jarray = new JSONArray(jsonStr);
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                String tourname = jObject.getString("tourName");
                String fee = jObject.getString("fee");
                String ex = jObject.getString("ex");

                OmeGwangjuRoadDto item = new OmeGwangjuRoadDto();
                item.setTourName(tourname);
                item.setEx(ex);
                item.setFee(fee);


                list.add(item);
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
}


    public List<OmeGwangjuRoadDetailDto> getAllRoadDetailinfo(){
        ArrayList<OmeGwangjuRoadDetailDto> list = new ArrayList<>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/OmeGwangjuRoadDetail.jsp");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                int num = obj2.getInt("num");
                int roadNum = obj2.getInt("roadNum");
                String tourname= obj2.getString("tourName");
                int subKindNum = obj2.getInt("subKindNum");
                String ex= obj2.getString("ex");
                String info = obj2.getString("info");
                String subname= obj2.getString("subName");
                String lat = obj2.getString("lat");
                String lng = obj2.getString("lng");

                OmeGwangjuRoadDetailDto dto = new OmeGwangjuRoadDetailDto();
                dto.setNum(num);
                dto.setRoadNum(roadNum);
                dto.setTourName(tourname);
                dto.setSubKindNum(subKindNum);
                dto.setEx(ex);
                dto.setInfo(info);
                dto.setSubname(subname);
                dto.setLat(lat);
                dto.setLng(lng);
                list.add(dto);


            }
        } catch (JSONException e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            e.getMessage();
        }


        return list;
    }
    public List<OmeGwangjuRoadTotalDto> getRoadtotalinfo(){
        ArrayList<OmeGwangjuRoadTotalDto> list = new ArrayList<>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/OmeGwangjuRoadTotal.jsp");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                String ex = obj2.getString("ex1");
                String fee = obj2.getString("fee");
                int roadnum = obj2.getInt("roadNum");
                int kindnum = obj2.getInt("kindNum");
                String tourname = obj2.getString("tourname");
                int subkindnum = obj2.getInt("subKindNum");
                String info = obj2.getString("info");
                String subname = obj2.getString("subname");
                String lat = obj2.getString("lat");
                String lng = obj2.getString("lng");

            OmeGwangjuRoadTotalDto dto = new OmeGwangjuRoadTotalDto();
                dto.setEx1(ex);
                dto.setFee(fee);
                dto.setRoadNum(roadnum);
                dto.setKindNum(kindnum);
                dto.setTourname(tourname);
                dto.setSubKindNum(subkindnum);
                dto.setInfo(info);
                dto.setSubname(subname);
                dto.setLat(lat);
                dto.setLng(lng);

            }
        } catch (JSONException e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            e.getMessage();
        }


        return list;
    }
    public List<OmeGwangjuRoadTotalDto> getRoadMaininfo(){
        ArrayList<OmeGwangjuRoadTotalDto> list = new ArrayList<>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/OmeGwangjuRoadTotal.jsp?num=1");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                String ex = obj2.getString("ex1");
                String fee = obj2.getString("fee");
                int roadnum = obj2.getInt("roadNum");
                int kindnum = obj2.getInt("kindNum");
                String tourname = obj2.getString("tourname");
                int subkindnum = obj2.getInt("subKindNum");
                String info = obj2.getString("info");
                String subname = obj2.getString("subname");
                String lat = obj2.getString("lat");
                String lng = obj2.getString("lng");

            OmeGwangjuRoadTotalDto dto = new OmeGwangjuRoadTotalDto();
                dto.setEx1(ex);
                dto.setFee(fee);
                dto.setRoadNum(roadnum);
                dto.setKindNum(kindnum);
                dto.setTourname(tourname);
                dto.setSubKindNum(subkindnum);
                dto.setInfo(info);
                dto.setSubname(subname);
                dto.setLat(lat);
                dto.setLng(lng);

            }
        } catch (JSONException e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            e.getMessage();
        }


        return list;
    }




}
