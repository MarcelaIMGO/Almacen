/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Juan
 */
public class VistaClienteProductoController implements Initializable {

    /**
     * atributos de interfaz
     */
    @FXML
    private Button btnCliente;
    @FXML
    private Button btnProducto;
    @FXML
    private Button btnVentas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * mostrar ventana de CRUD cliente
     * @param event 
     */
    @FXML
    private void clickCliente(ActionEvent event) {
        try{
            Stage stage = new Stage();                                                 
            Parent root = FXMLLoader.load(getClass().getResource("/view/vistaCliente.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * mostrar CRUD producto
     * @param event 
     */
    @FXML
    private void clickProducto(ActionEvent event) {
        try{
            Stage stage = new Stage();                                                 
            Parent root = FXMLLoader.load(getClass().getResource("/view/VistaProducto.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * mostrar CRUD venta
     * @param event 
     */
    @FXML
    private void clickVentas(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/vistaVentas.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }

    
}
