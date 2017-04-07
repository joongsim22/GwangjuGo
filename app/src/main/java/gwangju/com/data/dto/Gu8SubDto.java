package gwangju.com.data.dto;

/**
 * Created by PC on 2017-04-07.
 */

public class Gu8SubDto {
    int num;
    int subNum;
    String name;
    String nameInfo;
    String subName;
    String lat;
    String lng;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    public String getNameInfo() {
        return nameInfo;
    }

    public void setNameInfo(String nameInfo) {
        this.nameInfo = nameInfo;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "ItemVO [num=" + num +", subNum=" + subNum +", name=" + name
                + ", nameInfo=" + nameInfo + ", subname=" + subName +", lat=" + lat+", lng=" + lng+ "]";
    }

}
