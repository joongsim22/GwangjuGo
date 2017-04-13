package gwangju.com.data.dto;

import java.io.Serializable;

/**
 * Created by user on 2017-04-01.
 */

public class OmeGwangjuRoadDetailDto implements Serializable {
    int num;
    int roadNum;
    int kindnum;
    String tourName;
    int subKindNum;
    String ex;
    String info;
    String subname;
    String lat;
    String lng;

    public int getKindnum() {
        return kindnum;
    }

    public void setKindnum(int kindnum) {
        this.kindnum = kindnum;
    }

    public int getSubKindNum() {
        return subKindNum;
    }

    public void setSubKindNum(int subKindNum) {
        this.subKindNum = subKindNum;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public int getRoadNum() {
        return roadNum;
    }

    public void setRoadNum(int roadNum) {
        this.roadNum = roadNum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
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

    @Override
    public String toString() {
        return "ItemVO [num=" + num +", roadNum=" + roadNum +", tourName=" + tourName +", subKindNum=" + subKindNum
                + ", ex=" + ex + ", info=" + info +", subname=" + subname +", lat=" + lat +", lng=" + lng +"]";
    }

}
