package Controllers;

import home.User;

import home.UserDB;
import home.UserIO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;

public class CreateAccountController {
    @FXML
    PasswordField newPassword;
    @FXML
    PasswordField confirmPassword;
    @FXML
    TextField username;
    @FXML
    TextField email;
    @FXML
    Button browse;



    HomePageController hompage = new HomePageController();
    User newuser = new User();


    public boolean checkIfUserExists(String Username) {
        boolean exists = false;
        for(int i = 0; i < UserDB.getUsers().size(); i++) {
            if (Username.equals(UserDB.getUsers().get(i).getUsername())) {
                exists = true;
            }
        }return exists;
    }

    public void browseDir(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null){
            newuser.setPhoto(selectedFile);
        }else{
            System.out.println("none selected");
        }
    }

    public void createAccount() throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        String Username = username.getText();
        String password = newPassword.getText();
        String newEmail = email.getText();

        if(checkIfUserExists(Username)) {
            alert.setContentText("User already exists");
            alert.showAndWait();
        }
        else if (!password.matches(".*[a-z]+.*")) {
            alert.setContentText("must contain lower case letter");
            alert.showAndWait();
        }
        else if(!password.matches(".*[A-Z]+.*")) {
            alert.setContentText("Must contain capital letter");
            alert.showAndWait();
        }
        else if(!password.matches(".*[\\d]+.*")) {
            alert.setContentText("Must contain a digit letter");
            alert.showAndWait();
        }
        else if(!password.matches(".*[^\\w]+.*")) {
            alert.setContentText("Must contain a Special Charachter");
            alert.showAndWait();
        }
        else if (!password.equals(confirmPassword.getText())) {
            alert.setContentText("passwords don't match");
            alert.showAndWait();

        }else if(!newEmail.matches(".+[\\@].+[\\.].+")) {
            alert.setContentText("Wrong email format");
            alert.showAndWait();
        }else if(!password.equals(confirmPassword.getText())) {
            alert.setContentText("Passwords dont match");
            alert.showAndWait();

        }else{
            User newuser = new User(username.getText(), confirmPassword.getText(), email.getText());
            UserDB.getUsers().add(newuser);
            UserIO.writeUsers(UserDB.getUsers());
            for(int i=0; i<UserDB.getUsers().size(); i++){
                UserIO.readUsers(UserDB.getUsers());
            }
        hompage.openSignInPage();
        }
    }
}
