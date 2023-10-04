package de.tum.in.ase.eist;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.logging.*;

import static java.util.logging.LogManager.*;

public class UniversityApp extends Application {

	// Initialize the Logger
	private static final Logger logger = LogManager.getLogger(UniversityApp.class);

	private static final String TITLE = "University App";
	private static final int SCENE_WIDTH = 300;
	private static final int SCENE_HEIGHT = 250;
  	// TODO 4.1: Initialize the Logger

	public static void startApp(String[] args) {
		// Set the root log level to INFO
		Configurator.setRootLevel(Level.INFO);

		// Log the start of the app at the info level
		logger.info("Starting the UniversityApp...");

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane, SCENE_WIDTH, SCENE_HEIGHT);

		Button button = new Button();
		button.setText(getButtonText());
		button.setOnAction(event -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(TITLE);
			alert.setContentText(button.getText());
			alert.showAndWait();
		});

		stackPane.getChildren().add(button);

		primaryStage.setTitle(TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public String getButtonText() {
		return "EIST";
	}
}
