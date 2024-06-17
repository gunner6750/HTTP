package Application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                webView.setOnMouseClicked(event -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    textField.setText(webView.getEngine().getLocation());
                    
                        });
		loadPage();
	}
        private String getUrl(){
            String url;
            		history = engine.getHistory();
                        
		ObservableList<WebHistory.Entry> entries = history.getEntries();
                url=entries.get(entries.size()-1).getUrl();
            return url;
        }
	@FXML
	public void loadPage() {
		
		String url=textField.getText();
                if(url.startsWith("http://") || url.startsWith("https://")){
                    engine.load(url);
                }
                else
		engine.load("http://"+url);
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