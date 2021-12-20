//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.Mark;
//import by.bsuir.app.entity.Product;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import by.bsuir.app.util.constants.LocalStorage;
//import by.bsuir.app.util.constants.Paths;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.control.Label;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.HBox;
//import lombok.extern.log4j.Log4j2;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Log4j2
//public class ComparisonPageController {
//
//    @FXML
//    private ScrollPane scrollPane;
//
//    @FXML
//    private Label warning_label;
//
//    @FXML
//    private HBox pane;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        scrollPane.getScene().getWindow().hide();
//    }
//
//    @FXML
//    void initialize() {
//        draw();
//    }
//
//    private List<Product> compareProductsList = new ArrayList<>(LocalStorage.getProductsToCompare());
//    private List<Mark> marksAll = null;
//
//    {
//        try {
//            marksAll  = (List<Mark>) Phone.sendOrGetData(Commands.GET_ALL_MARKS, new Mark());
//            LocalStorage.setMarks(new ArrayList<>(marksAll));
//
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            log.error(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    private void draw() {
//
//        int size = compareProductsList.size();
//        Node[] nodes = new Node[size];
//        HBox hBox = new HBox();
//        for (int i = 0; i < size; i++) {
//            try {
//                nodes[i] = (Node) FXMLLoader.load(getClass().getResource(Paths.WindowComparisonRow));
//                hBox.getChildren().add(nodes[i]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        scrollPane.setContent(hBox);
//    }
//}
