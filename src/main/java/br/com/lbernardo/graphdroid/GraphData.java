package br.com.lbernardo.graphdroid;

import java.util.ArrayList;

/**
 * Created by Lucas on 19/03/2018.
 */

public class GraphData {
    protected String title;
    protected ArrayList<Double> data;
    protected String color;

    public GraphData(String title) {
        this.title = title;
        this.data = new ArrayList<Double>();
    }

    /**
     * Set float data
     * @param data
     */
    public void setData(double data) {
        this.data.add(data);
    }

    /**
     * Set int data
     * @param data
     */
    public void setData(int data) {
        this.data.add((double) data);
    }


    /**
     * Set color data
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Get color data
     * @return
     */
    public String getColor() {
        return this.color;
    }

    public ArrayList<Double> getData() {
        return this.data;
    }

    public String getTitle() {
        return title;
    }


}
