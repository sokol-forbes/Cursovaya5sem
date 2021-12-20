//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.Product;
//import by.bsuir.app.entity.enums.Owner;
//import by.bsuir.app.entity.enums.ProductCategory;
//import by.bsuir.app.exception.FieldIsEmptyException;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.input.MouseEvent;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//import lombok.extern.log4j.Log4j2;
//
//import java.io.File;
//import java.io.IOException;
//import java.math.BigDecimal;
//
//import static by.bsuir.app.util.constants.Constants.*;
//
//@Log4j2
//public class AddProductController {
//
//    @FXML
//    private Label label;
//
//    @FXML
//    private TextField name_field;
//
//    @FXML
//    private ComboBox<String> category_field;
//
//    @FXML
//    private ComboBox<String> owner_field;
//
//    @FXML
//    private TextField price_field;
//
//    @FXML
//    private TextField quantity_field;
//
//    @FXML
//    private Button addButton;
//
//    @FXML
//    private Label war_label;
//
//    Product product = new Product();
//
//    @FXML
//    void closeHandler(MouseEvent event) {
//        addButton.getScene().getWindow().hide();
//    }
//
//    private static final String REGEX_INT = "[0-9]*";
//    private static final String REGEX_DOUBLE = "[0-9]*(.|,)[0-9]{2}";
//
//    @FXML
//    void initialize() {
//
//        ObservableList<String> ol_owners = FXCollections.observableArrayList();
//        for (Owner m : Owner.values()) {
//            ol_owners.add(m.getRus());
//        }
//        owner_field.setItems(ol_owners);
//
//        ObservableList<String> ol_categories = FXCollections.observableArrayList();
//        for (ProductCategory p : ProductCategory.values())
//            ol_categories.add(p.getRus());
//        ol_categories.remove(ProductCategory.ALL);
//
//        category_field.setItems(ol_categories);
//
//        addButton.setOnAction(actionEvent -> {
//            try {
//                String name = name_field.getText();
//                String category = category_field.getValue();
//                String owner = owner_field.getValue();
//                String quantity = quantity_field.getText();
//                String price = price_field.getText().replace(",", ".");
//
//                if (!price.matches(REGEX_DOUBLE) || !quantity.matches(
//                        REGEX_INT) || name.isEmpty() || category.isEmpty() || owner == null)
//                    throw new FieldIsEmptyException(FILL_FIELDS_MSG);
//
//                product.setName(name);
//                product.setCategory(category);
//                for (Owner o: Owner.values())
//                    if (o.getRus().equals(owner)) {
//                        product.setOwner(o);
//                        break;
//                    }
//                product.setQuantity(Integer.parseInt(quantity));
//                product.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
//
//                Phone.sendOrGetData(Commands.ADD_OR_UPDATE_PRODUCT, product);
//                war_label.setText(ADD_SUCCESS_MSG);
//                war_label.setVisible(true);
//
//            } catch (IOException | GettingDataException | ClassNotFoundException e) {
//                log.error(e.getMessage());
//                war_label.setText(ADD_FAIL_MSG);
//                e.printStackTrace();
//            } catch (FieldIsEmptyException e) {
//                war_label.setText(e.getMessage());
//            } catch (NumberFormatException e) {
//                war_label.setText(USE_COMA_INSTEADOF_POINT_MSG);
//            }
//            war_label.setVisible(true);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            war_label.getScene().getWindow().hide();
//        });
//    }
//
//    @FXML
//    private void onMouseClickedAddPhoto(MouseEvent event) {
//        final FileChooser fileChooser = new FileChooser();
//
//        fileChooser.setTitle("Select Pictures");
//
//        // Set Initial Directory
//        fileChooser.setInitialDirectory(
//                new File(LOAD_ICONS_PATH));
//
//        // Add Extension Filters
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("PNG", "*.png"));
//        new FileChooser.ExtensionFilter("JPG", "*.jpg");
//
//        File file = fileChooser.showOpenDialog(new Stage());
//
//        product.setPhotoURL(file.getAbsolutePath());
//    }
//}
