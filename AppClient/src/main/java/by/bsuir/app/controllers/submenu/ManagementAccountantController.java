//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.*;
//import by.bsuir.app.entity.enums.PositionType;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.services.DateHandler;
//import by.bsuir.app.services.reportFactory.ReportFactory;
//import by.bsuir.app.services.reportFactory.ReportTypes;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import com.itextpdf.text.DocumentException;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.input.MouseEvent;
//import javafx.util.Callback;
//import javafx.util.converter.BigDecimalStringConverter;
//import javafx.util.converter.FormatStringConverter;
//import lombok.extern.log4j.Log4j2;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//import static by.bsuir.app.util.constants.Constants.*;
//
//@Log4j2
//public class ManagementAccountantController {
//
//    @FXML
//    private TableView<Account> employee_table;
//
//    @FXML
//    private TableColumn<Account, String> name_column;
//
//    @FXML
//    private TableColumn<Account, String> surname_column;
//
//    @FXML
//    private TableColumn<Account, String> thirdName_column;
//
//    @FXML
//    private TableColumn<?, String> mail_column;
//
//    @FXML
//    private TableColumn<Account, Integer> age_column;
//
//    @FXML
//    private TableColumn<Account, String> position_column;
//
//    @FXML
//    private TableColumn<Account, String> phone_column;
//
//    @FXML
//    private TableColumn<Account, BigDecimal> salary_column;
//
//    @FXML
//    private TableColumn<Account, Date> start_column;
//
//    @FXML
//    private TableColumn<Account, Date> fire_column;
//
//    @FXML
//    private TextField filterField;
//
//    @FXML
//    private Label warning_account_label;
//
//    @FXML
//    private TableView<Mark> marks_table;
//
//    @FXML
//    private TableColumn<Mark, Integer> id_column;
//
//    @FXML
//    private TableColumn<Mark, BigDecimal> design_column;
//
//    @FXML
//    private TableColumn<Mark, BigDecimal> package_column;
//
//    @FXML
//    private TableColumn<Mark, BigDecimal> price_column;
//
//    @FXML
//    private TableColumn<Mark, BigDecimal> service_column;
//
//    @FXML
//    private TableColumn<Mark, BigDecimal> repair_column;
//
//    @FXML
//    private Label warning_marks_label;
//
//    @FXML
//    private Button back_button;
//
//    @FXML
//    private Button create_report_button;
//
//    @FXML
//    private ComboBox<String> extension_box;
//
//    @FXML
//    private Button buttonDelete;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        warning_account_label.getScene().getWindow().hide();
//    }
//
//    private List<Account> accounts;
//    private ReportFactory reportFactory = ReportFactory.getInstance();
//
//    @FXML
//    void initialize() {
//
//        updateAccountTable();
//        updateMarkTable();
//
//        ObservableList<String> ol_reports = FXCollections.observableArrayList();
//        for (ReportTypes b : ReportTypes.values())
//            ol_reports.add(String.valueOf(b));
//        extension_box.setItems(ol_reports);
//
//        create_report_button.setOnAction(event -> {
//            createReport();
//        });
//
////        buttonAdd.setOnAction(actionEvent -> {
////            GeneralFuncWindow.openNewScene(Paths.WindowAddEmployee);
////            updateAccountTable();
////        });
//
//        buttonDelete.setOnAction(actionEvent -> deleteAccount());
//
//    }
//
//    private void deleteAccount() {
//        try {
//            Account account = (Account) employee_table.getSelectionModel().getSelectedItem();
//            if (account != null) {
//                Phone.sendOrGetData(Commands.DELETE_USER_BY_ID, account.getId());
//                warning_account_label.setText(DELETE_SUCCESS_MSG);
//                updateAccountTable();
//            } else {
//                warning_account_label.setText(ERROR_SELECT_FIELD_MSG);
//            }
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            warning_account_label.setText(DELETE_FAIL_MSG);
//            log.error(e);
//            e.printStackTrace();
//        }
//        warning_account_label.setVisible(true);
//    }
//
//    private void createReport() {
//        try {
//            ReportTypes type = ReportTypes.valueOf(extension_box.getValue());
//            if (type == ReportTypes.PDF)
//                reportFactory.getReport(ReportTypes.PDF).createReport();
//            else if (type == ReportTypes.TXT)
//                reportFactory.getReport(ReportTypes.TXT).createReport();
//            else
//                warning_account_label.setText(REPORT_CHOOSE_EXTENSION_MSG);
//
//            warning_account_label.setText(REPORT_SUCCESS_MSG);
//
//        } catch (IOException | GettingDataException | ClassNotFoundException e) {
//            log.error(e);
//            warning_account_label.setText(REPORT_FAILURE_MSG);
//        } catch (DocumentException e) {
//        }
//
//        warning_account_label.setVisible(true);
//    }
//
//    private void fillAccountTableWithFilteredData() {
//
//        try {
//            ObservableList<Account> ol_accounts = FXCollections.observableArrayList();
//
//            accounts = (List<Account>) Phone.sendOrGetData(Commands.GET_ALL_USERS, new Product());
//            ol_accounts.addAll(accounts);
//
//            // Wrap the ObservableList in a FilteredList (initially display all data).
//            FilteredList<Account> filteredData = new FilteredList<>(ol_accounts, b -> true);
//
//            // 2. Set the filter Predicate whenever the filter changes.
//            filterField.textProperty().addListener((observable, oldValue, newValue) -> {
//                filteredData.setPredicate(e -> {
//                    // If filter text is empty, display all persons.
//
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//
//                    // Compare first name and last name of every person with filter text.
//                    String lowerCaseFilter = newValue.toLowerCase();
//
//                    PersonalData data = e.getData();
//
//                    if (e.getEmail() != null && e.getEmail().toLowerCase().contains(lowerCaseFilter)) {
//                        return true;
//                    } else {
//                        if (data != null) {
//                            if (data.getName() != null && data.getName().toLowerCase().contains(lowerCaseFilter)) {
//                                return true;
//                            } else if (data.getSurname() != null && data.getSurname().toLowerCase().contains(
//                                    lowerCaseFilter)) {
//                                return true;
//                            } else if (data.getThirdName() != null && data.getThirdName().toLowerCase().contains(
//                                    lowerCaseFilter)) {
//                                return true;
//                            } else if (data.getPhone() != null && data.getPhone().toLowerCase().contains(
//                                    lowerCaseFilter)) {
//                                return true;
//                            } else if (data.getPosition() != null && data.getPosition().getName() != null && data.getPosition().getName().contains(
//                                    lowerCaseFilter)) {
//                                return true;
//                            } else if (data.getEmplEndDate() != null && String.valueOf(
//                                    data.getEmplEndDate()).toLowerCase().contains(
//                                    lowerCaseFilter)) {
//                                return true;
//                            } else if (data.getEmplStartDate() != null && String.valueOf(
//                                    data.getEmplStartDate()).toLowerCase().contains(
//                                    lowerCaseFilter)) {
//                                return true;
//                            } else
//                                return false; // Does not match.
//                        }
//                    }
//                    return false;
//                });
//            });
//
//            // 3. Wrap the FilteredList in a SortedList.
//            SortedList<Account> sortedData = new SortedList<>(filteredData);
//
//            // 4. Bind the SortedList comparator to the TableView comparator.
//            // 	  Otherwise, sorting the TableView would have no effect.
//            sortedData.comparatorProperty().bind(employee_table.comparatorProperty());
//
//            // 5. Add sorted (and filtered) data to the table.
//            employee_table.setItems(sortedData);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void bindDataInAccountTable() {
//        mail_column.setCellValueFactory(new PropertyValueFactory<>("email"));
//        age_column.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getData().getAge()));
//
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//
//        start_column.setCellFactory(column -> {
//            TableCell<Account, Date> cell = new TableCell<Account, Date>() {
//                @Override
//                protected void updateItem(Date item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty || item == null) {
//                        setText(null);
//                    } else {
//                        setText(format.format(item));
//                    }
//                }
//            };
//
//            return cell;
//        });
//
//
//        start_column.setCellValueFactory(param -> {
//            PersonalData personalData = param.getValue().getData();
//            if (personalData.getEmplStartDate() != null)
//                return new SimpleObjectProperty<>(personalData.getEmplStartDate());
//            else return null;
//        });
//        start_column.setCellFactory(TextFieldTableCell.forTableColumn(new FormatStringConverter<>(format)));
//
//
//        fire_column.setCellFactory(column -> {
//            TableCell<Account, Date> cell = new TableCell<Account, Date>() {
//                private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//
//                @Override
//                protected void updateItem(Date item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty || item == null) {
//                        setText(null);
//                    } else {
//                        setText(format.format(item));
//                    }
//                }
//            };
//
//            return cell;
//        });
//        fire_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, Date>,
//                ObservableValue<Date>>() {
//            @Override
//            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Account, Date> param) {
//                PersonalData personalData = param.getValue().getData();
//                if (personalData.getEmplEndDate() != null)
//                    return new SimpleObjectProperty<>(personalData.getEmplEndDate());
//                else return null;
//            }
//        });
//        fire_column.setCellFactory(TextFieldTableCell.forTableColumn(new FormatStringConverter<>(format)));
//
//        position_column.setCellValueFactory(param -> {
//            Position position = param.getValue().getData().getPosition();
//            if (position != null)
//                return new SimpleObjectProperty<>(position.getName());
//            return null;
//        });
//        position_column.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        name_column.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getData().getName()));
//        surname_column.setCellValueFactory(
//                param -> new SimpleObjectProperty<>(param.getValue().getData().getSurname()));
//        thirdName_column.setCellValueFactory(
//                param -> new SimpleObjectProperty<>(param.getValue().getData().getThirdName()));
//
//        phone_column.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getData().getPhone()));
//
//        salary_column.setCellValueFactory(
//                param -> new SimpleObjectProperty<>(param.getValue().getData().getPosition().getSalary()));
//        salary_column.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
//
//    }
//
//    private void bindDataInMarkTable() {
//        id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
//        design_column.setCellValueFactory(new PropertyValueFactory<>("design"));
//        design_column.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
//        package_column.setCellValueFactory(new PropertyValueFactory<>("packageValue"));
//        package_column.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
//        service_column.setCellValueFactory(new PropertyValueFactory<>("service"));
//        service_column.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
//        repair_column.setCellValueFactory(new PropertyValueFactory<>("repair"));
//        repair_column.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
//        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
//        price_column.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
//
//    }
//
//    private void fillMarkTableWithFilteredData() {
//        //TODO IF NEED SEARCH IN MARKS
//        try {
//            ObservableList<Mark> ol_marks = FXCollections.observableArrayList();
//
//            List<Mark> marks = (List<Mark>) Phone.sendOrGetData(Commands.GET_ALL_MARKS, new Mark());
//            ol_marks.addAll(marks);
//
//            marks_table.setItems(ol_marks);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void updateMarkTable() {
//        bindDataInMarkTable();
//        fillMarkTableWithFilteredData();
//    }
//
//    void updateAccountTable() {
//        bindDataInAccountTable();
//        fillAccountTableWithFilteredData();
//    }
//
//    @FXML
//    private void onEditPosition(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) employee_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        for (PositionType p : PositionType.values()) {
//            if (newValue.equals(p.getPositionRU())) {
//                account.getData().getPosition().setName(p.getPositionRU());
//                sendEditedData(account);
//                break;
//            } else {
//                warning_account_label.setText(EDITING_DATA_FAILURE);
//                warning_account_label.setVisible(true);
//            }
//        }
//    }
//
//    @FXML
//    private void onEditSalary(TableColumn.CellEditEvent<Account, BigDecimal> accountBigDecimalCellEditEvent) {
//        Account account = (Account) employee_table.getSelectionModel().getSelectedItem();
//        BigDecimal newValue = accountBigDecimalCellEditEvent.getNewValue();
//
//        account.getData().getPosition().setSalary(newValue);
//        sendEditedData(account);
//    }
//
//    private boolean sendEditedData(Account account) {
//        try {
//            Phone.sendOrGetData(Commands.USER_ADD_OR_UPDATE, account);
//            updateAccountTable();
//            warning_account_label.setText(EDITING_DATA_SUCCESS);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            warning_account_label.setText(EDITING_DATA_FAILURE);
//            log.error(e);
//            e.printStackTrace();
//            return false;
//        }
//        warning_account_label.setVisible(true);
//        return true;
//    }
//
//    @FXML
//    private void onStartData(TableColumn.CellEditEvent<Account, Date> accountDateCellEditEvent) {
//        try {
//            Account account = (Account) employee_table.getSelectionModel().getSelectedItem();
//            String oldDate = String.valueOf(accountDateCellEditEvent.getNewValue());
//            Date newDateString = DateHandler.convertDateFormatInSqlDate(oldDate);
//
//            account.getData().setEmplStartDate(newDateString);
//            sendEditedData(account);
//        } catch (IllegalArgumentException | ParseException e) {
//            warning_account_label.setText(INCORRECT_DATE_FORMAT_MSG);
//            warning_account_label.setVisible(true);
//        }
//    }
//
//    public void onEndData(TableColumn.CellEditEvent<Account, Date> accountDateCellEditEvent) {
//        try {
//            Account account = (Account) employee_table.getSelectionModel().getSelectedItem();
//            String oldDate = String.valueOf(accountDateCellEditEvent.getNewValue());
//            Date newDateString = DateHandler.convertDateFormatInSqlDate(oldDate);
//
//            if (account.getData().getEmplStartDate().after(newDateString))
//                throw new IllegalArgumentException();
//
//            account.getData().setEmplEndDate(newDateString);
//            sendEditedData(account);
//        } catch (ParseException e) {
//            warning_account_label.setText(INCORRECT_DATE_FORMAT_MSG);
//        } catch (IllegalArgumentException e) {
//            warning_account_label.setText(INCORRECT_DATE_CHRONOLOGY_MSG);
//            updateAccountTable();
//        }
//        warning_account_label.setVisible(true);
//
//    }
//
//    @FXML
//    private void onMouseClickSaveMarks(MouseEvent event) {
//        try {
//            Phone.sendOrGetData(Commands.SAVE_PRODUCT_DATA_LOCAL_STORAGE, new Product());
//            warning_marks_label.setText(CREATED_RESTORE_POINT_MSG);
//            back_button.setDisable(false);
//            warning_marks_label.setVisible(true);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void onMouseClickBackMarks(MouseEvent event) {
//        try {
//            if (back_button.isDisable())
//                throw new GettingDataException();
//
//            Phone.sendOrGetData(Commands.RESTORE_PRODUCT_DATA_LOCAL_STORAGE, new Product());
//            updateMarkTable();
//            warning_marks_label.setText(LAST_RESTORE_POINT_MSG);
//            warning_marks_label.setVisible(true);
//        } catch (GettingDataException e) {
//            warning_account_label.setText("Сначала необходимо создать точку восстановления.");
//        } catch (IOException | ClassNotFoundException e) {
//            log.error(e);
//        }
//    }
//
//    public void onEditDesign(TableColumn.CellEditEvent<Mark, BigDecimal> markBigDecimalCellEditEvent) {
//        Mark mark = (Mark) marks_table.getSelectionModel().getSelectedItem();
//        BigDecimal newValue = markBigDecimalCellEditEvent.getNewValue();
//
//        if (!checkRateRage(newValue))
//            return;
//
//        mark.setDesign(newValue);
//        sendEditedData(mark);
//    }
//
//    public void onEditPackage(TableColumn.CellEditEvent<Mark, BigDecimal> markBigDecimalCellEditEvent) {
//        Mark mark = (Mark) marks_table.getSelectionModel().getSelectedItem();
//        BigDecimal newValue = markBigDecimalCellEditEvent.getNewValue();
//
//        if (!checkRateRage(newValue))
//            return;
//
//        mark.setPackageValue(newValue);
//        sendEditedData(mark);
//    }
//
//    public void onEditPrice(TableColumn.CellEditEvent<Mark, BigDecimal> markBigDecimalCellEditEvent) {
//        Mark mark = (Mark) marks_table.getSelectionModel().getSelectedItem();
//        BigDecimal newValue = markBigDecimalCellEditEvent.getNewValue();
//
//        if (!checkRateRage(newValue))
//            return;
//
//        mark.setPrice(newValue);
//        sendEditedData(mark);
//    }
//
//    public void onEditService(TableColumn.CellEditEvent<Mark, BigDecimal> markBigDecimalCellEditEvent) {
//        Mark mark = (Mark) marks_table.getSelectionModel().getSelectedItem();
//        BigDecimal newValue = markBigDecimalCellEditEvent.getNewValue();
//
//        if (!checkRateRage(newValue))
//            return;
//
//        mark.setService(newValue);
//        sendEditedData(mark);
//    }
//
//    public void onEditRepair(TableColumn.CellEditEvent<Mark, BigDecimal> markBigDecimalCellEditEvent) {
//        Mark mark = (Mark) marks_table.getSelectionModel().getSelectedItem();
//        BigDecimal newValue = markBigDecimalCellEditEvent.getNewValue();
//
//        if (!checkRateRage(newValue))
//            return;
//
//        mark.setRepair(newValue);
//        sendEditedData(mark);
//    }
//
//    private boolean checkRateRage(BigDecimal rate) {
//        double r = Double.parseDouble(String.valueOf(rate));
//        if (r > 0.1 && r <= 5.0)
//            return true;
//
//        updateMarkTable();
//        warning_marks_label.setText("Рейтинг от 0.1 до 5.0");
//        warning_marks_label.setVisible(true);
//        return false;
//
//    }
//
//    boolean sendEditedData(Mark mark) {
//        try {
//            Phone.sendOrGetData(Commands.ADD_OR_UPDATE_MARK, mark);
//            updateMarkTable();
//            warning_marks_label.setText(EDITING_DATA_SUCCESS);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            warning_marks_label.setText(EDITING_DATA_FAILURE);
//            log.error(e);
//            e.printStackTrace();
//            return false;
//        }
//        warning_marks_label.setVisible(true);
//        return true;
//    }
//}
