/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Componente;
import view.VistaComponenteController;
import view.VistaDetalleController;

/**
 *
 * @author dam
 */
public class GestorInventario extends Application {

    private ObservableList datosComponente = FXCollections.observableArrayList();
    private Stage escenarioPrincipal;
    private BorderPane layoutPrincipal;
    private AnchorPane vistaInventario;
    private AnchorPane vistaDetalle;

    public GestorInventario() {

         //datosComponente.add(new Componente(new ImageView("file:/img/gtx1080.jpg"), "Tarjeta grafica","500","20"));
          datosComponente.add(new Componente("Foto1", "Caja", "50", "50"));
          datosComponente.add(new Componente("Foto2", "Placa base", "150", "75"));
          datosComponente.add(new Componente("Foto3", "Memoria ram", "100", "60"));
          datosComponente.add(new Componente("Foto4", "Disco duro", "50", "150"));
          datosComponente.add(new Componente("Foto5", "Tarjeta grafica", "200", "250"));
        

    }

    public ObservableList getDatosComponente() {
        return datosComponente;
    }

    @Override
    public void start(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
        //pongo el titulo
        this.escenarioPrincipal.setTitle("Gestor Inventario");
        //inicializa el layout principal 
        initLayoutPrincipal();
        //muestra la vista persona
        muestraInventario();
    }

    public void initLayoutPrincipal() {
        //cargar el layout principal mediante la vista principal 
        FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("../view/VistaPrincipal.fxml");
        loader.setLocation(location);
        try {
            layoutPrincipal = loader.load();
        } catch (IOException ex) {

        }

        Scene escena = new Scene(layoutPrincipal);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    public void muestraInventario() {
        FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("../view/VistaInventario.fxml");
        loader.setLocation(location);
        try {
            vistaInventario = loader.load();
        } catch (IOException ex) {

        }
        //añado a centro la vista persona
        layoutPrincipal.setCenter(vistaInventario);

        VistaComponenteController controller = loader.getController();
        controller.setGestorInventario(this);

    }
    
     public void muestraDetalle(Componente componente) {
        FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("../view/VistaDetalle.fxml");
        loader.setLocation(location);
        try {
            vistaDetalle = loader.load();
        } catch (IOException ex) {

        }
        Stage escenarioDetalle = new Stage();
        escenarioDetalle.setTitle("Detalles");
        escenarioDetalle.initModality(Modality.WINDOW_MODAL);
        escenarioDetalle.initOwner(escenarioPrincipal);
        Scene escena = new Scene(vistaDetalle);
        escenarioDetalle.setScene(escena);
        

        VistaDetalleController controller = loader.getController();
        controller.setEscenarioDetalle(escenarioDetalle);
        controller.setComponente(componente);
        escenarioDetalle.showAndWait();

    }
    
    

    public Stage getPrimaryStage() {
        return escenarioPrincipal;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
