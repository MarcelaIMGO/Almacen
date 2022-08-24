/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Venta;

/**
 * FXML Controller class
 *
 * @author Juan
 */
public class VistaVentasController implements Initializable {

    /**
     * atributos de interfaz
     */
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtDetalleVenta;
    @FXML
    private TextField txtComprador;
    @FXML
    private TextField txtTotal;
    @FXML
    private TextField txtIva;
    @FXML
    private TableView<Venta> tblVentas;
    
    private ObservableList<Venta> listaVentas;
    
    @FXML
    private TableColumn colCodigo;
    @FXML
    private TableColumn colFecha;
    @FXML
    private TableColumn colDetalleVenta;
    @FXML
    private TableColumn colDetalleComprador;
    @FXML
    private TableColumn colTotal;
    @FXML
    private TableColumn colIva;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnGuardar;

    /**
     * Asociar atributos con tabla
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaVentas = FXCollections.observableArrayList();
        
        this.colCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colDetalleVenta.setCellValueFactory(new PropertyValueFactory("detalleVenta"));
        this.colDetalleComprador.setCellValueFactory(new PropertyValueFactory("clienteComprador"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        this.colIva.setCellValueFactory(new PropertyValueFactory("iva"));
        
    }    

    /**
     * metodo Actualizar venta
     * @param event 
     */
    @FXML
    private void clickActualizar(ActionEvent event) {
        
        Venta venta = this.tblVentas.getSelectionModel().getSelectedItem();
        if(venta == null){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡debes seleccionar alguna persona!!");
                alerta.showAndWait();
       }else{
            
            /**
             * Validaciones
             */
            try{
            int codigo = Integer.parseInt(this.txtCodigo.getText());
            LocalDate fecha = LocalDate.now();
            String detalleVenta = this.txtDetalleVenta.getText();
            String comprador = this.txtComprador.getText();
            float total = Float.parseFloat(this.txtTotal.getText());
            float iva = Float.parseFloat(this.txtIva.getText());
            
            Venta aux = new Venta(codigo, fecha, detalleVenta, comprador, iva, total);

            if(!this.listaVentas.contains(aux)){
                venta.setCodigo(aux.getCodigo());
                venta.setFecha(aux.getFecha());
                venta.setDetalleVenta(aux.getClienteComprador());
                venta.setClienteComprador(aux.getClienteComprador());
                venta.setTotal(aux.getTotal());
                venta.setIva(aux.getIva());
                this.tblVentas.refresh();
                
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR); 
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡La persona ya esxiste!!");
                alerta.showAndWait();
            }
        }catch(NumberFormatException e){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡Ingrese un ID valido!!");
                alerta.showAndWait();
        }
            
        }
        
    }

    /**
     * metodo Eliminar
     * @param event 
     */
    @FXML
    private void clickEliminar(ActionEvent event) {
        
        Venta venta = this.tblVentas.getSelectionModel().getSelectedItem();
        if(venta == null){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("USUARIO SIN SELECCIONAR");
            alerta.setContentText("¡¡Debe de seleccionar algun usuario para eliminarlo!!");
            alerta.showAndWait();
        }else{
            this.listaVentas.remove(venta);
            this.tblVentas.refresh();
        }
    }

    /**
     * meotodo Crear y Guardar
     * @param event 
     */
    @FXML
    private void clickGuardar(ActionEvent event) {
        try{
            int codigo = Integer.parseInt(this.txtCodigo.getText());
            LocalDate fecha = LocalDate.now();
            String detalleVenta = this.txtDetalleVenta.getText();
            String comprador = this.txtComprador.getText();
            float total = Float.parseFloat(this.txtTotal.getText());
            float iva = Float.parseFloat(this.txtIva.getText());
            Venta venta = new Venta(codigo, fecha, detalleVenta, comprador, iva, total);
            
            /**
             * validaciones
             */
            if(this.txtCodigo.getText().isEmpty() && this.txtComprador.getText().isEmpty()
                    && this.txtDetalleVenta.getText().isEmpty() && this.txtIva.getText().isEmpty()
                    && this.txtIva.getText().isEmpty() && this.txtTotal.getText().isEmpty()){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡Diligencie todos los campos!!");
                alerta.showAndWait();
            }else if(!listaVentas.contains(venta)){
                listaVentas.add(venta);
                tblVentas.setItems(listaVentas);
            }else{
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Usuario encontrado");
                alerta.setContentText("El usuario ya existe");
                alerta.showAndWait();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("¡¡Error!!");
            alerta.setContentText("¡¡!!");
            alerta.showAndWait();
        }
        
    }

    /**
     * metodo Seleccionar y mostrar informacion en campos de texto
     * @param event 
     */
    @FXML
    private void seleccionar(MouseEvent event) {
                Venta venta = this.tblVentas.getSelectionModel().getSelectedItem();
        if(venta != null){
            this.txtCodigo.setText(venta.getCodigo()+"");
            this.txtComprador.setText(venta.getClienteComprador());
            this.txtDetalleVenta.setText(venta.getDetalleVenta());
            this.txtIva.setText(venta.getIva()+ ""); 
            this.txtTotal.setText(venta.getTotal()+"");
        
        }
    }
   
}
