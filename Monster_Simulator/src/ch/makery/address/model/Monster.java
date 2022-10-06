package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Monster {
	
	private final StringProperty name;
	private final IntegerProperty level;
	private final StringProperty element;
	private final ObjectProperty<Object> image;
	private final IntegerProperty health;
	
	public Monster() {
		this(null, 0, null, null, 0);
		
	}
	
	public Monster(String name, int level, String element, Image image, int health) {
		this.name = new SimpleStringProperty(name);
		this.level = new SimpleIntegerProperty(level);
		this.element = new SimpleStringProperty(element);
		this.image = new SimpleObjectProperty<Object>(image);
		this.health = new SimpleIntegerProperty(health);
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public int getLevel() {
		return level.get();
	}
	
	public void setLevel(int level) {
		this.level.set(level);
	}
	
	public IntegerProperty levelProperty() {
		return level;
	}
	
	public String getElement() {
		return element.get();
	}
	
	public void setElement(String element) {
		this.element.set(element);
	}
	
	public StringProperty elementProperty() {
		return element;
	}
	
	public Object getImage() {
		return image.get();
	}
	
	public void setImage(Object image) {
		this.image.set(image);
	}
	
	public ObjectProperty<Object> imageProperty() {
		return image;
	}
	
	public int getHealth() {
		return health.get();
	}
	
	public void setHealth(int health) {
		this.health.set(health);
	}
	
	public IntegerProperty healthProperty() {
		return health;
	}

}
