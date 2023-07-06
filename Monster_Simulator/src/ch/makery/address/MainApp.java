package ch.makery.address;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import ch.makery.address.model.Monster;
import ch.makery.address.view.DashboardOverviewController;
import ch.makery.address.view.MonsterFightController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Monster> monsterData = FXCollections.observableArrayList();
    
    public MainApp() throws IOException {
    	try {
		// Add monster data
    		String slimeDir = new java.io.File( "slimeMonster.png" ).getCanonicalPath();
    		String wolfDir = new java.io.File( "wolfMonster.png" ).getCanonicalPath();
    		
    		monsterData.add(new Monster("Slime", 1, "Water", new Image(new FileInputStream(slimeDir.replace("\\","\\\\"))), 5));
			monsterData.add(new Monster("Wolf", 5, "Earth", new Image(new FileInputStream(wolfDir.replace("\\","\\\\"))), 10 ));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public ObservableList<Monster> getMonsterData() {
		return monsterData;
	}

	/**
     * Initializes the primary stage
     */


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Monster_Simulator");

        initRootLayout();

        showMonsterOverview();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the monster overview inside the root layout.
     */
    public void showMonsterOverview() {
        try {
            // Load monster overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/DashboardOverview.fxml"));
            AnchorPane dashboardOverview = (AnchorPane) loader.load();
            
            // Set monster overview into the center of root layout.
            rootLayout.setCenter(dashboardOverview);
            
         // Give the controller access to the main app.
            DashboardOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Shows the MonsterFight Screen
    
    public void showMonsterFight(Monster monster) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/MonsterFight.fxml"));
    	
    	Stage stage = new Stage();
    	stage.setScene(new Scene(loader.load()));
    	
    	MonsterFightController controller = loader.getController();
    	controller.setMonster(monster);
    	
    	stage.show();
    	
    }
    
    
	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) {
        launch(args);
    }
}
