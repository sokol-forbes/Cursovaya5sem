package by.bsiur.app.services.reportFactory;

import by.bsiur.app.entity.PersonalData;
import by.bsiur.app.entity.User;
import by.bsiur.app.exception.GettingDataException;
import by.bsiur.app.util.Commands;
import by.bsiur.app.util.connection.Phone;
import by.bsiur.app.util.constants.LocalStorage;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import static by.bsiur.app.util.constants.Constants.*;


@Log4j2
public class ReportPDF implements Report {
    @Override
    public void createReport() throws IOException, GettingDataException, ClassNotFoundException, DocumentException {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        chooser.getExtensionFilters().add(extFilter);
        File file = chooser.showSaveDialog(new Stage());

        List<User> users = (List<User>) Phone.sendOrGetData(Commands.GET_ALL_USERS, new User());
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));

        document.open();
        String author = LocalStorage.getAccount().getLogin();
        document.addAuthor(AUTHOR_MSG + author);
        document.addTitle(REPORT_TITLE_MSG);
        document.add(new Paragraph(REPORT_USER_DATA_MSG + "                                         " +
                "                             " +
                AUTHOR_MSG + author + "\n\n"));

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

            Paragraph p = new Paragraph(
                    "Name: " + name +
                            "\nSurname: " + surname +
                            "\nThird_Name: " + thirdName +
                            "\nMail: " + email +
                            "\n\n\n");
            document.add(p);
        }
        document.close();
    }
}
