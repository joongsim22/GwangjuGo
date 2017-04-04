package gwangju.com.item;

public class ThemeListViewItem {
    private String themeTitle;
    private String themeExplain;

    public ThemeListViewItem(String themeTitle, String themeExplain) {
        this.themeTitle = themeTitle;
        this.themeExplain = themeExplain;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }

    public String getThemeExplain() {
        return themeExplain;
    }

    public void setThemeExplain(String themeExplain) {
        this.themeExplain = themeExplain;
    }
}
