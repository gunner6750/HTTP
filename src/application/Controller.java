package Application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class Controller implements Initializable{

	@FXML
	private WebView webView;
	@FXML
	private TextField textField;
	
	private WebEngine engine;
	private WebHistory history;
	private String homePage;
	private double webZoom;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		engine = webView.getEngine();
		homePage = "www.google.com";
		textField.setText(homePage);
		webZoom = 1;
		loadPage();
	}
	@FXML
	public void loadPage() {
		
		//engine.load("http://www.google.com");
		engine.load("http://"+textField.getText());
	}
	@FXML
	public void refreshPage() {
		
		engine.reload();
	}
	@FXML
	public void zoomIn() {
		
		webZoom+=0.25;
		webView.setZoom(webZoom);
	}
	@FXML
	public void zoomOut() {
		
		webZoom-=0.25;
		webView.setZoom(webZoom);
	}
	@FXML
	public void displayHistory() {
		
		history = engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		
		for(WebHistory.Entry entry : entries) {
			
			//System.out.println(entry);
			System.out.println(entry.getUrl()+" "+entry.getLastVisitedDate());
		}
	}
	@FXML
	public void back() {
		
		history = engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		history.go(-1);
		
		textField.setText(entries.get(history.getCurrentIndex()).getUrl());
	}
	@FXML
	public void forward() {
		
		history = engine.getHistory();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		history.go(1);
		
		textField.setText(entries.get(history.getCurrentIndex()).getUrl());
	}
}