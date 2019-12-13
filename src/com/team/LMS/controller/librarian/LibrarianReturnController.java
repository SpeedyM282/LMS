package com.team.LMS.controller.librarian;

import com.team.LMS.model.Book;
import com.team.LMS.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibrarianReturnController {
    @FXML private TextField returnIDTextField;
    @FXML private Button returnIDSearchBtn;
    @FXML private Label returnFirstNameText;
    @FXML private Label returnLastNameText;
    @FXML private Label returnDepartmentText;
    @FXML private Label returnDegreeText;
    @FXML private DatePicker returnDatePicker;
    @FXML private TextField returnISBNTextField;
    @FXML private Button returnISBNSearchBtn;
    @FXML private Label returnTitleText;
    @FXML private Label returnSubjectText;
    @FXML private Label returnStatusText;
    @FXML private Label returnAuthorText;
    @FXML private Label returnCopyrigthText;
    @FXML private Button returnBookSaveBtn;

    public void LReturnController() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/team/LMS/view/librarian/LibrarianReturnBook.fxml"));
        primaryStage.setTitle("Return book information");
        primaryStage.setScene(new Scene(root, 710, 550));
        primaryStage.show();
    }

    public void returnSearchStudentAction() throws SQLException {
        returnStudent(returnIDTextField, returnFirstNameText, returnLastNameText, returnDepartmentText, returnDegreeText, returnDatePicker);
    }

    static void returnStudent(TextField returnIDTextField, Label returnFirstNameText, Label returnLastNameText, Label returnDepartmentText, Label returnDegreeText, DatePicker returnDatePicker) throws SQLException {
        Student student=new Student();
        ArrayList<Student> students=student.getStudents();
        for(Student student_:students){
            if(student_.getUsername().equalsIgnoreCase(returnIDTextField.getText())){
                returnFirstNameText.setText(student_.getFirstName());
                returnLastNameText.setText(student_.getLastName());
                returnDepartmentText.setText("NULL");
                returnDegreeText.setText("NULL");
                returnDatePicker.setAccessibleText("UNKNOWN");
                break;
            }
            else{
                returnFirstNameText.setText(null);
                returnLastNameText.setText(null);
                returnDepartmentText.setText(null);
                returnDegreeText.setText(null);
                returnDatePicker.setAccessibleText(null);
            }
        }
    }

    public void returnSearchBookAction()throws SQLException{
        returnBook(returnISBNTextField, returnTitleText, returnAuthorText, returnCopyrigthText, returnStatusText, returnSubjectText);
    }

    static void returnBook(TextField returnISBNTextField, Label returnTitleText, Label returnAuthorText, Label returnCopyrigthText, Label returnStatusText, Label returnSubjectText) throws SQLException {
        Book book=new Book();
        ArrayList<Book> books=book.getBooks("default");
        for(Book book_:books){
            if(book_.getISBN()==Integer.parseInt(returnISBNTextField.getText())){
                returnTitleText.setText(book_.getTitle());
                returnAuthorText.setText(book_.getAuthor());
                returnCopyrigthText.setText("NULL");
                returnStatusText.setText(Integer.toString(book_.getReserved()));
                returnSubjectText.setText(book_.getSubject());
                break;
            }
            else{
                returnTitleText.setText(null);
                returnAuthorText.setText(null);
                returnCopyrigthText.setText(null);
                returnStatusText.setText(null);
                returnSubjectText.setAccessibleText(null);
            }
        }
    }
}
