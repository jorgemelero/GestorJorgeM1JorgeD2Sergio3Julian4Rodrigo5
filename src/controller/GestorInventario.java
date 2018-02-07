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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Componente;
import view.VistaComponenteController;
import view.VistaDetalleController;
import view.VistaNuevoController;

/**
 *
 * @author dam
 */
public class GestorInventario extends Application {

    private ObservableList datosComponente = FXCollections.observableArrayList();
    private Stage escenarioPrincipal;
    private BorderPane layoutPrincipal;
    private AnchorPane vistaInventario;
    private AnchorPane vistaDetalle, vistaNuevo;

    public GestorInventario() {

          datosComponente.add(new Componente(new ImageView("/img/gtx1080.jpg"), "Nvidia gtx 1080","600","230", "/img/gtx1080.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/cascos.jpg"), "Cascos Razer Proaso 7.1","150","60", "/img/cascos.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/grafica2.png"), "Nvidia gtx 1050 ti","150","620", "/img/grafica2.png"));
          datosComponente.add(new Componente(new ImageView("/img/grafica3.png"), "Nvidia gtx 1060","360","120", "/img/grafica3.png"));
          datosComponente.add(new Componente(new ImageView("/img/grafica4.png"), "AMD Rx580","350","120", "/img/grafica4.png"));
          datosComponente.add(new Componente(new ImageView("/img/grafica5.png"), "Nvidia gtx 170 ti","450","17", "/img/grafica5.png"));
          datosComponente.add(new Componente(new ImageView("/img/placa1.png"), "Asus Z170","109","234", "/img/placa1.png"));
          datosComponente.add(new Componente(new ImageView("/img/placa2.png"), "Asus Z270","300","127", "/img/placa2.png"));
          datosComponente.add(new Componente(new ImageView("/img/placa3.png"), "MSI Gaming M5","185","257", "/img/placa3.png"));
          datosComponente.add(new Componente(new ImageView("/img/placa4.png"), "MSI Gaming M7","320","120", "/img/placa4.png"));
          datosComponente.add(new Componente(new ImageView("/img/placa5.png"), "Gigabyte Pro","170","220", "/img/placa5.png"));
          datosComponente.add(new Componente(new ImageView("/img/procesador1.png"), "Intel I5 6600K","169","320", "/img/procesador1.png"));
          datosComponente.add(new Componente(new ImageView("/img/procesador2.jpg"), "Intel I7 7700K","299","220", "/img/procesador2.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/procesador3.jpg"), "Intel I3 5400","120","120", "/img/procesador3.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/procesador4.jpg"), "AMD Ryzen 5","240","154", "/img/procesador4.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/procesador5.jpg"), "AMD Ryzen 7","390","120", "/img/procesador5.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/raton1.jpg"), "Logitech Pro 12000 dpi","69","620", "/img/raton1.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/raton2.jpg"), "Razer Chroma","87","520", "/img/raton2.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/teclado1.jpg"), "Asus K120","180","120", "/img/teclado1.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/teclado2.jpg"), "Tacens gaming plus","49","150", "/img/teclado2.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/torre1.jpg"), "Corsair G800","199","70", "/img/torre1.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/torre2.jpg"), "NZXT H700I Mate","199","80", "/img/torre2.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/torre3.jpg"), "Thermaltake View 71","199","90", "/img/torre3.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/torre4.jpg"), "Phanteks Enthoo EvolV","189","77", "/img/torre4.jpg"));
          datosComponente.add(new Componente(new ImageView("/img/torre5.jpg"), "Cooler Master MasterCase Pro 5","159","86", "/img/torre5.jpg"));
          
//          datosComponente.add(new Componente("Foto1", "Caja", "50", "50"));
//          datosComponente.add(new Componente("Foto2", "Placa base", "150", "75"));
//          datosComponente.add(new Componente("Foto3", "Memoria ram", "100", "60"));
//          datosComponente.add(new Componente("Foto4", "Disco duro", "50", "150"));
//          datosComponente.add(new Componente("Foto5", "Tarjeta grafica", "200", "250"));
        

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
     
    public boolean muestraNuevo(Componente componente){
         FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("../view/VistaNuevo.fxml");
        loader.setLocation(location);
          try {
            vistaNuevo = loader.load();
        } catch (IOException ex) {

        }
        Stage escenarioNuevo = new Stage();
        escenarioNuevo.setTitle("Nuevo");
        escenarioNuevo.initModality(Modality.WINDOW_MODAL);
        escenarioNuevo.initOwner(escenarioPrincipal);
        Scene escena = new Scene(vistaNuevo);
        escenarioNuevo.setScene(escena); 
        
        VistaNuevoController controller = loader.getController();
        controller.setEscenarioNuevo(escenarioNuevo);
        controller.setComponente(componente);
        //controller.isGuardarClicked();
        escenarioNuevo.showAndWait();
        
        return controller.isGuardarClicked();
    } 
     
    
    

    public Stage getPrimaryStage() {
        return escenarioPrincipal;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
