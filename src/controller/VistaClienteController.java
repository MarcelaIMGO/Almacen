/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import model.Cliente;
import model.TipoCliente;

/**
 * FXML Controller class
 *
 * @author Juan
 */
public class VistaClienteController implements Initializable {

    /**
     * Atributos de la interfaz
     */
    @FXML
    private TableView<Cliente> tblClientes;
    
    private ObservableList<Cliente> listaClientes;
    
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidos;
    @FXML
    private TableColumn colTelefono;
    @FXML
    private TableColumn colID;
    @FXML
    private TableColumn colDireccion;
    @FXML
    private TableColumn colTipoCliente;
    @FXML
    private TextField txtNombreCliente;
    @FXML
    private TextField txtTelefonoCliente;
    @FXML
    private TextField txtIdCliente;
    @FXML
    private TextField txtDireccionCliente;
    @FXML
    private TextField txtApellidosCliente;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;
    @FXML
    private ComboBox<TipoCliente> comboTipoCliente;
   
    

    /**
     * Asociar los atributos con sus columnas
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaClientes = FXCollections.observableArrayList();
        
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        this.colID.setCellValueFactory(new PropertyValueFactory("id"));
        this.colDireccion.setCellValueFactory(new PropertyValueFactory("direccion"));
        this.colTipoCliente.setCellValueFactory(new PropertyValueFactory("tipoCliente"));
        
        comboTipoCliente.setItems(FXCollections.observableArrayList(TipoCliente.NATURAL,TipoCliente.JURIDICA));
        
    }    

    /**
     * Metodo de Crear y Guardar Cliente
     * @param event 
     */
    @FXML
    private void guardar(ActionEvent event) {
        try{
            String nombre = this.txtNombreCliente.getText();
            String apellidos = this.txtApellidosCliente.getText();
            int telefono = Integer.parseInt(this.txtTelefonoCliente.getText());
            int id = Integer.parseInt(this.txtIdCliente.getText());
            String direccion = this.txtDireccionCliente.getText();
            TipoCliente tipoCliente = this.comboTipoCliente.getValue();
            Cliente cliente = new Cliente(nombre, apellidos, telefono, id, direccion, tipoCliente);
            
            /**
             * valida que un campo de texto no este vacio
             */
            if(this.txtNombreCliente.getText().isEmpty() && this.txtApellidosCliente.getText().isEmpty()
                    && this.txtTelefonoCliente.getText().isEmpty() && this.txtIdCliente.getText().isEmpty()
                    && this.txtDireccionCliente.getText().isEmpty() && this.comboTipoCliente.getValue() == null){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡Diligencie todos los campos!!");
                alerta.showAndWait();
            }else if(!listaClientes.contains(cliente)){
                listaClientes.add(cliente);
                tblClientes.setItems(listaClientes);
            }else{
                /**
                 * Valida que no hayan clientes repetidos
                 */
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Usuario encontrado");
                alerta.setContentText("El usuario ya existe");
                alerta.showAndWait();
            }
            /**
             * validad que los datos del campo de texto sean correctos
             */
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("¡¡Error!!");
            alerta.setContentText("¡¡Diligencie todos los campos correctamente!!");
            alerta.showAndWait();
        }
        
    }

    /**
     * Metodo Eliminar Cliente
     * @param event 
     */
    @FXML
    private void eliminar(ActionEvent event) {
        
        Cliente cliente = this.tblClientes.getSelectionModel().getSelectedItem();
        if(cliente == null){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("USUARIO SIN SELECCIONAR");
            alerta.setContentText("¡¡Debe de seleccionar algun usuario para eliminarlo!!");
            alerta.showAndWait();
        }else{
            this.listaClientes.remove(cliente);
            this.tblClientes.refresh();
        }
    }

    /**
     * Metodo Actualizar Cliente
     * @param event 
     */
    @FXML
    private void actualizar(ActionEvent event) {
        Cliente cliente = this.tblClientes.getSelectionModel().getSelectedItem();
        if(cliente == null){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("¡¡Error!!");
                alerta.setContentText("¡¡debes seleccionar alguna persona!!");
                alerta.showAndWait();
       }else{
            
            try{
            String nombre = this.txtNombreCliente.getText();
            String apellido = this.txtApellidosCliente.getText();
            int telefono = Integer.parseInt(this.txtTelefonoCliente.getText());
            int id = Integer.parseInt(this.txtIdCliente.getText());
            String direccion = this.txtDireccionCliente.getText();
            TipoCliente TipoCLiente = this.comboTipoCliente.getValue();
            
            Cliente aux = new Cliente(nombre, apellido, telefono, id, direccion, TipoCLiente);

            if(!this.listaClientes.contains(aux)){
                cliente.setNombre(aux.getNombre());
                cliente.setApellidos(aux.getApellidos());
                cliente.setTelefono(aux.getTelefono());
                cliente.setId(aux.getId());
                cliente.setDireccion(aux.getDireccion());
                cliente.setTipoCliente(aux.getTipoCliente());
                this.tblClientes.refresh();
        /**
         * validaciones
         */        
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
     * Metodo seleccionar en tabla y mostrar en campo de texto
     * @param event 
     */
    @FXML
    private void seleccionar(MouseEvent event) {
        Cliente cliente = this.tblClientes.getSelectionModel().getSelectedItem();
        if(cliente != null){
            this.txtNombreCliente.setText(cliente.getNombre());
            this.txtApellidosCliente.setText(cliente.getApellidos());
            this.txtTelefonoCliente.setText(cliente.getTelefono()+"");
            this.txtTelefonoCliente.setText(cliente.getId()+ ""); 
            this.txtDireccionCliente.setText(cliente.getDireccion());
            this.comboTipoCliente.setValue(cliente.getTipoCliente());
        }
    }
    
    
}
