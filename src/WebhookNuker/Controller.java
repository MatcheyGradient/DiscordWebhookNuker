package WebhookNuker;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.ranktw.DiscordWebHooks.DiscordMessage;
import net.ranktw.DiscordWebHooks.DiscordWebhook;

import java.awt.event.ActionEvent;

public class Controller {
    @FXML
    private Button nukestart;
    @FXML
    private TextField url;
    @FXML
    private TextField msg;
    @FXML
    private TextField pfp;
    @FXML
    private TextField name;
    @FXML
    private FontAwesomeIcon close;
    @FXML
    private FontAwesomeIcon esc;

    double x, y;

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() -x);
        stage.setY(event.getScreenY() -y);
    }
    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void esc(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void nukestart(javafx.event.ActionEvent actionEvent) {
        String webhookurl = url.getText();
        String message = msg.getText();
        String hookname = name.getText();
        String profilelink = pfp.getText();
        String webhook = webhookurl;
        DiscordWebhook nuker = new DiscordWebhook(webhook);

        DiscordMessage dm = new DiscordMessage.Builder()
                .withUsername(hookname)
                .withContent(message)
                .withAvatarURL(profilelink)
                .build();
        while(true){
            nuker.sendMessage(dm);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
