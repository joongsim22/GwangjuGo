package gwangju.com.item;

import java.io.Serializable;

/**
 * Created by Beaver on 2017-04-04.
 */

public class StarItem implements Serializable{
    String text;
    int starCnt;

    public StarItem(String text, int starCnt) {
        this.text = text;
        this.starCnt = starCnt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStarCnt() {
        return starCnt;
    }

    public void setStarCnt(int starCnt) {
        this.starCnt = starCnt;
    }
}
