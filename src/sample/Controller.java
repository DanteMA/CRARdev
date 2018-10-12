package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class Controller {
    Stage tempStage = new Stage();


    void createFileField(ObservableList list, String text) {
        TextField temp = new TextField(text);
        main_grid.add(temp, 1, 0);
    }

    @FXML
    GridPane main_grid;

    @FXML
    HBox input_files;

    @FXML
    ListView input_location;

    @FXML
    TextField output_location;

    @FXML
    void searchFile() {
        input_location.setPlaceholder(new Text(""));
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose file(s)");
        List<File> files = fileChooser.showOpenMultipleDialog(tempStage);

        //Check if the user entered files
        if(files != null) {
            String[] filesPaths = new String[files.size()];
            //Insert file's paths
            for(int i = 0; i < files.size(); i++) {
                filesPaths[i] = files.get(i).getPath();
                ObservableList elements = input_location.getItems();
                elements.add(filesPaths[i]);

                //TODO: add dinamic list to show a list of the items
            }
        }
        else {
            input_location.setPlaceholder(new Text(""));
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
        System.out.println("Extracting '"+"' to '"+"'...");
    }

}
