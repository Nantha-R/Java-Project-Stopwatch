import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Contents {
    private Stage window;
    private Label hours,minutes,seconds;
    private TextField hoursField, minutesField, secondsField;
    private Button startButton,stopButton,resetButton;
    private Scene scene;
    public Actions actions;
    Contents(){}

    Contents(Stage window)
    {
        this.window = window;
    }

    public int getSeconds() {
        return Integer.parseInt(secondsField.getText());
    }

    public void setSeconds(int seconds) {
        this.secondsField.setText(String.valueOf(seconds));
    }

    public int getMinutes() {
        return Integer.parseInt(minutesField.getText());
    }

    public void setMinutes(int minutes) {
        this.minutesField.setText(String.valueOf(minutes));
    }

    public int getHours() {
        return Integer.parseInt(hoursField.getText());
    }

    public void setHours(int hours) {
        this.hoursField.setText(String.valueOf(hours));
    }

    public void initializeItems()
    {
        hours = new Label("HOURS");
        minutes = new Label("MINUTES");
        seconds = new Label("SECONDS");

        hoursField = new TextField("0");
        minutesField = new TextField("0");
        secondsField = new TextField("0");
        hoursField.setStyle("-fx-text-fill:red;-fx-font-size:50px");
        minutesField.setStyle("-fx-text-fill:red;-fx-font-size:50px");
        secondsField.setStyle("-fx-text-fill:red;-fx-font-size:50px");
        hoursField.setPrefSize(200,200);
        minutesField.setPrefSize(200,200);
        secondsField.setPrefSize(200,200);

        startButton = new Button("START");
        stopButton = new Button("STOP");
        resetButton = new Button("RESET");
    }

    public void initializeEvents()
    {
        actions = new Actions(this);

        startButton.setOnAction(e->{
            actions.startStopwatch();
        });

        stopButton.setOnAction(e->{
            actions.stopStopwatch();
        });

        resetButton.setOnAction(e->{
            actions.resetStopwatch();
        });
    }
    public void initializeScene()
    {
        GridPane.setConstraints(hours,0,1);
        GridPane.setConstraints(minutes,1,1);
        GridPane.setConstraints(seconds,2,1);
        GridPane.setConstraints(hoursField,0,2);
        GridPane.setConstraints(minutesField,1,2);
        GridPane.setConstraints(secondsField,2,2);
        GridPane.setConstraints(startButton,0,3);
        GridPane.setConstraints(stopButton,1,3);
        GridPane.setConstraints(resetButton,2,3);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setHalignment(hours,HPos.CENTER);
        gridPane.setHalignment(minutes,HPos.CENTER);
        gridPane.setHalignment(seconds,HPos.CENTER);
        gridPane.setHalignment(startButton,HPos.CENTER);
        gridPane.setHalignment(stopButton,HPos.CENTER);
        gridPane.setHalignment(resetButton,HPos.CENTER);

        gridPane.getChildren().addAll(hours,minutes,seconds,
                                      hoursField,minutesField,secondsField,
                                      startButton,stopButton,resetButton);

        scene = new Scene(gridPane,600,300);
    }

    public void initializeWindow()
    {
        window.setTitle("STOPWATCH");
        window.setScene(scene);
        window.setOnCloseRequest(e->
        {
            e.consume();
            terminateApplication();
        });
        window.show();
    }

    public void terminateApplication()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"DO U WANT TO CLOSE");
        alert.setTitle("CLOSE");
        alert.showAndWait().ifPresent(response->{
            if(response == ButtonType.OK)
                window.close();
        });
    }
}
