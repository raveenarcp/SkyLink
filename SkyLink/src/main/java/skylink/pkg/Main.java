package skylink.pkg;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import skylink.pkg.File.ReadExternalConfig;
import skylink.pkg.File.Reader;
import skylink.pkg.File.Writer;
import skylink.pkg.User.HomePageController;
public class Main extends Application {
    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new Reader();
        reader.readAllFiles();
        ReadExternalConfig externalConfig = new ReadExternalConfig();
        launch(args);
        Writer writer = new Writer();
        writer.writeToAllFiles();
    }
    public void start(Stage stage) throws IOException {
        HomePageController.homePageScene(stage);
    }
}