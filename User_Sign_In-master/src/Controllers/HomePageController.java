package Controllers;

import home.UserDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;




public class HomePageController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label invalid;




    public void openSignInPage() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("home/HomePage.fxml"));
        primaryStage.setTitle("Home page");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public void authenticate() throws Exception {
        for(int i = 0; i < UserDB.getUsers().size(); i++){
            if(username.getText().equals(UserDB.getUsers().get(i).getUsername()) && password.getText().equals(UserDB.getUsers().get(i).getPassword())) {
                System.out.println("exists");
                openSignedInPage();
            }
        }
    }
    public void openSignUpPage()throws Exception{
        Stage createSignUpPage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("home/SignUpPage.fxml"));
        createSignUpPage.setTitle("Sign Up");
        createSignUpPage.setScene(new Scene(root, 300,275));
        createSignUpPage.show();
    }

    public void openSignedInPage() throws Exception{
            Stage createSignedInPage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("home/SignedInPage.fxml"));
            createSignedInPage.setTitle("website");
            createSignedInPage.setScene(new Scene(root, 300, 275));
            createSignedInPage.show();
    }
}
