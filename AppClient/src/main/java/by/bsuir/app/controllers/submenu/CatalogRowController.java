//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.Mark;
//import by.bsuir.app.entity.Product;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.services.Calculator;
//import by.bsuir.app.services.GeneralFuncWindow;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import by.bsuir.app.util.constants.LocalStorage;
//import by.bsuir.app.util.constants.Paths;
//import javafx.fxml.FXML;
//import javafx.scene.control.Hyperlink;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import lombok.extern.log4j.Log4j2;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.util.List;
//import java.util.ResourceBundle;
//
//@Log4j2
//public class CatalogRowController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private ImageView imageView;
//
//    @FXML
//    private Label product_label;
//
//    @FXML
//    private Label category_label;
//
//    @FXML
//    private Label quantity_label;
//
//    @FXML
//    private Label owner_label;
//
//    @FXML
//    private Label price_label;
//
//    @FXML
//    private Label rate_label;
//
//    @FXML
//    private Label id_label_hide;
//
//    @FXML
//    private Hyperlink comparison_add_button;
//
//    @FXML
//    private Hyperlink feedback_button;
//
//    @FXML
//    private Hyperlink estimate;
//
//    @FXML
//    private Label war_label;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        imageView.getScene().getWindow().hide();
//    }
//
//    @FXML
//    void initialize() {
//        initializeRowsWithData();
//    }
//
//    private void initializeRowsWithData() {
//
//
//        addInfoInRow();
//
//        comparison_add_button.setOnAction(actionEvent -> {
//            try {
//                if (LocalStorage.getProductsToCompare().size() >= 5)
//                    throw new IllegalStateException("Максимально 5 товаров");
//
//                Long id = Long.valueOf(id_label_hide.getText());
//                Product product = (Product) Phone.sendOrGetData(Commands.GET_PRODUCT_BY_ID, id);
//                LocalStorage.addProductToCompare(product);
//                war_label.setText("Добавлено");
//
//            } catch (IOException | ClassNotFoundException | GettingDataException e) {
//                war_label.setText("Не добавлено");
//                log.error(e.getMessage());
//                e.printStackTrace();
//            }
//            comparison_add_button.setDisable(true);
//            war_label.setVisible(true);
//        });
//
//        estimate.setOnAction(actionEvent -> {
//            try {
//                Product product = new Product();
//                product.setId(Long.valueOf(id_label_hide.getText()));
//                LocalStorage.setSelectedProduct(product);
//                GeneralFuncWindow.openNewScene(Paths.WindowAddRate);
//                estimate.setDisable(true);
//            } catch (Exception e) {
//                log.error(e);
//            }
//        });
//
//        feedback_button.setOnAction(actionEvent -> {
//            try {
//                LocalStorage.setProductID(Long.valueOf(id_label_hide.getText()));
//                GeneralFuncWindow.openNewScene(Paths.WindowFeedback);
//                feedback_button.setDisable(true);
//            } catch (Exception e) {
//                log.error(e);
//            }
//        });
//    }
//
//    private void addInfoInRow() {
//        Product product = LocalStorage.getFirstProduct();
//        Long productId = product.getId();
//
//        id_label_hide.setText(String.valueOf(productId));
//        product_label.setText(product.getName());
//        category_label.setText(product.getCategory());
//
//
//        quantity_label.setText(String.valueOf(product.getQuantity()));
//        owner_label.setText(String.valueOf(product.getOwner().getRus()));
//        price_label.setText(String.valueOf(product.getPrice()));
//
//        try {
//            List<Mark> marks = (List<Mark>) Phone.sendOrGetData(Commands.GET_ALL_MARKS_BY_PRODUCT_ID, productId);
//
//            String resultString;
//            double result;
//            if (!marks.isEmpty()) {
//                result = Calculator.getAverageMark(marks);
//                resultString = String.format("%.2f", result);
//            }
//            else
//                resultString = "---";
//
//            rate_label.setText(resultString);
//
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            e.printStackTrace();
//        }
//
//        String photoURL = product.getPhotoURL();
//        if (photoURL != null)
//            imageView.setImage(new Image(new File(photoURL).toURI().toString()));
//
//    }
//}
