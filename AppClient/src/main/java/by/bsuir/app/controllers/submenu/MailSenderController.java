//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.Account;
//import by.bsuir.app.entity.Message;
//import by.bsuir.app.entity.Position;
//import by.bsuir.app.exception.FieldIsEmptyException;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.services.GeneralFuncWindow;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import by.bsuir.app.util.constants.Constants;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.input.MouseEvent;
//import javafx.util.Callback;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.List;
//import java.util.ResourceBundle;
//
//import static by.bsuir.app.util.constants.Constants.*;
//
//public class MailSenderController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private TextArea text_field;
//
//    @FXML
//    private Button send_button;
//
//    @FXML
//    private Label warning_label;
//
//    @FXML
//    private TableView<Account> tableView;
//
//    @FXML
//    private TableColumn<Account, Long> ID;
//
//    @FXML
//    private TableColumn<Account, String> firstName;
//
//    @FXML
//    private TableColumn<Account, String> secondName;
//
//    @FXML
//    private TableColumn<Account, String> thirdName;
//
//    @FXML
//    private TableColumn<Account, String> position;
//
//    @FXML
//    private TableColumn<Account, String> mail;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        GeneralFuncWindow.closeApplication();
//    }
//
//    final Account[] eft = {null};
//
//    @FXML
//    void initialize() {
//
//
//        loadTableData();
//
//        tableView.setOnMouseClicked(mouseEvent -> eft[0] = tableView.getSelectionModel().getSelectedItem());
//
//        send_button.setOnAction(actionEvent -> sendMessage());
//    }
//
//    private void loadTableData() {
//        ID.setCellValueFactory(new PropertyValueFactory<Account, Long>("id"));
//        mail.setCellValueFactory(new PropertyValueFactory<Account, String>("email"));
//        position.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                        ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                Position position = param.getValue().getData().getPosition();
//                if (position != null)
//                    return new SimpleObjectProperty<>(position.getName());
//                return null;
//            }
//        });
//        position.setCellFactory(TextFieldTableCell.forTableColumn());
//        firstName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getName());
//            }
//        });
//        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
//        secondName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getSurname());
//            }
//        });
//        secondName.setCellFactory(TextFieldTableCell.forTableColumn());
//        thirdName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getThirdName());
//            }
//        });
//        thirdName.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        try {
//            tableView.setItems(getObserveValues());
//        } catch (IOException | GettingDataException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    private ObservableList getObserveValues() throws IOException, GettingDataException, ClassNotFoundException {
//
//        ObservableList<Account> obList = FXCollections.observableArrayList();
//
//        List<Account> accounts = (List<Account>) Phone.sendOrGetData(Commands.GET_ALL_USERS, new Account());
//
//        obList.addAll(accounts);
//
//        return obList;
//    }
//
//    private void sendMessage() {
//        String msg = text_field.getText();
//
//        try {
//            if (msg.isEmpty() || msg.length() < Constants.MIN_MESSAGE_LENGTH) {
//                warning_label.setText(MIN_MESSAGE_LENGTH_MSG);
//            } else {
//                if (eft[0] != null) {
//                    if (eft[0].getEmail().isEmpty())
//                        throw new FieldIsEmptyException(MAIL_IS_NOT_SET_MSG);
//
//                    Message message = new Message();
//                    message.setMessage(msg);
//                    message.setRecipient(eft[0].getEmail());
//                    Phone.sendOrGetData(Commands.SEND_MESSAGE_TO_USER, message);
//                    warning_label.setText(MESSAGE_SUCCESS_MSG);
//                } else {
//                    warning_label.setText(MESSAGE_CHOOSE_TO_SEND_MSG);
//                }
//            }
//        } catch (FieldIsEmptyException | IOException | ClassNotFoundException | GettingDataException e){
//            warning_label.setText(e.getMessage());
//        }
//        warning_label.setVisible(true);
//    }
//}
