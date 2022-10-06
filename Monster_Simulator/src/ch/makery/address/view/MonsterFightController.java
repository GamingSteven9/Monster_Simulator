package ch.makery.address.view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import ch.makery.address.MainApp;
import ch.makery.address.model.Monster;

public class MonsterFightController {
	
	@FXML
	private Label monsterNameLabel;
	
	@FXML
	private Label monsterHealthLabel;
	
	@FXML
    private ImageView monsterImage;
	
	private Monster monster;
	private boolean okClicked = false;

	private MainApp mainApp;
	
	private int tempHealth;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    }
    
    // Sets the details for the selected monster to fight
    public void setMonster(Monster monster) {
    	monsterNameLabel.setText(monster.getName());
    	monsterImage.setImage((Image) monster.getImage());
    	monsterHealthLabel.setText(Integer.toString(monster.getHealth()));
    	
    	tempHealth = monster.getHealth();
    }
    
    // The function for fighting the monster
    @FXML
    private void fightMonster(ActionEvent event) throws IOException {
    	
    	if (tempHealth <= 1) {
    		monsterHealthLabel.setText("You Win!");
    	} else {
    		tempHealth--;
        	monsterHealthLabel.setText(Integer.toString(tempHealth));
    	}
    	
    	//System.out.println(tempHealth);
    }
    
    
    
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
       
    }
    

}
