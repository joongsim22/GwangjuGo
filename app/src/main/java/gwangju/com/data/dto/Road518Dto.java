package gwangju.com.data.dto;

import java.io.Serializable;

/**
 * Created by user on 2017-04-01.
 */

public class Road518Dto implements Serializable {
    int num;
    String tourname;
    int tournum;
    String tourkindNum;
    int subTourNum;
    String ex;
    String info;
    String subkindname;
    String lat;
    String lng;
    String subEx;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTourname() {
        return tourname;
    }

    public void setTourname(String tourname) {
        this.tourname = tourname;
    }

    public int getTournum() {
        return tournum;
    }

    public void setTournum(int tournum) {
        this.tournum = tournum;
    }

    public String getTourkindNum() {
        return tourkindNum;
    }

    public void setTourkindNum(String tourkindNum) {
        this.tourkindNum = tourkindNum;
    }

    public int getSubTourNum() {
        return subTourNum;
    }

    public void setSubTourNum(int subTourNum) {
        this.subTourNum = subTourNum;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSubkindname() {
        return subkindname;
    }

    public void setSubkindname(String subkindname) {
        this.subkindname = subkindname;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getSubEx() {
        return subEx;
    }

    public void setSubEx(String subEx) {
        this.subEx = subEx;
    }

    @Override
    public String toString() {
        return "ItemVO [num=" + num +", tourname=" + tourname +", tournum=" + tournum
                + ", tourkindnum=" + tourkindNum + ", subTourNum=" + subTourNum +", ex=" + ex +", info=" + info +", subkindname=" + subkindname
                +", lat=" + lat + ", lng=" + lng +", subex=" + subEx +"]";
    }

}
