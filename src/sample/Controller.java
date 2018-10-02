package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    Stage tempStage = new Stage();

    @FXML
    TextField input_location;

    @FXML
    TextField output_location;

    @FXML
    void searchFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose file(s)");
        File file = fileChooser.showOpenDialog(tempStage);
        //Check if the user entered files
        if(file != null) {
            String filePath = file.getPath();
            input_location.setText(filePath);
        }
        else {
            input_location.setText("");
        }
    }

    @FXML
    void searchDir() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Extract to:");
        File directory = directoryChooser.showDialog(tempStage);
        //Check if the operation was canceled
        if(directory != null) {
            String dirPath = directory.getPath();
            output_location.setText(dirPath);
        }
        else {
            output_location.setText("");
        }

    }

    @FXML
    void compress() {
        System.out.println("Extracting '"+input_location.getText()+"' to '"+output_location.getText()+"'...");
    }

}
