//package by.bsuir.app.controllers.others;
//
//import by.bsuir.app.services.GeneralFuncWindow;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.chart.PieChart;
//import javafx.scene.control.Label;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.HBox;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class AgeAndQuantityAccountsPieChartController {
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
//    private PieChart pieChart;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        GeneralFuncWindow.closeApplication();
//    }
//
//    @FXML
//    void initialize() {
//
//        buildPieChart();
//
//    }
//
//    private void buildPieChart() {
//        try {
//            List<Object[]> ages = (List<Object[]>) Phone.sendOrGetData(Commands.GET_AGE_PERCENT_PROPORTION,
//                    new Product());
//
//            pieChart.setTitle(AGES_PERCENTAGE_MSG);
//            pieChart.setClockwise(true);
//            pieChart.setLabelLineLength(60);
//            pieChart.setLabelsVisible(true);
//            pieChart.setStartAngle(180);
//
//            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
//
//            int totalQuantity = 0;
//            for (Object object : ages) {
//
//                Map row = (Map) object;
//                String ageGroup = String.valueOf(((Integer) row.get("ageGroup"))) + " age";
//                BigInteger quantityBig = (BigInteger) row.get("quantity");
//                Integer quantity = quantityBig.intValue();
//                pieChartData.add(new PieChart.Data(ageGroup, quantity));
//                totalQuantity += quantity;
//            }
//            pieChart.setData(pieChartData);
//
//            number_label.setText(String.valueOf(totalQuantity));
//        } catch (IOException | GettingDataException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
