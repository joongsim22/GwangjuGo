package gwangju.com.data.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gwangju.com.data.Util;
import gwangju.com.data.dto.OmeGwangjuRoadDetailDto;
import gwangju.com.data.dto.OmeGwangjuRoadDto;

/**
 * Created by user on 2017-04-01.
 *
 */

public class OmeGwangjuRoadRouteData {
    public List<OmeGwangjuRoadDetailDto> getAllRoadRouteinfo(){
        ArrayList<OmeGwangjuRoadDetailDto> list = new ArrayList<>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/OmeGwangjuRoadDetailRoute.jsp?roadnum=1&kindnum=1");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                int num = obj2.getInt("num");
                int kindnum = obj2.getInt("kindNum");
                int roadNum = obj2.getInt("roadNum");
                String tourname= obj2.getString("tourname");
                int subKindNum = obj2.getInt("subKindNum");
                String ex= obj2.getString("ex");
                String info = obj2.getString("info");
                String subname= obj2.getString("subname");
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
                dto.setKindnum(kindnum);
                list.add(dto);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }




}
