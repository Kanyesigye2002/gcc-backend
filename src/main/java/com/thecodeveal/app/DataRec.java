package com.thecodeveal.app;

public class DataRec {
    public String link;

    public DataRec(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "DataRec{" +
                "link='" + link + '\'' +
                '}';
    }
}
