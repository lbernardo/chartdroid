# Chartdroid
Use graphics in your Android apps. ChartDroid uses C3.js to generate elegant graphics

## Create Chart
Use the code below to create charts

**res/layout/activity_main.xml**
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <br.com.lbernardo.chartdroid.GraphView
        android:id="@+id/graph"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></br.com.lbernardo.chartdroid.GraphView>

</LinearLayout>
```

**MainActivity.java**
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    GraphView graphView = (GraphView) findViewById(R.id.graph);
    // Set Chart Type Pie
    graphView.setType(GraphView.T_PIE);
    // Data 1
    GraphData data1 = new GraphData("How I met your mother");
    data1.setDate(10);
    // Data 2
    GraphData data2 = new GraphData("Friends");
    data2.setDate(30);

    // Set N data Chart
    graphView.addData(data1);
    graphView.addData(data2);

    // Generate Chart
    graphView.make();
}
```
## Set type Chart

- GraphView.T_PIE : Pie chart
- GraphView.T_LINE : Line chart
- GraphView.T_BAR : Bar chart
- GraphView.T_SCATTER : Scatter chart
- GraphView.T_SPLINE : Display as Spline Chart
- GraphView.T_STEP : Display as Step Chart
- GraphView.T_AREA_LINE : Display as Area Chart
- GraphView.T_AREA_SPLINE : Display as Stacked Area Chart
- GraphView.T_DONUT : Display as Donut Chart
- GraphView.T_GAUGE : Display as Gauge Chart

## Set color data
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    GraphView graphView = (GraphView) findViewById(R.id.graph);
    // Set Chart Type Pie
    graphView.setType(GraphView.T_PIE);
    // Data 1
    GraphData data1 = new GraphData("How I met your mother");
    data1.setDate(10);
    data1.setColor("red")
    // Data 2
    GraphData data2 = new GraphData("Friends");
    data2.setColor("#e8eefa");
    data2.setDate(30);

    // Set N data Chart
    graphView.addData(data1);
    graphView.addData(data2);

    // Generate Chart
    graphView.make();
}
```

