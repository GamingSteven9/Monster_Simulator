package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.control.ButtonBase;

import java.io.FileInputStream;
import java.io.IOException;

import ch.makery.address.MainApp;
import ch.makery.address.model.Monster;

public class DashboardOverviewController {
    @FXML
    private TableView<Monster> monsterTable; //The table that displays the monsters' info
    @FXML
    private TableColumn<Monster, String> nameColumn; //The column that displays the name of the monsters
    @FXML
    private TableColumn<Monster, Integer> levelColumn; //The column that displays the level of the monsters

    @FXML
    private Label nameLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label elementLabel;
    @FXML
    private Label healthLabel;
    
    @FXML
    private ImageView monsterPicture;
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public DashboardOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the monster table with the two columns.
    	nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    	levelColumn.setCellValueFactory(cellData -> cellData.getValue().levelProperty().asObject());
    	
    	 // Clear the monster details.
        showMonsterDetails(null);

        // Listen for selection changes and show the monster details when changed.
        monsterTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMonsterDetails(newValue));
    }
    
    /**
     * Fills all text fields to show details about the monster.
     * If the specified monster is null, all text fields are cleared.
     * 
     * @param the monster or null
     */
    private void showMonsterDetails(Monster monster) {
        if (monster != null) {
            // Fill the labels with info from the monster object.
            nameLabel.setText(monster.getName());
            levelLabel.setText(Integer.toString(monster.getLevel()));
            elementLabel.setText(monster.getElement());
            healthLabel.setText(Integer.toString(monster.getHealth()));
            
            // Fills the imageview with the monster's image
            monsterPicture.setImage((Image) monster.getImage());

        } else {
            // Monster is null, remove all the text.
            nameLabel.setText("");
            levelLabel.setText("");
            elementLabel.setText("");
            healthLabel.setText("");
            
            monsterPicture.setImage(null);
        }
    }
    
    @FXML
    private void handleMonsterFight(ActionEvent event) throws IOException {
    	Monster selectedMonster = monsterTable.getSelectionModel().getSelectedItem();
    	mainApp.showMonsterFight(selectedMonster);
    		
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        monsterTable.setItems(mainApp.getMonsterData());
    }
    
    
}