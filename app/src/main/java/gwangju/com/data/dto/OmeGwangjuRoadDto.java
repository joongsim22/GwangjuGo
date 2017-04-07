package gwangju.com.data.dto;

import java.io.Serializable;

/**
 * Created by user on 2017-04-01.
 */

public class OmeGwangjuRoadDto implements Serializable {
    int num;
    String tourName;
    String ex;
    String fee;
    String phoneNum;




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

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "ItemVO [num=" + num +", tourName=" + tourName +", ex=" + ex
                + ", phoneNum=" + phoneNum + ", fee=" + fee +"]";
    }

}
