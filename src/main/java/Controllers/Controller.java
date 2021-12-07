package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(event ->{
            System.out.println("Вы нажали на кнопку войти");
        });
        loginSignUpButton.setOnAction(event ->{
            System.out.println("Вы нажали на кнопку зарегистрироваться");
        });
    }

}

