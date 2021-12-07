package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignUpButton;

    @FXML
    private Button loginSignInButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private PasswordField password_repeat_field;

    @FXML
    void initialize() {
        loginSignInButton.setOnAction(event ->{
            System.out.println("Вы нажали на кнопку войти");
        });
        authSignUpButton.setOnAction(event ->{
            System.out.println("Вы нажали на кнопку зарегистрироваться");
        });

    }

}
