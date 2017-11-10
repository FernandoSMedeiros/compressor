/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressor;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import clases.Compressor;
import java.io.IOException;

/**
 *
 * @author Fernando
 */
public class FXMLDocumentController implements Initializable {
    
    private File imagem = null;
    
    @FXML
    private Button btnSelect;
    
    @FXML
    private Button btnComprimir;
    
    @FXML
    private void selecionar(ActionEvent event) {
           
        FileChooser fileChooser = new FileChooser();
                 
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.jpg, *.jpeg, *.png)", "*.jpg", "*.jpeg", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);
       
                Window primaryStage = null;
                 
                //Show save file dialog
                this.imagem = fileChooser.showOpenDialog(primaryStage);
                if(imagem != null){
                    //textArea.setText(readFile(file));
                }
        
    }
    
    @FXML
    private void comprimir() throws IOException{
    
        Compressor compressor = new Compressor(this.imagem);
        compressor.comprimir();
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
