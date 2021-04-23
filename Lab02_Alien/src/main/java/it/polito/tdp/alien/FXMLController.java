package it.polito.tdp.alien;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField txtInput;
    
    @FXML
    private Label lblTesto;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtResult;
    
    AlienTranslator dictionary = new AlienTranslator();

    @FXML
    void doTranslate(ActionEvent event) {
    	String s = this.txtInput.getText().toLowerCase();
    	String[] campi = s.split(" ");
    	if(campi.length==2) {
    		if(!campi[0].matches("[a-zA-Z]*") || !campi[1].matches("[a-zA-Z]*")) {
    			this.txtResult.setText("Sono accettati solo caratteri alfabetici");
    			return;
    		}
    		this.dictionary.addWord(campi[0], campi[1]);
    	}
    	else {
    		if(!campi[0].matches("[a-zA-Z]*")) {
    			this.txtResult.setText("Sono accettati solo caratteri alfabetici");
    			return;
    		}
    		String result = this.dictionary.cercaParola(campi[0]);
    		this.txtResult.setText(result);
    	}
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	this.txtResult.clear();
    	this.dictionary.reset();
    }
    
    @FXML
    void initialize() {
    	assert lblTesto != null : "fx:id=\"lblTesto\" was not injected: check your FXML file 'Scene.fxml'.";
    	assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}