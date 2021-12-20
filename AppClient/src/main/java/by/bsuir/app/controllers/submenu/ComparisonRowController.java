//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.Mark;
//import by.bsuir.app.entity.Product;
//import by.bsuir.app.services.Calculator;
//import by.bsuir.app.util.constants.LocalStorage;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.VBox;
//
//import java.io.File;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//import java.util.stream.Collectors;
//
//@SuppressWarnings("unchecked")
//public class ComparisonRowController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private VBox here;
//
//    @FXML
//    private Label name_label;
//
//    @FXML
//    private Label category_label;
//
//    @FXML
//    private Label design_label;
//
//    @FXML
//    private Label package_label;
//
//    @FXML
//    private Label price_label;
//
//    @FXML
//    private Label service_label;
//
//    @FXML
//    private Label repair_label;
//
//    @FXML
//    private Label manufucturer_label;
//    @FXML
//    private ImageView imageView;
//
//    @FXML
//    void initialize() {
//
//        addInfoInRow();
//    }
//
//    private void addInfoInRow() {
//        Product product = LocalStorage.getFirstProductToCompare();
//
//        String name = product.getName();
//
//        if (name != null)
//            name_label.setText(name);
//
//        category_label.setText(product.getCategory());
//
//        List<Mark> marks = new ArrayList<>(LocalStorage.getMarks());
//        List<Mark> filteredMarks = marks.stream().filter(
//                e -> e.getProduct_id().equals(product.getId())).collect(
//                Collectors.toList());
//
//        if (!filteredMarks.isEmpty()) {
//            double design = Calculator.getAverageMark(filteredMarks, 0);
//            String resultString = String.format("%.2f", design);
//            design_label.setText(String.valueOf(resultString));
//
//            design = Calculator.getAverageMark(filteredMarks, 1);
//            resultString = String.format("%.2f", design);
//            package_label.setText(String.valueOf(resultString));
//
//            design = Calculator.getAverageMark(filteredMarks, 2);
//            resultString = String.format("%.2f", design);
//            price_label.setText(String.valueOf(resultString));
//
//            design = Calculator.getAverageMark(filteredMarks, 3);
//            resultString = String.format("%.2f", design);
//            service_label.setText(String.valueOf(resultString));
//
//            design = Calculator.getAverageMark(filteredMarks, 4);
//            resultString = String.format("%.2f", design);
//            repair_label.setText(String.valueOf(resultString));
//
//        }
//
//        manufucturer_label.setText(product.getOwner().getRus());
//        String photoURL = product.getPhotoURL();
//        if (photoURL != null)
//            imageView.setImage(new Image(new File(photoURL).toURI().toString()));
//
//    }
//
//}
