/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Producto;
import model.TipoProducto;

/**
 * FXML Controller class
 *
 * @author Juan
 */
public class VistaProductoController implements Initializable {

    /**
     * Atributos de interfaz
     */
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtValorUnitario;
    @FXML
    private TextField txtCantExistencia;
    @FXML
    private TableColumn colCodigo;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colCantExistencia;
    @FXML
    private TableColumn colValUnitario;
    @FXML
    private TableColumn colDescripcion;
    @FXML
    private TableView<Producto> tblProductos;
   
    private ObservableList<Producto>listaProductos;
    
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private ComboBox<TipoProducto> comboTipoProducto;
    @FXML
    private TableColumn colTipoProducto;

    /**
     * Asociar atributos con la tabla
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaProductos = FXCollections.observableArrayList();
        this.colCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colCantExistencia.setCellValueFactory(new PropertyValueFactory("cantidadExistencia"));
        this.colValUnitario.setCellValueFactory(new PropertyValueFactory("valUnitario"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colTipoProducto.setCellValueFactory(new PropertyValueFactory("tipoProducto"));
        
        this.comboTipoProducto.setItems(FXCollections.observableArrayList(TipoProducto.ENVASADOS,TipoProducto.PERECEDROS,TipoProducto.REFRIGERADOS));
    }    

    /** 
     * Metodo seleccionar y mostrar informacion de campos de texto
     * @param event 
     */
    @FXML
    private void seleccionar(MouseEvent event) {
        Producto producto = this.tblProductos.getSelectionModel().getSelectedItem();
        if(producto != null){
            this.txtNombre.setText(producto.getNombre());
            this.txtCodigo.setText(producto.getCodigo()+"");
            this.txtCantExistencia.setText(producto.getCantidadExistencia()+"");
            this.txtValorUnitario.setText(producto.getValUnitario()+ ""); 
            this.txtDescripcion.setText(producto.getDescripcion());
        }
    }
/**
 * metodo de Crear y Guardar Producto
 * @param event 
 */
    @FXML
    private void guardarProducto(ActionEvent event) {
        try{
            String nombre = this.txtNombre.getText();
            int codigo = Integer.parseInt(this.txtCodigo.getText());
            int cantidadExistencia = Integer.parseInt(this.txtCantExistencia.getText());
            int valUnitario = Integer.parseInt(this.txtValorUnitario.getText());
            String descripcion = this.txtDescripcion.getText();
            TipoProducto tipoProducto = this.comboTipoProducto.getValue();
            Producto producto = new Producto(nombre, descripcion, codigo, cantidadExistencia, valUnitario, tipoProducto);
           
            /**
             * validaciones
             */
            if(this.txtNombre.getText().isEmpty() && this.txtCodigo.getText().isEmpty()
                    && this.txtCantExistencia.getText().isEmpty() && this.txtDescripcion.getText().isEmpty()
                    && this.txtValorUnitario.getText().isEmpty() && this.comboTipoProducto.getValue() == null){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡Diligencie todos los campos!!");
                alerta.showAndWait();
            }else if(!listaProductos.contains(producto)){
                listaProductos.add(producto);
                tblProductos.setItems(listaProductos);
            }else{
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Usuario encontrado");
                alerta.setContentText("El usuario ya existe");
                alerta.showAndWait();
            }
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("¡¡Error!!");
            alerta.setContentText("¡¡Diligencie todos los campos correctamente!!");
            alerta.showAndWait();
        }
    }

    /**
     * metodo Actualizar producto
     * @param event 
     */
    @FXML
    private void actualizarProducto(ActionEvent event) {
        Producto producto = this.tblProductos.getSelectionModel().getSelectedItem();
        if(producto == null){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡debes seleccionar alguna persona!!");
                alerta.showAndWait();
       }else{
            
            try{
            String nombre = this.txtNombre.getText();
            int codigo = Integer.parseInt(this.txtCodigo.getText());
            int cantidadExistencia = Integer.parseInt(this.txtCantExistencia.getText());
            int valUnitario = Integer.parseInt(this.txtValorUnitario.getText());
            String descripcion = this.txtDescripcion.getText();
            TipoProducto tipoProducto = this.comboTipoProducto.getValue();
            
            Producto aux = new Producto(nombre, descripcion, codigo, cantidadExistencia, valUnitario, tipoProducto);
            

            /**
             * validaciones
             */
            if(!this.listaProductos.contains(aux)){
                producto.setNombre(aux.getNombre());
                producto.setCodigo(aux.getCodigo());
                producto.setCantidadExistencia(aux.getCantidadExistencia());
                producto.setValUnitario(aux.getValUnitario());
                producto.setDescripcion(aux.getDescripcion());
                producto.setTipoProducto(aux.getTipoProducto());
                this.tblProductos.refresh();
                
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR); 
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡La persona ya esxiste!!");
                alerta.showAndWait();
            }
        }catch(NumberFormatException e){
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡Ingrese un Valor correcto!!");
                alerta.showAndWait();
        }
            
        }
    }

    /**
     * metodo Eliminar Producto
     * @param event 
     */
    @FXML
    private void eliminarProducto(ActionEvent event) {
        
        Producto producto = this.tblProductos.getSelectionModel().getSelectedItem();
        if(producto == null){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("USUARIO SIN SELECCIONAR");
            alerta.setContentText("¡¡Debe de seleccionar algun usuario para eliminarlo!!");
            alerta.showAndWait();
        }else{
            this.listaProductos.remove(producto);
            this.tblProductos.refresh();
        }
    }
    
}
