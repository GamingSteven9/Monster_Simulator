package ch.makery.address.view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.Random;

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
	
	@FXML
	private Label userHealthLabel;
	
	@FXML
	private Label userMpLabel;
	
	@FXML
	private TextArea battleTextArea;
	
	private Monster monster;
	private boolean okClicked = false;

	private MainApp mainApp;
	
	private int userHealth = 20;
	private int tempHealth;
	
	private int userMP = 10;
	
	Random r = new Random();
	
	private int userDamage;
	private int MonsterDamage;
	
	private int criticalDamage;
	
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
    	userHealthLabel.setText(Integer.toString(userHealth));
    	tempHealth = monster.getHealth();
    	userMpLabel.setText(Integer.toString(userMP));
    }
    
    // The function for fighting the monster
    @FXML
    private void fightMonster(ActionEvent event) throws IOException {
    	
    	if (userHealth <= 0) {
    		
    		battleTextArea.clear();
    		battleTextArea.appendText("You Lose!\n");
    		
    		
    		
    	} else if (tempHealth <= 0) {
    		
    		battleTextArea.clear();
    		battleTextArea.appendText("You Win!\n"); 
    		

    	}
    	
    	if (tempHealth > 0 && userHealth > 0) {
    		
        		//Determines if the user missed thier attacks
    			userDamage = r.nextInt(11);
        		//battleTextArea.clear();
        		
        		if (userDamage == 0) {
        			
        			//User missed
        			
        			battleTextArea.clear();
        			
        			battleTextArea.appendText("You missed!\n");
        			
        		} else {
        			
        			// User hits and depletes health from the monster
        			criticalDamage = r.nextInt(26);
        			if (criticalDamage == 0) {
        				
        				battleTextArea.clear();
        				
        				tempHealth = tempHealth - 3;
        				battleTextArea.appendText("You got a critical hit!\n");
        				
        				if (tempHealth < 0) {
        					tempHealth = 0;
        				}
        				
        				monsterHealthLabel.setText(Integer.toString(tempHealth));
        				
        			} else {
        				
        				battleTextArea.clear();
        			
        				tempHealth--;
        				battleTextArea.appendText("You hit the monster!\n");
        				monsterHealthLabel.setText(Integer.toString(tempHealth));
        				
        			}
        		}
            	
            	// Determines if the user takes damage
        		MonsterDamage = r.nextInt(3);
            	if (MonsterDamage == 0) {
            		
            		criticalDamage = r.nextInt(26);
            		
            		if (criticalDamage == 0) {
            			
            			userHealth = userHealth - 3;
                		battleTextArea.appendText("The monster got a critical hit\n");
                		
                		if (userHealth < 0) {
        					userHealth = 0;
        				}
                		
                		userHealthLabel.setText(Integer.toString(userHealth));
            			
            		} else {
            		
            		// The monster hits the user
            		userHealth--;
            		battleTextArea.appendText("You took damage\n");
            		userHealthLabel.setText(Integer.toString(userHealth));
            		
            		}
            		
            	} else {
            		
            		// The monster misses
            		battleTextArea.appendText("The monster missed!\n");
            		
            	}
            	
            	//System.out.println(takeDamage);
            	
            	if (userHealth <= 0) {
            		
            		
            		battleTextArea.appendText("You Lose!\n");
            		
            		
            		
            	} else if (tempHealth <= 0) {
            		
            		
            		battleTextArea.appendText("You Win!\n"); 
            		

            	}
        	}
    	
    	//battleTextArea.clear();
    	
    	//System.out.println(tempHealth);
    }
    
    @FXML
    public void useMagic(ActionEvent event) throws IOException {
    	
    	if (userHealth <= 0) {
    		
    		battleTextArea.clear();
    		battleTextArea.appendText("You Lose!\n");
    		
    		
    		
    	} else if (tempHealth <= 0) {
    		
    		battleTextArea.clear();
    		battleTextArea.appendText("You Win!\n"); 
    		

    	}
    	
    	if (tempHealth > 0 && userHealth > 0) {
    		
    		if (userMP > 0) {
    			
    			battleTextArea.clear();
    			userMP = userMP - 5;
    			tempHealth = tempHealth - 3;
				if (tempHealth < 0) {
					tempHealth = 0;
				}
    			battleTextArea.appendText("You used a magical attack!\n");
    			userMpLabel.setText(Integer.toString(userMP));
    			monsterHealthLabel.setText(Integer.toString(tempHealth));
    			
    			// Determines if the user takes damage
        		MonsterDamage = r.nextInt(3);
        		
            	if (MonsterDamage == 0) {
            		
            		criticalDamage = r.nextInt(26);
            		
            		if (criticalDamage == 0) {
            			
            			userHealth = userHealth - 3;
                		battleTextArea.appendText("The monster got a critical hit\n");
                		
                		if (userHealth < 0) {
        					userHealth = 0;
        				}
                		
                		userHealthLabel.setText(Integer.toString(userHealth));
            			
            		} else {
            		
            		// The monster hits the user
            		userHealth--;
            		battleTextArea.appendText("You took damage\n");
            		userHealthLabel.setText(Integer.toString(userHealth));
            		
            		}
            		
            	} else {
            		
            		// The monster misses
            		battleTextArea.appendText("The monster missed!\n");
            		
            	}
    			
    		} else {
    			battleTextArea.clear();
    			battleTextArea.appendText("You're out of MP!\n");
    		}
    		
        	
        	
        	
        	//System.out.println(takeDamage);
        	
        	if (userHealth <= 0) {
        		
        		
        		battleTextArea.appendText("You Lose!\n");
        		
        		
        		
        	} else if (tempHealth <= 0) {
        		
        		
        		battleTextArea.appendText("You Win!\n"); 
        		

        	}
    	}
    	
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
