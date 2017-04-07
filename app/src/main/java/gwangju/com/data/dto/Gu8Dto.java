package gwangju.com.data.dto;

/**
 * Created by PC on 2017-04-07.
 */

public class Gu8Dto {
    int num;
    String gu;
    int guNum;
    String name;
    String address;
    String lat;
    String lng;
    String ex;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public int getGuNum() {
        return guNum;
    }

    public void setGuNum(int guNum) {
        this.guNum = guNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    @Override
    public String toString() {
        return "ItemVO [num=" + num +", gu=" + gu +", guNum=" + guNum
                + ", name=" + name + ", address=" + address +", lat=" + lat+", lng=" + lng+", ex=" + ex+ "]";
    }

}
