package br.com.lbernardo.graphdroid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Lucas on 18/03/2018.
 */

public class GraphView extends WebView {

    JSONArray data;
    JSONArray dataColor;
    Context context;

    public static String T_PIE = "pie";
    public static String T_LINE = "line";
    public static String T_BAR = "bar";
    public static String T_SCATTER = "scatter";
    public static String T_SPLINE = "spline";
    public static String T_STEP = "step";
    public static String T_AREA_LINE = "area";
    public static String T_AREA_SPLINE = "area-spline";
    public static String T_DONUT = "donut";
    public static String T_GAUGE = "gauge";

    private String type = "line";

    /**
     * constructor
     * @param context
     * @param attrs
     */
    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.data = new JSONArray();
        this.dataColor = new JSONArray();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        setWebViewClient(new WebViewClient());
        setPadding(5,5,5,5);
    }

    /**
     * Add data graph
     * @param data
     */
    public void addData(GraphData data) {
        JSONArray arr = new JSONArray();
        arr.put(data.getTitle());
        for (int i=0;i<data.getData().size();i++) {
            Double f = data.getData().get(i);
            arr.put(f);
            // verify exists color
            if (data.getColor() != null) {
                this.dataColor.put(data.getColor());
            }
        }
        this.data.put(arr);

    }

    /**
     * Set type graph
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Make Graph
     */
    public void make() {
        addJavascriptInterface(this,"graphview");
        loadUrl("file:///android_asset/index.html");
    }


    @android.webkit.JavascriptInterface
    public String getData() {
        return data.toString();
    }

    @android.webkit.JavascriptInterface
    public String getType() {
        return type;
    }


    @android.webkit.JavascriptInterface
    public String getColors() {
        if (dataColor.length() == 0){
            return "NONE";
        } else {
            return dataColor.toString();
        }
    }

}
