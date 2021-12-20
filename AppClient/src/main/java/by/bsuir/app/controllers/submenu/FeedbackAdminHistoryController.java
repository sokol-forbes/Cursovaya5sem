//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.Feedback;
//import by.bsuir.app.entity.enums.Role;
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
//import javafx.scene.layout.VBox;
//import lombok.extern.log4j.Log4j2;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//@Log4j2
//public class FeedbackAdminHistoryController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Label count_requests_field;
//
//    @FXML
//    private Label count_answers_field;
//
//    @FXML
//    private ScrollPane scrollPane;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        scrollPane.getScene().getWindow().hide();
//    }
//
//
//    List<Feedback> feedbacks = null;
//
//    @FXML
//    void initialize() {
//        try {
//            feedbacks = (List<Feedback>) Phone.sendOrGetData(Commands.GET_ALL_USERS_FEEDBACKS, new Feedback());
//
//            LocalStorage.setFeedbacks(new ArrayList<>(feedbacks));
//
//            int size = feedbacks.size();
//            Node[] nodes = new Node[size];
//            VBox vBox = new VBox();
//            for (int i = 0; i < size; i++) {
//                nodes[i] = FXMLLoader.load(getClass().getResource(Paths.WindowHistoryRow));
//                vBox.getChildren().add(nodes[i]);
//            }
//            scrollPane.setContent(vBox);
//
//            setLabelsData();
//
//        } catch (ClassNotFoundException | GettingDataException | IOException e) {
//            log.error(e.getMessage() + e);
//        }
//    }
//    private void setLabelsData() {
//        int count_request = feedbacks.size();
//        count_requests_field.setText(String.valueOf(count_request));
//        int count_answers = countAnswersField();
//        count_answers_field.setText(String.valueOf(count_answers));
//    }
//
//    private int countAnswersField() {
//        int count = 0;
//        for (Feedback f : feedbacks) {
//            if (f.getAnswer() != null)
//                count++;
//        }
//
//        return count;
//    }
//}
