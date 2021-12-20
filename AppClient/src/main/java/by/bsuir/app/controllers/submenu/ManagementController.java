//package by.bsuir.app.controllers.submenu;
//
//import by.bsuir.app.entity.*;
//import by.bsuir.app.entity.enums.Gender;
//import by.bsuir.app.entity.enums.Owner;
//import by.bsuir.app.entity.enums.ProductCategory;
//import by.bsuir.app.entity.enums.Role;
//import by.bsuir.app.exception.GettingDataException;
//import by.bsuir.app.services.Calculator;
//import by.bsuir.app.services.GeneralFuncWindow;
//import by.bsuir.app.util.Commands;
//import by.bsuir.app.util.connection.Phone;
//import by.bsuir.app.util.constants.Paths;
//import javafx.beans.property.SimpleBooleanProperty;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.CheckBoxTableCell;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.input.MouseEvent;
//import javafx.util.Callback;
//import javafx.util.converter.BigDecimalStringConverter;
//import javafx.util.converter.IntegerStringConverter;
//import lombok.extern.log4j.Log4j2;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static by.bsuir.app.util.constants.Constants.*;
//
//@Log4j2
//public class ManagementController {
//
//    @FXML
//    private TableView<Account> account_table;
//
//    @FXML
//    private TableColumn<?, Integer> id_column;
//
//    @FXML
//    private TableColumn<?, String> login_column;
//
//    @FXML
//    private TableColumn<?, String> mail_column;
//
//    @FXML
//    private TableColumn<Account, String> name_column;
//
//    @FXML
//    private TableColumn<Account, String> role_column;
//
//    @FXML
//    private TableColumn<Account, String> surname_column;
//
//    @FXML
//    private TableColumn<Account, String> thirdName_column;
//
//    @FXML
//    private TableColumn<Account, Integer> age_column;
//
//    @FXML
//    private TableColumn<Account, String> gender_column;
//
//    @FXML
//    private TableColumn<Account, String> position_column;
//
//    @FXML
//    private TableColumn<Account, String> phone;
//
//    @FXML
//    private TableColumn<Account, String> social;
//
//    @FXML
//    private TableColumn<Account, Date> start_column;
//
//    @FXML
//    private TableColumn<Account, Date> fire_column;
//
//    @FXML
//    private TableColumn<Account, Boolean> account_ban;
//
//    @FXML
//    private Button delete_account_button;
//
//    @FXML
//    private Label warning_account_label;
//
//    @FXML
//    private TableView<Product> product_table;
//
//    @FXML
//    private TableColumn<?, Long> id_column_product;
//
//    @FXML
//    private TableColumn<?, String> name_column_product;
//
//    @FXML
//    private TableColumn<?, String> category_column;
//
//    @FXML
//    private TableColumn<?, Integer> quantity_column;
//
//    @FXML
//    private TableColumn<Product, String> owner_column;
//
//    @FXML
//    private TableColumn<?, String> url_column;
//
//    @FXML
//    private Button back_button;
//
//    @FXML
//    private TableColumn<?, BigDecimal> price_column;
//
//    @FXML
//    private TableColumn<Product, String> rate_column;
//    @FXML
//    private Label product_warning_label;
//
//    @FXML
//    private TextField filterField;
//
//    @FXML
//    void handleClose(MouseEvent event) {
//        account_table.getScene().getWindow().hide();
//    }
//
//    private static List<Mark> marks;
//    private static List<Mark> marksWithFilter;
//
//    {
//        try {
//            marks = (List<Mark>) Phone.sendOrGetData(Commands.GET_ALL_MARKS, new Mark());
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void initialize() {
//
//        updateAccountTable();
//        bindDataInProductTable();
//        fillProductTableWithFilteredData();
//
//    }
//
//
//
//    void bindDataInAccountTable() {
//        id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
//        login_column.setCellValueFactory(new PropertyValueFactory<>("login"));
//        login_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        mail_column.setCellValueFactory(new PropertyValueFactory<>("email"));
//        mail_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        gender_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getGender());
//            }
//        });
//        gender_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        age_column.setCellValueFactory(new PropertyValueFactory<>("age"));
//        age_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, Integer>,
//                ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Account, Integer> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getAge());
//            }
//        });
//        age_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//
//        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//
//        start_column.setCellFactory(column -> {
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
//
//
//        start_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, Date>,
//                ObservableValue<Date>>() {
//            @Override
//            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Account, Date> param) {
//                PersonalData personalData = param.getValue().getData();
//                if (personalData.getEmplStartDate() != null)
//                    return new SimpleObjectProperty<>(personalData.getEmplStartDate());
//                else return null;
//            }
//        });
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
//
//        position_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                Position position = param.getValue().getData().getPosition();
//                if (position != null)
//                    return new SimpleObjectProperty<>(position.getName());
//                return null;
//            }
//        });
//        name_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getName());
//            }
//        });
//        name_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        surname_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getSurname());
//            }
//        });
//        surname_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        thirdName_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getThirdName());
//            }
//        });
//        thirdName_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        phone.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getPhone());
//            }
//        });
//        phone.setCellFactory(TextFieldTableCell.forTableColumn());
//        social.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Account, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getData().getSocial());
//            }
//        });
//        social.setCellFactory(TextFieldTableCell.forTableColumn());
//        role_column.setCellValueFactory(new PropertyValueFactory<>("role"));
//        role_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        account_ban.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().isBlocked()));
//        account_ban.setCellFactory(tc -> new CheckBoxTableCell<>());
//    }
//
//    void bindDataInProductTable() {
//        id_column_product.setCellValueFactory(new PropertyValueFactory<>("id"));
//        name_column_product.setCellValueFactory(new PropertyValueFactory<>("name"));
//        name_column_product.setCellFactory(TextFieldTableCell.forTableColumn());
//        category_column.setCellValueFactory(new PropertyValueFactory<>("category"));
//        category_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        quantity_column.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//        quantity_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        owner_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Product, String> param) {
//                return new SimpleObjectProperty<>(param.getValue().getOwner().getRus());
//            }
//        });
//        owner_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        url_column.setCellValueFactory(new PropertyValueFactory<>("photoURL"));
//        url_column.setCellFactory(TextFieldTableCell.forTableColumn());
//        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
//        price_column.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
//        rate_column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, String>,
//                ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Product, String> param) {
//                marksWithFilter = new ArrayList<>(marks);
//                List<Mark> productMarks =
//                        marksWithFilter.stream().filter(e-> e.getProduct_id() == param.getValue().getId()).collect(Collectors.toList());
//                double result = Calculator.getAverageMark(productMarks);
//                String resultString = String.format("%.2f", result);
//
//                return new SimpleObjectProperty<>(resultString);
//            }
//        });
//
//    }
//
//    void fillAccountTableWithFilteredData() {
//
//        try {
//            ObservableList<Account> ol_accounts = FXCollections.observableArrayList();
//
//            List<Account> accounts = (List<Account>) Phone.sendOrGetData(Commands.GET_ALL_USERS, new Product());
//            ol_accounts.addAll(accounts);
//
//            // Wrap the ObservableList in a FilteredList (initially display all data).
//            FilteredList<Account> filteredData = new FilteredList<>(ol_accounts, b -> true);
//
//            System.out.println(filteredData);
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
//                    } else if (e.getLogin().toLowerCase().contains(lowerCaseFilter)) {
//                        return true;
//                    } else if (e.getRole().contains(lowerCaseFilter)) {
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
//                            } else if (data.getGender() != null && data.getGender().toLowerCase().contains(
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
//            sortedData.comparatorProperty().bind(account_table.comparatorProperty());
//
//            // 5. Add sorted (and filtered) data to the table.
//            account_table.setItems(sortedData);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            e.printStackTrace();
//        }
//    }
//
//    void fillProductTableWithFilteredData() {
//        try {
//            ObservableList<Product> ol_products = FXCollections.observableArrayList();
//
//            List<Product> products = (List<Product>) Phone.sendOrGetData(Commands.GET_ALL_PRODUCTS, new Product());
//            ol_products.addAll(products);
//
//            // Wrap the ObservableList in a FilteredList (initially display all data).
//            FilteredList<Product> filteredData = new FilteredList<>(ol_products, b -> true);
//
//            // 2. Set the filter Predicate whenever the filter changes.
//            filterField.textProperty().addListener((observable, oldValue, newValue) -> {
//                filteredData.setPredicate(obj -> {
//                    // If filter text is empty, display all persons.
//
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//
//                    // Compare first name and last name of every person with filter text.
//                    String lowerCaseFilter = newValue.toLowerCase();
//
//                    if (obj.getName() != null && obj.getName().toLowerCase().contains(lowerCaseFilter)) {
//                        return true;
//                    } else if (obj.getCategory() != null && obj.getCategory().toLowerCase().contains(
//                            lowerCaseFilter)) {
//                        return true;
//                    } else if (obj.getOwner() != null && obj.getOwner().getRus().toLowerCase().contains(
//                            lowerCaseFilter)) {
//                        return true;
//                    } else if (obj.getPrice() != null && String.valueOf(obj.getPrice()).toLowerCase().contains(
//                            lowerCaseFilter)) {
//                        return true;
//                    } else if (obj.getQuantity() != 0 && String.valueOf(obj.getQuantity()).contains(lowerCaseFilter)) {
//                        return true;
//                    } else
//                        return false; // Does not match.
//                });
//            });
//
//            // 3. Wrap the FilteredList in a SortedList.
//            SortedList<Product> sortedData = new SortedList<>(filteredData);
//
//            // 4. Bind the SortedList comparator to the TableView comparator.
//            // 	  Otherwise, sorting the TableView would have no effect.
//            sortedData.comparatorProperty().bind(product_table.comparatorProperty());
//
//            // 5. Add sorted (and filtered) data to the table.
//            product_table.setItems(sortedData);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            e.printStackTrace();
//        }
//    }
//
//    void updateProductTable() {
//        bindDataInProductTable();
//        fillProductTableWithFilteredData();
//    }
//
//    void updateAccountTable() {
//        bindDataInAccountTable();
//        fillAccountTableWithFilteredData();
//    }
//
//    boolean sendEditedData(Account account) {
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
//    boolean sendEditedData(Product product) {
//        try {
//            Phone.sendOrGetData(Commands.ADD_OR_UPDATE_PRODUCT, product);
//            updateProductTable();
//            product_warning_label.setText(EDITING_DATA_SUCCESS);
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            product_warning_label.setText(EDITING_DATA_FAILURE);
//            log.error(e);
//            e.printStackTrace();
//            return false;
//        }
//        product_warning_label.setVisible(true);
//        return true;
//    }
//
//    @FXML
//    void onEditMail(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        account.setEmail(newValue);
//        sendEditedData(account);
//    }
//
//    @FXML
//    void onEditLogin(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        account.setLogin(newValue);
//        sendEditedData(account);
//    }
//
//
//
//    @FXML
//    void onMouseClickDeleteAccount(MouseEvent event) {
//        try {
//            Account account = (Account) account_table.getSelectionModel().getSelectedItem();
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
//    @FXML
//    void onMouseClickResetAccount(MouseEvent event) {
//        warning_account_label.setVisible(false);
//        updateAccountTable();
//    }
//
//    @FXML
//    void onMouseClickAddProduct(MouseEvent event) {
//        GeneralFuncWindow.openNewScene(Paths.WindowAddProduct);
//        fillProductTableWithFilteredData();
//    }
//
//    @FXML
//    void onMouseClickDeleteProduct(MouseEvent event) {
//        try {
//            Product product = (Product) product_table.getSelectionModel().getSelectedItem();
//            if (product == null) {
//                product_warning_label.setText(ERROR_SELECT_FIELD_MSG);
//            } else {
//                Phone.sendOrGetData(Commands.DELETE_PRODUCT_BY_ID, product.getId());
//                product_warning_label.setText(DELETE_SUCCESS_MSG);
//                fillProductTableWithFilteredData();
//            }
//        } catch (IOException | ClassNotFoundException | GettingDataException e) {
//            product_warning_label.setText(DELETE_FAIL_MSG);
//            log.error(e);
//            e.printStackTrace();
//        }
//        product_warning_label.setVisible(true);
//    }
//
//    @FXML
//    void onMouseClickResetProduct(MouseEvent event) {
//        product_warning_label.setVisible(false);
//        updateProductTable();
//    }
//
//    @FXML
//    void onEditAge(TableColumn.CellEditEvent<Account, Integer> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        int newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        account.getData().setAge(newValue);
//        sendEditedData(account);
//    }
//
//    @FXML
//    void onEditGender(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//        for (Gender p : Gender.values()) {
//            if (newValue.equals(p.getGender())) {
//                account.getData().setGender(p.getGender());
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
//    void onEditName(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        account.getData().setName(newValue);
//        sendEditedData(account);
//    }
//
//    @FXML
//    void onEditPhone(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        account.getData().setPhone(newValue);
//        sendEditedData(account);
//    }
//
//    @FXML
//    void onEditRole(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//        for (Role p : Role.values()) {
//            if (newValue.equals(p.toString())) {
//                account.setRole(p.toString());
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
//    void onEditSurname(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        account.getData().setSurname(newValue);
//        sendEditedData(account);
//    }
//
//    @FXML
//    void onEditThirdName(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent) {
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        account.getData().setThirdName(newValue);
//        sendEditedData(account);
//    }
//
//
//    @FXML
//    void onEditNameProduct(TableColumn.CellEditEvent<Product, String> editEvent) {
//        Product product = (Product) product_table.getSelectionModel().getSelectedItem();
//        String newValue = editEvent.getNewValue();
//
//        product.setName(newValue);
//        sendEditedData(product);
//    }
//
//    @FXML
//    void onEditQuantityProduct(TableColumn.CellEditEvent<Product, Integer> editEvent) {
//        Product product = (Product) product_table.getSelectionModel().getSelectedItem();
//        int newValue = editEvent.getNewValue();
//
//        product.setQuantity(newValue);
//        sendEditedData(product);
//    }
//
//    @FXML
//    void onEditCategory(TableColumn.CellEditEvent<Product, String> editEvent) {
//        Product product = (Product) product_table.getSelectionModel().getSelectedItem();
//        String newValue = editEvent.getNewValue();
//
//        for (ProductCategory p : ProductCategory.values()) {
//            if (newValue.equals(p.getRus())) {
//                product.setCategory(p.getRus());
//                sendEditedData(product);
//                break;
//            } else {
//                product_warning_label.setText(EDITING_DATA_FAILURE);
//                product_warning_label.setVisible(true);
//            }
//        }
//
//    }
//
//    @FXML
//    void onEditURL(TableColumn.CellEditEvent<Product, String> editEvent) {
//        Product product = (Product) product_table.getSelectionModel().getSelectedItem();
//        String newValue = editEvent.getNewValue();
//
//        product.setPhotoURL(newValue);
//        sendEditedData(product);
//    }
//
//    @FXML
//    void onEditPrice(TableColumn.CellEditEvent<Product, BigDecimal> editEvent) {
//        Product product = (Product) product_table.getSelectionModel().getSelectedItem();
//        BigDecimal newValue = editEvent.getNewValue();
//
//        product.setPrice(newValue);
//        sendEditedData(product);
//    }
//
//    @FXML
//    void onMouseClickBlockAccount(MouseEvent event) {
//        Account account = account_table.getSelectionModel().getSelectedItem();
//
//        account.setBlocked(!account.isBlocked());
//        sendEditedData(account);
//    }
//
//    @FXML
//    void onEditSocial(TableColumn.CellEditEvent<Account, String> employeesForTableStringCellEditEvent){
//        Account account = (Account) account_table.getSelectionModel().getSelectedItem();
//        String newValue = employeesForTableStringCellEditEvent.getNewValue();
//
//        account.getData().setSocial(newValue);
//        sendEditedData(account);
//    }
//
//    @FXML
//    void onEditQuantityOwner(TableColumn.CellEditEvent<Product, String> event) {
//        Product product = (Product) product_table.getSelectionModel().getSelectedItem();
//        String newValue = event.getNewValue();
//
//        for (Owner o: Owner.values())
//            if (o.getRus().equals(newValue)) {
//                product.setOwner(o);
//                break;
//            }
//        sendEditedData(product);
//    }
//}
//
//
