/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorInventario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Componente;
import util.Fechas;



/**
 *
 * @author milopez
 */
public class VistaDetalleController {

    @FXML
    public Label nombreLabel;
    @FXML
    private Label precioLabel;
    @FXML
    private Label stockLabel;
    @FXML
    private ImageView foto;
    @FXML
    private Label fechaModificacionLabel;
    @FXML
    private Label fechaAltaLabel;
    @FXML
    private TextArea descripcionLabel;

    private GestorInventario gestorInventario;
    private Componente componente;
    private VistaComponenteController datos;
    private Stage escenarioDetalle;
    private TableView tablaComponente;

   
     public VistaDetalleController() {
  //   this.componente = componente;
//     nombre= componente.getNombre();
      
    }
    @FXML
    public void initialize(){
//        nombreLabel.setText(datos.getNombre(componente));
//        precioLabel.setText(componente.getPrecio());
//        stockLabel.setText(componente.getStock());
//        gestorInventario.muestraDetalle();
    }
    
     public void setGestorInventario(GestorInventario gestorInventario) {

        this.gestorInventario = gestorInventario;
    }
  
    public void setEscenarioDetalle(Stage escenarioDetalle){
        this.escenarioDetalle = escenarioDetalle;
    }
    
    public void setComponente(Componente componente){
        this.componente = componente;
        
        foto.setImage(new Image(componente.getRuta()));
        nombreLabel.setText(componente.getNombre());
        precioLabel.setText(componente.getPrecio());
        stockLabel.setText(componente.getStock());
        fechaAltaLabel.setText(Fechas.formato(componente.getFechaAlta()));
        fechaModificacionLabel.setText(Fechas.formato(componente.getFechaMod()));
         descripcionLabel.setText(componente.getDescripcion());
    }
    
    @FXML
    public void borrar(){

        escenarioDetalle.close();
    }
    
    @FXML
    public void volver(){
        escenarioDetalle.close();
    }

}
