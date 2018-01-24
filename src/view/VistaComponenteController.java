/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorInventario;
import java.io.IOException;
import java.net.URL;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Componente;

/**
 *
 * @author dam
 */
public class VistaComponenteController {

    @FXML
    private TableView tablaComponente;
    @FXML
    private TableColumn fotoColumn;
    @FXML
    private TableColumn nombreColumn;
    @FXML
    private TableColumn precioColumn;
    @FXML
    private TableColumn stockColumn;
    
  

    // Referencia a la clase principal
    private GestorInventario gestorInventario;
    private Componente componente;
    private VistaDetalleController detalle;
    

    public VistaComponenteController() {

    }
     @FXML
    private void initialize() {
        
      
        //Inicializo la tabla con las 4 primeras columnas
//        String foto = "foto";
//        String nombre = "nombre";
//        String precio = "precio";
//        String stock = "stock";
        //fotoColumn.setCellValueFactory(c-> new SimpleObjectProperty<ImageView>(componente.getFoto()));
        //fotoColumn.setCellValueFactory(new PropertyValueFactory<Componente,ImageView>("foto"));
        fotoColumn.setCellValueFactory(new PropertyValueFactory<Componente,String>("foto"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Componente,String>("nombre"));
        precioColumn.setCellValueFactory(new PropertyValueFactory<Componente,String>("precio"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<Componente,String>("stock"));
         mostrarDetallesComponente(null);
        tablaComponente.getSelectionModel().selectedItemProperty().addListener(
         (observable, oldValue, newValue) -> mostrarDetallesComponente((Componente) newValue));
        

    }

   

    //Es llamado por la apliación principal para tener una referencia de vuelta de si mismo
    public void setGestorInventario(GestorInventario gestorInventario) {

        this.gestorInventario = gestorInventario;

        //Añado la lista obervable a la tabla
        tablaComponente.setItems(gestorInventario.getDatosComponente());
    }
    
    public String getNombre(Componente componente){
        return componente.getNombre();
    }
    @FXML
    private void mostrarDetallesComponente(Componente componente) {
        Componente seleccionado = (Componente) tablaComponente.getSelectionModel().getSelectedItem();
        if(seleccionado != null){
            
            System.out.println("componente seleccionado");
            System.out.println(componente.getFoto());
            System.out.println(getNombre(componente));
            System.out.println(componente.getPrecio());
            System.out.println(componente.getStock());
            gestorInventario.muestraDetalle(seleccionado);
            
  
        }
    }
    @FXML
    private void crearComponente(){
        Componente temporal = new Componente();
        gestorInventario.muestraNuevo(temporal);
        gestorInventario.getDatosComponente().add(temporal);
        
        
    }
    
    
    

}
