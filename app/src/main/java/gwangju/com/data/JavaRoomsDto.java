package gwangju.com.data;

import java.io.Serializable;

/**
 * Created by user on 2017-04-01.
 */

public class JavaRoomsDto implements Serializable {
    int num;
    String kind;
    String name;
    String location;
    String phoneNum;
    int feeMin;
    int feeMax;

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public int getFeeMin() {
        return feeMin;
    }
    public void setFeeMin(int feeMin) {
        this.feeMin = feeMin;
    }
    public int getFeeMax() {
        return feeMax;
    }
    public void setFeeMax(int feeMax) {
        this.feeMax = feeMax;
    }


    @Override
    public String toString() {
        return "ItemVO [name=" + name +", location=" + location +", kind=" + kind
                + ", phoneNum=" + phoneNum + ", feeMin=" + feeMin +", feeMax=" + feeMax + "]";
    }

}
