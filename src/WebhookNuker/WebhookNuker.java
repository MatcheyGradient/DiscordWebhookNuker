package WebhookNuker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class WebhookNuker extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("nuker.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Discord Webhook Nuker");
        primaryStage.setScene(new Scene(root, 467, 243));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
