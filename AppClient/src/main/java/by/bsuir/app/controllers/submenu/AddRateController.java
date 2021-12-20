//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.Mark;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import by.bsuir.app.util.constants.LocalStorage;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.input.MouseEvent;
//import lombok.extern.log4j.Log4j2;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//@Log4j2
//public class AddRateController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button registrationButton;
//
//    @FXML
//    private Button returnButton;
//
//    @FXML
//    private Label war_label;
//
//    @FXML
//    private ComboBox<BigDecimal> design_box;
//
//    @FXML
//    private ComboBox<BigDecimal> package_box;
//
//    @FXML
//    private ComboBox<BigDecimal> price_box;
//
//    @FXML
//    private ComboBox<BigDecimal> service_box;
//
//    @FXML
//    private ComboBox<BigDecimal> repair_box;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        closeThisWindow();
//    }
//
//    private static final String MIN_RATE = "Рейтинг от 0.1 до 5";
//
//    @FXML
//    void initialize() {
//
//        ObservableList<BigDecimal> ol_values = FXCollections.observableArrayList();
//        for (double i = 1.0; i <= 5.0; i++) {
//            ol_values.add(BigDecimal.valueOf(i));
//        }
//        design_box.setItems(ol_values);
//        package_box.setItems(ol_values);
//        price_box.setItems(ol_values);
//        service_box.setItems(ol_values);
//        repair_box.setItems(ol_values);
//
//
//        registrationButton.setOnAction(e -> {
//
//            try {
//                Mark mark = new Mark(LocalStorage.getSelectedProduct().getId());
//
//                BigDecimal design = stringToBigDecimal(String.valueOf(design_box.getValue()));
//                checkBigDecimal(design);
//                mark.setDesign(design);
//
//                BigDecimal packageBoxValue =
//                        stringToBigDecimal(String.valueOf(package_box.getValue()));
//                checkBigDecimal(packageBoxValue);
//                mark.setPackageValue(packageBoxValue);
//
//                BigDecimal price = stringToBigDecimal(String.valueOf(price_box.getValue()));
//                checkBigDecimal(price);
//                mark.setPrice(price);
//
//                BigDecimal service = stringToBigDecimal(String.valueOf(service_box.getValue()));
//                checkBigDecimal(service);
//                mark.setService(service);
//
//                BigDecimal repair = stringToBigDecimal(String.valueOf(repair_box.getValue()));
//                checkBigDecimal(repair);
//                mark.setRepair(repair);
//
//                Phone.sendOrGetData(Commands.ADD_PRODUCT_RATE, mark);
//
//                war_label.setText("Оценка добавлена");
//                war_label.setVisible(true);
//
//                Thread.sleep(2000);
//                closeThisWindow();
//            } catch (IllegalArgumentException ex) {
//                war_label.setText(ex.getMessage());
//                log.error(ex);
//            } catch (IOException | GettingDataException | ClassNotFoundException ee) {
//                war_label.setText("Не удалось добавить оценку");
//                log.error(ee);
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }
//            war_label.setVisible(true);
//        });
//        returnButton.setOnAction(e -> closeThisWindow());
//    }
//
//    private void closeThisWindow() {
//        registrationButton.getScene().getWindow().hide();
//    }
//
//    private void checkBigDecimal(BigDecimal argument) {
//
//        if (argument == null) {
//            throw new IllegalArgumentException("Заполните поля");
//        }
//
//        double arg = Double.parseDouble(String.valueOf(argument));
//
//        if (arg <= 0.0 || arg > 5.0) {
//            throw new IllegalArgumentException(MIN_RATE);
//        }
//
//    }
//
//    private String comaToPointStringReplacer(String str) {
//        return str.replace(",", ".");
//    }
//
//    private BigDecimal stringToBigDecimal(String str) {
//        String valueWithPoint = comaToPointStringReplacer(str);
//        return BigDecimal.valueOf(Double.parseDouble(valueWithPoint));
//    }
//}
