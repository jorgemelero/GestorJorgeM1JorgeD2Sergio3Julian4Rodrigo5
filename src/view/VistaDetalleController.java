/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorInventario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Componente;

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
    private Label descripcionLabel;

    private GestorInventario gestorInventario;
    private Componente componente;
    private VistaComponenteController datos;
    private Stage escenarioDetalle;

   
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
  
    public void setEscenarioDetalle(Stage escenarioDetalle){
        this.escenarioDetalle = escenarioDetalle;
    }
    
    public void setComponente(Componente componente){
        this.componente = componente;
        
        foto.setImage(new Image("/img/gtx1080.jpg"));
        nombreLabel.setText(componente.getNombre());
        precioLabel.setText(componente.getPrecio());
        stockLabel.setText(componente.getStock());
        
//        fechaModificacionLabel.setText(componente.getNombre());
//        fechaAltaLabel.setText(componente.getNombre());
//        descripcionLabel.setText(componente.getNombre());
    }
    
    @FXML
    public void borrar(){
        
    }
    
    @FXML
    public void volver(){
        escenarioDetalle.close();
    }

}
