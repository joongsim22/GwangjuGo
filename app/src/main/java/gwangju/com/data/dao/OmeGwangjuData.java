package gwangju.com.data.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gwangju.com.data.Util;
import gwangju.com.data.dto.OmeGwangjuDto;
import gwangju.com.data.dto.OmeGwangjuSubDto;

/**
 * Created by user on 2017-04-01.
 *
 */

public class OmeGwangjuData {
    public List<OmeGwangjuDto> getAllOmeGwangjuinfo(){
        ArrayList<OmeGwangjuDto> list = new ArrayList<OmeGwangjuDto>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/OmeGwangju.jsp");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                int num = obj2.getInt("num");
                int evolnum = obj2.getInt("evolvNum");
                String kind = obj2.getString("kind");
                int kindNum= obj2.getInt("kindNum");
                String name= obj2.getString("name");
                String address= obj2.getString("address");
                String useDate = obj2.getString("useDate");
                String tel = obj2.getString("tel");
                String useTime = obj2.getString("useTime");
                String restDate = obj2.getString("restDate");
                String fee = obj2.getString("fee");
                String lat = obj2.getString("lat");
                String lng = obj2.getString("lng");
                String ex = obj2.getString("ex");


                OmeGwangjuDto dto = new OmeGwangjuDto();
                dto.setNum(num);
                dto.setEvolNum(evolnum);
                dto.setKind(kind);
                dto.setKindNum(kindNum);
                dto.setName(name);
                dto.setAddress(address);
                dto.setUseDate(useDate);
                dto.setUseTime(useTime);
                dto.setTel(tel);
                dto.setRestDate(restDate);
                dto.setFee(fee);
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
    public List<OmeGwangjuSubDto> getAllOmeSubinfo(){
        ArrayList<OmeGwangjuSubDto> list = new ArrayList<>();

        //네트워크 연결 - 나중에 출시시에는 thread로 바꾸어줌
        //주소호출
        String json = Util.request("http://ayj1002.cafe24.com/OmeGwangjuSub.jsp");

        try {
            JSONArray obj = new JSONArray(json);
            for (int i = 0; i < obj.length(); i++) {
                JSONObject obj2 = obj.getJSONObject(i);
                int num = obj2.getInt("num");
                int evolnum = obj2.getInt("evolNum");
                String kind = obj2.getString("kind");
                int kindNum= obj2.getInt("kindNum");
                String subname= obj2.getString("subname");
                String address= obj2.getString("address");
                String useDate = obj2.getString("useDate");
                String tel = obj2.getString("tel");
                String useTime = obj2.getString("useTime");
                String restDate = obj2.getString("restDate");
                String fee = obj2.getString("fee");
                String lat = obj2.getString("lat");
                String lng = obj2.getString("lng");
                String ex = obj2.getString("ex");


                OmeGwangjuSubDto dto = new OmeGwangjuSubDto();
                dto.setNum(num);
                dto.setEvolNum(evolnum);
                dto.setKind(kind);
                dto.setKindNum(kindNum);
                dto.setSubname(subname);
                dto.setAddress(address);
                dto.setUseDate(useDate);
                dto.setUseTime(useTime);
                dto.setTel(tel);
                dto.setRestDate(restDate);
                dto.setFee(fee);
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




}
