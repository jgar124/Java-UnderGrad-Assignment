/**
 * Objective: Slider
 * Created by: Jason Garcia
 * Date: 4/14/2022
 * Version: 1
 */
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
public class SliderDemo extends Application {

	public void start(Stage primaryStage) {
		Text text = new Text(20, 20, "JavaFX Programming");
		
		Slider slHorizontal = new Slider();
		slHorizontal.setShowTickLabels(true);
		slHorizontal.setShowTickMarks(true);
		
		Slider slVertical = new Slider();
		slVertical.setOrientation(Orientation.VERTICAL);
		slVertical.setShowTickLabels(true);
		slVertical.setShowTickMarks(true);
		slVertical.setValue(100);
		
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(paneForText);
		pane.setBottom(slHorizontal);
		pane.setRight(slVertical);
		
		slHorizontal.valueProperty().addListener(ov -> {
			text.setX(slHorizontal.getValue() * paneForText.getWidth() / slHorizontal.getMax());
		});
		
		slVertical.valueProperty().addListener(ov -> {
			text.setY(slVertical.getMax() - (slVertical.getValue() * paneForText.getHeight() / slHorizontal.getMax()));
		});
		
		Scene scene = new Scene(pane, 450, 170);
		primaryStage.setTitle("Slider Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
		public static void Main(String[] args) {
			launch(args);
		}
	}
