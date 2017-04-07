package gwangju.com.data.dto;

import java.io.Serializable;

/**
 * Created by user on 2017-04-01.
 */

public class OmeGwangjuSubDto implements Serializable {
    int num;
    int evolNum;
    String kind;
    int kindNum;
    String subname;
    String address;
    String tel;
    String useDate;
    String useTime;
    String restDate;
    String fee;
    String lat;
    String lng;
    String ex;

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getEvolNum() {
        return evolNum;
    }

    public void setEvolNum(int evolNum) {
        this.evolNum = evolNum;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getKindNum() {
        return kindNum;
    }

    public void setKindNum(int kindNum) {
        this.kindNum = kindNum;
    }



    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getRestDate() {
        return restDate;
    }

    public void setRestDate(String restDate) {
        this.restDate = restDate;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
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
        return "ItemVO [num=" + num +", evolNum=" + evolNum +", kind=" + kind
                + ", kindNum=" + kindNum + ", subname=" + subname +", address=" + address +", tel=" + tel +", useDate=" + useDate +
                ", useTime=" + useTime +", restDate=" + restDate +", fee=" + fee +", lat=" + lat +", lng=" + lng +", ex=" + ex+ "]";
    }

}
