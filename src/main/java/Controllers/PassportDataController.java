package Controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PassportDataController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField authority_field;

    @FXML
    private ComboBox<?> code_of_issuing_state_field;

    @FXML
    private DatePicker date_of_birth_field;

    @FXML
    private DatePicker date_of_expiry_field;

    @FXML
    private DatePicker date_of_issue_field;

    @FXML
    private ImageView home_redirect_button;

    @FXML
    private TextField identity_number_field;

    @FXML
    private Button addPassportDataButton;

    @FXML
    private TextField name_field;

    @FXML
    private TextField nationality_field;

    @FXML
    private TextField passport_number_field;

    @FXML
    private TextField patronymic_field;

    @FXML
    private TextField place_of_birth_field;

    @FXML
    private ComboBox<?> sex_field;

    @FXML
    private TextField surname_field;

    @FXML
    void initialize() {
        addPassportDataButton.setOnAction(event ->{
            System.out.println("Вы нажали на кнопку добавить паспортные данные");
        });
    }

}
