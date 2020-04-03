package com.xinjingjie.picServer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TotalPics implements Serializable {
    private int total;
    private int totalHits;
    private List<Picture> hits;

    public TotalPics() {
    }

    public TotalPics(int total, int totalHits, List<Picture> hits) {
        this.total = total;
        this.totalHits = totalHits;
        this.hits = hits;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<Picture> getHits() {
        return hits;
    }

    public void setHits(ArrayList<Picture> hits) {
        this.hits = hits;
    }
}
