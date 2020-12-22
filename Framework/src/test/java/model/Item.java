package model;

public class Item {
    private String url;
    private String size;
    private String width;

    public String getSize() {
        return size;
    }

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Item(String url, String width, String size) {
        this.url = url;
        this.width = width;
        this.size = size;
    }
}
