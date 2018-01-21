/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorInventario;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        

    }

   

    //Es llamado por la apliación principal para tener una referencia de vuelta de si mismo
    public void setGestorInventario(GestorInventario gestorInventario) {

        this.gestorInventario = gestorInventario;

        //Añado la lista obervable a la tabla
        tablaComponente.setItems(gestorInventario.getDatosComponente());
    }

}
