package by.bsiur.app.services.reportFactory;

import by.bsiur.app.exception.GettingDataException;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface Report {
    void createReport() throws IOException, GettingDataException, ClassNotFoundException, DocumentException;

}
