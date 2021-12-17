package by.bsiur.app.controllers;

import by.bsiur.app.animation.Shake;
import by.bsiur.app.entity.Account;
import by.bsiur.app.entity.PersonalData;
import by.bsiur.app.entity.User;
import by.bsiur.app.exception.EmptyFieldsException;
import by.bsiur.app.exception.GettingDataException;
import by.bsiur.app.util.Commands;
import by.bsiur.app.util.connection.Phone;
import by.bsiur.app.util.constants.Constants;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import lombok.extern.log4j.Log4j2;

import by.bsiur.app.entity.enums.Gerder;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static by.bsiur.app.util.constants.Constants.*;

@Log4j2
public class SingUpController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private PasswordField confirm_password_field;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField email_field;

    @FXML
    private Label warning_label;

    @FXML
    private Button returnButton;

    @FXML
    void handleClose(MouseEvent event) {
        registrationButton.getScene().getWindow().hide();
    }

    @FXML
    private RadioButton boxMale;

    @FXML
    private RadioButton boxFemale;

    @FXML
    void initialize() {

        registrationButton.setOnAction(actionEvent -> {
            singUpNewUser();
        });

        returnButton.setOnAction(actionEvent -> {
            returnButton.getScene().getWindow().hide();
        });
    }

    //TODO GENDER HANDLE
    private void singUpNewUser() {
        try {
            String login = login_field.getText();
            String password = password_field.getText();
            String confirmPassword = confirm_password_field.getText();
            String email = email_field.getText();
            Gerder gerder;


            if (login.equals("") || password.equals("") || confirmPassword.equals("") || email.equals(""))
                throw new EmptyFieldsException(Constants.FILL_FIELDS_MSG);

            if (boxMale.isSelected())
                gerder = Gerder.MALE;
            else if (boxFemale.isSelected())
                gerder = Gerder.FEMALE;
            else
                throw new EmptyFieldsException(Constants.FILL_FIELDS_MSG);

            if (login.length() < MIN_LOGIN_LENGTH)
                throw new IllegalArgumentException(MIN_LOGIN_LENGTH_MSG);
            if (password.length() < MIN_PASSWORD_LENGTH)
                throw new IllegalArgumentException(MIN_PASSWORD_LENGTH_MSG);
            if (!password.equals(confirmPassword))
                throw new IllegalArgumentException(PASSWORDS_NOT_MATCH);

            Account account = new Account(login, password, email);
//            PersonalData personalData = new PersonalData(name,surname,thirdname,gerder);
            User user = new User(account);
            user.getPersonalData().setGender(gerder.getGender());
//            account.getData().setGender(gender.getGender());

            boolean answer = (boolean) Phone.sendOrGetData(Commands.REGISTRATION, user);

            if (answer) {
                warning_label.setText(SUCCESSFUL_REG_MSG);
                registrationButton.getScene().getWindow().hide();
            } else throw new GettingDataException();
        } catch (EmptyFieldsException e) {
            warning_label.setText(e.getMessage());
            warning_label.setVisible(true);
            runAnimation();
        } catch (IllegalArgumentException e) {
            warning_label.setText(e.getMessage());
        } catch (IOException | ClassNotFoundException | GettingDataException e) {
            log.error(e.getMessage());
            warning_label.setText(LOGIN_IN_USE);
        }
        warning_label.setVisible(true);

    }

    private void runAnimation() {
        Shake loginAnim = new Shake(login_field);
        Shake passwordAnim = new Shake(password_field);
        Shake confirmPasswordAnim = new Shake(confirm_password_field);
        Shake emailAnim = new Shake(email_field);
        loginAnim.playAnim();
        passwordAnim.playAnim();
        confirmPasswordAnim.playAnim();
        emailAnim.playAnim();
    }
}
