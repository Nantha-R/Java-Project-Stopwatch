import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void initializeGUI(Stage window)
    {
        Contents contents = new Contents(window);
        contents.initializeItems();
        contents.initializeScene();
        contents.initializeWindow();
    }

    @Override
    public void start(Stage window) throws Exception
    {
        initializeGUI(window);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
