package by.bsiur.app.controllers;

import by.bsiur.app.services.GeneralFuncWindow;
import by.bsiur.app.util.connection.Phone;
import by.bsiur.app.util.constants.Constants;
import by.bsiur.app.util.constants.Paths;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import static by.bsiur.app.util.constants.Constants.CONNECTION_WAIT_TIME;
@Log4j2
public class LoadingController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ProgressIndicator progress_bar;

    @FXML
    private Label warning_label;

    @FXML
    private Label warning_label2;

    @FXML
    private Button deny_button;

    @FXML
    void initialize() {

        new SplashScreen().start();

        deny_button.setOnAction(actionEvent -> {
            System.exit(0);
        });

    }
    class SplashScreen extends Thread {
        public void run() {

            int attemptsCounter = 0;
            int CURRENT_PORT =  Constants.PORT;

            for (int i = 0; i < Constants.ATTEMPTS_COUNT; i++) {
                for (int j = 0; j < Constants.ATTEMPTS_COUNT; j++) {
                    try {
                        new Phone(new Socket(Constants.IP_ADDRESS, CURRENT_PORT));
                        i = Constants.ATTEMPTS_COUNT;
                        break;
                    } catch (IOException e) {
                        try {
                            Thread.sleep(CONNECTION_WAIT_TIME);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        log.error(e.getMessage() + " " + e);
                        //e.printStackTrace();
                    }
                }
                warning_label2.setVisible(true);
                deny_button.setVisible(true);
                //CURRENT_PORT++;
            }

            Platform.runLater(() -> {
                deny_button.getScene().getWindow().hide();
                GeneralFuncWindow.openNewScene(Paths.WindowSignIn);
//                GeneralFuncWindow.openNewScene(Paths.WindowManagement);
            });
        }
    }
}
