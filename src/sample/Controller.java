package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;


public class Controller extends Application {

    @Override public void start(Stage stage) {
        List<Data> data = CSVReader.readCSVFile("src/2012_SAT_Results.csv");

        stage.setTitle("SAT Results 2012");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("SAT Reading");

        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("SAT Results 2012");

        XYChart.Series series = new XYChart.Series();
        series.setName("SAT Math");



        for(int i = 0; i<data.size();i++){
            Data   current = data.get(i);
            series.getData().add(new XYChart.Data(current.getReading(), current.getMath()));
        }


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}