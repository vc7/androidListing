package com.vc7.listing;

/**
 * Created by vincent on 2016/11/01.
 */

public class Item {

    private String header = "";
    private String title = "";

    public Item(String header, String title) {
        this.header = header;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getHeader() {
        return header;
    }
}
