import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    public static void main(String[] args) {

        System.out.println("Launching Application");
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Application starts");

        // получаем переданные параметры
        App.Parameters params = getParameters();
        List<String> unnamedParams = getParameters().getUnnamed();
        int i =0;
        for(String param: unnamedParams){
            i++;
            System.out.printf("%d - %s \n", i, param);
        }

        stage.show();
    }
}