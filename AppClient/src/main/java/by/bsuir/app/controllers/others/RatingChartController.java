//package by.bsuir.app.controllers.others;
//
//import by.bsuir.app.entity.Mark;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.services.GeneralFuncWindow;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import javafx.fxml.FXML;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.ScatterChart;
//import javafx.scene.chart.XYChart;
//import javafx.scene.control.Label;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.List;
//import java.util.ResourceBundle;
//
//import static by.bsuir.app.util.constants.Constants.MARK_MAP_MSG;
//
//public class RatingChartController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private HBox hBox;
//
//    @FXML
//    private Label warning_label;
//
//    @FXML
//    private Label number_label;
//
//    @FXML
//    private ScatterChart scatter;
//    ;
//
//    @FXML
//    private AnchorPane scene;
//
//    @FXML
//    private ScrollPane scrollPane;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        GeneralFuncWindow.closeApplication();
//    }
//
//    @FXML
//    void initialize() {
//        try {
//            List<Mark> marks = (List<Mark>) Phone.sendOrGetData(Commands.GET_ALL_MARKS, new Mark());
//
//            NumberAxis xAxis = new NumberAxis();
//            xAxis.setLabel("Глубина");
//
//            NumberAxis yAxis = new NumberAxis();
//            yAxis.setLabel("Оценки");
//
//            scatter = new ScatterChart(xAxis, yAxis);
//            scatter.setTitle("Карта выставленных оценок");
//
//            XYChart.Series dataSeries1 = new XYChart.Series();
//            dataSeries1.setName(MARK_MAP_MSG);
//
//            int totalQuantity = 0;
//            for (double i = 0.1; i <= 5.0; i += 0.1) {
//                for (Mark m : marks) {
//                    double design = Double.parseDouble(String.valueOf(m.getDesign()));
//                    double packageValue = Double.parseDouble(String.valueOf(m.getPackageValue()));
//                    double price = Double.parseDouble(String.valueOf(m.getPrice()));
//                    double service = Double.parseDouble(String.valueOf(m.getService()));
//                    double repair = Double.parseDouble(String.valueOf(m.getRepair()));
//
//                    totalQuantity = getTotalQuantity(dataSeries1, totalQuantity, i, design, packageValue);
//                    totalQuantity = getTotalQuantity(dataSeries1, totalQuantity, i, price, service);
//                    if (repair >= i && repair <= i + 0.1) {
//                        dataSeries1.getData().add(new XYChart.Data(repair, i));
//                        totalQuantity++;
//                    }
//                }
//            }
//
//            scatter.getData().add(dataSeries1);
//
//            VBox vbox = new VBox(scatter);
//            scrollPane.setContent(vbox);
//
//            number_label.setText(String.valueOf(totalQuantity));
//        } catch (IOException | GettingDataException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private int getTotalQuantity(XYChart.Series dataSeries1, int totalQuantity, double i, double price,
//            double service) {
//        if (price >= i && price <= i + 0.1) {
//            dataSeries1.getData().add(new XYChart.Data(price, i));
//            totalQuantity++;
//        }
//        if (service >= i && service <= i + 0.1) {
//            dataSeries1.getData().add(new XYChart.Data(service, i));
//            totalQuantity++;
//        }
//        return totalQuantity;
//    }
//
//
//}
