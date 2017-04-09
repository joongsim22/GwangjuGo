package gwangju.com;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import gwangju.com.item.RoomsXMLItem;

public class RoomsXML {

    String url = "http://openapi.gwangju.go.kr/openapi-data/service/gjtourlodge/getTourLodge?pageNo=1&numOfRows=450&ServiceKey=Yge3Wr1lceSnZiFDwF2YVlZhJzAGEuIMdq1IoNB7s9ncZlaNiozCEEeyFqb%2B6j69p5czy7Ajf9Ls%2BdFaRSWdSg%3D%3D";
    ArrayList<RoomsXMLItem> roomsItemList = new ArrayList<>();
    URL roomsURL;
    String tagName = "";
    String title, tel, lodgName, nAddr, roomCount, parking, lat, lon;

    public ArrayList<RoomsXMLItem> getData() {

        try {
            roomsURL = new URL(url);
            InputStream in = roomsURL.openStream();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(in, "utf-8");
            int eventType = xpp.getEventType();
            boolean isItemTag = false;

            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG) {
                    tagName = xpp.getName();
                    if (tagName.equals("item")) {
                        isItemTag = true;
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    if (isItemTag && tagName.equals("title")) {
                        title = xpp.getText();
                    }
                    if (isItemTag && tagName.equals("lodgName")) {
                        lodgName = xpp.getText();
                    }
                    if (isItemTag && tagName.equals("tel")) {
                        tel = xpp.getText();
                    }
                    if (isItemTag && tagName.equals("NAddr")) {
                        nAddr = xpp.getText();
                    }
                    if (isItemTag && tagName.equals("lat")) {
                        lat = xpp.getText();
                    }
                    if (isItemTag && tagName.equals("lon")) {
                        lon = xpp.getText();
                    }
                    if (isItemTag && tagName.equals("roomCount")) {
                        roomCount = xpp.getText();
                    }
                    if (isItemTag && tagName.equals("parking")) {
                        parking = xpp.getText();
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    tagName = xpp.getName();
                    if (tagName.equals("item")) {
                        Log.e("들어가는 이름",title);
                        Log.e("들어가는 종류",lodgName);
                        RoomsXMLItem item = new RoomsXMLItem();
                        item.setLodgName(lodgName);
                        item.setTitle(title);
                        item.setLat(lat);
                        item.setLon(lon);
                        item.setnAddr(nAddr);
                        item.setParking(parking);
                        item.setRoomCount(roomCount);
                        item.setTel(tel);
                        roomsItemList.add(item);
                    }
                }
                eventType = xpp.next();
            }
        } catch (Exception e) {
            Log.e("NewsApp", "예외발생 : " + e.getMessage());
        }
        return roomsItemList;
    }
}
