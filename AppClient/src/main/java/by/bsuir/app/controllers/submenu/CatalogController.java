//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.Product;
//import by.bsuir.app.entity.enums.ProductCategory;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import by.bsuir.app.util.constants.LocalStorage;
//import by.bsuir.app.util.constants.Paths;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.control.Button;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.VBox;
//import lombok.extern.log4j.Log4j2;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//import java.util.stream.Collectors;
//
//@Log4j2
//public class CatalogController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private ScrollPane scrollPane;
//
//    @FXML
//    private Button fish_filter;
//
//    @FXML
//    private Button dairy_filter;
//
//    @FXML
//    private Button meat_filter;
//
//    @FXML
//    private Button allFilter;
//
//    @FXML
//    private Button flavoring_filter;
//
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        scrollPane.getScene().getWindow().hide();
//    }
//
//    private List<Product> productsWithFilter = null;
//    private List<Product> productsAll = null;
//
//    {
//        try {
//            List<Product> products = (List<Product>) Phone.sendOrGetData(Commands.GET_ALL_PRODUCTS, new Product());
//            productsAll = new ArrayList<>(products);
//            productsWithFilter = new ArrayList<>(products);
//            LocalStorage.setProducts(products);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            log.error(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    @FXML
//    void initialize() {
//
//        draw();
//
//        allFilter.setOnAction(actionEvent -> setFilter(ProductCategory.ALL));
//
//        fish_filter.setOnAction(actionEvent -> setFilter(ProductCategory.FISH));
//
//        dairy_filter.setOnAction(actionEvent -> setFilter(ProductCategory.DAIRY));
//
//        meat_filter.setOnAction(actionEvent -> setFilter(ProductCategory.MEAT));
//
//        flavoring_filter.setOnAction(actionEvent -> setFilter(ProductCategory.FLAVORING));
//
//    }
//
//    private void draw() {
//
//        int size = productsWithFilter.size();
//        Node[] nodes = new Node[size];
//        VBox vBox = new VBox();
//        for (int i = 0; i < size; i++) {
//            try {
//                nodes[i] = (Node) FXMLLoader.load(getClass().getResource(Paths.WindowCatalogRow));
//                vBox.getChildren().add(nodes[i]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        scrollPane.setContent(vBox);
//    }
//
//    private void resetFilter() {
//        productsWithFilter = new ArrayList<>(productsAll);
//    }
//
//    private void serFilteredProductInStorage() {
//        LocalStorage.setProducts(productsWithFilter);
//    }
//
//    private void setFilter(ProductCategory productType) {
//        resetFilter();
//        if (productType != ProductCategory.ALL)
//            productsWithFilter = productsWithFilter.stream().filter(
//                    c -> c.getCategory().equals(productType.getRus())).collect(
//                    Collectors.toList());
//        serFilteredProductInStorage();
//        draw();
//    }
//
//    @FXML
//    private void onClickReload(MouseEvent event) {
//        try {
//            List<Product> products = (List<Product>) Phone.sendOrGetData(Commands.GET_ALL_PRODUCTS, new Product());
//            productsAll = new ArrayList<>(products);
//            productsWithFilter = new ArrayList<>(products);
//            LocalStorage.setProducts(products);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            log.error(e.getMessage());
//            e.printStackTrace();
//        }
//        draw();
//    }
//}
