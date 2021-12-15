package by.bsiur.app.services.reportFactory;


import by.bsiur.app.entity.*;

import by.bsiur.app.exception.GettingDataException;
import by.bsiur.app.util.Commands;
import by.bsiur.app.util.connection.Phone;
import by.bsiur.app.util.constants.LocalStorage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import static by.bsiur.app.util.constants.Constants.*;
public class ReportTXT implements Report{
    @Override
    public void createReport() throws IOException, GettingDataException, ClassNotFoundException {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        chooser.getExtensionFilters().add(extFilter);
        File file = chooser.showSaveDialog(new Stage());


        PrintWriter out = new PrintWriter(file);
        out.print("\t\t\t\t\t"+ REPORT_USER_DATA_MSG);
        out.print("\n\n");
        out.print("\t\t\t\t\t\t\t\t" + AUTHOR_MSG + LocalStorage.getAccount().getLogin() +"\n\n\n");

        List<User> users = (List<User>) Phone.sendOrGetData(Commands.GET_ALL_USERS, new User());

        for (int j = 0; j < users.size(); j++) {

            String login = users.get(j).getAccount().getLogin();
            String email = users.get(j).getAccount().getEmail();
            if (email == null)
                email = DATA_MISSED_MSG;
            String role = users.get(j).getAccount().getRole();
            PersonalData personalData = users.get(j).getPersonalData();

            String name = null;
            String surname = null;
            String thirdName = null;

            if (personalData != null) {
                name = personalData.getName();
                if (name == null)
                    name = DATA_MISSED_MSG;
                surname = personalData.getSurname();
                if (surname == null)
                    surname = DATA_MISSED_MSG;
                thirdName = personalData.getThirdName();
                if (thirdName == null)
                    thirdName = DATA_MISSED_MSG;


            }

           out.println(
                    "Name: " + name +
                            "\nSurname: " + surname +
                            "\nThird_Name: " + thirdName +
                            "\nMail: " + email +

                            "\n\n\n");
        }
        out.close();
    }
}
