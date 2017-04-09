package gwangju.com.item;

import java.io.Serializable;

public class RoomsXMLItem implements Serializable{
    String title, tel, lodgName, nAddr, roomCount, parking, lat, lon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLodgName() {
        return lodgName;
    }

    public void setLodgName(String lodgName) {
        this.lodgName = lodgName;
    }

    public String getnAddr() {
        return nAddr;
    }

    public void setnAddr(String nAddr) {
        this.nAddr = nAddr;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(String roomCount) {
        this.roomCount = roomCount;
    }

    public String isParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
