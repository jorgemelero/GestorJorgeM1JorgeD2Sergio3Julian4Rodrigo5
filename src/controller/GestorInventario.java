/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import modelo.Componente;
import modelo.Empaquetador;
import view.VistaComponenteController;
import view.VistaDetalleController;
import view.VistaEstadisticasController;
import view.VistaNuevoController;
import view.VistaPrincipalController;

/**
 *
 * @author dam
 */
public class GestorInventario extends Application {

    private ObservableList datosComponente = FXCollections.observableArrayList();
    private Stage escenarioPrincipal;
    private BorderPane layoutPrincipal;
    private AnchorPane vistaInventario;
    private AnchorPane vistaDetalle, vistaNuevo, editarComponente, vistaEstadisticas , vistaManual;

    public GestorInventario() {
        
        //datosComponente.add(new Componente("Nvidia gtx 1080", "600", "230", "/img/gtx1080.jpg", LocalDate.of(2018, 2, 18), LocalDate.of(2018, 2, 18), 123, "Producto 1"));
         datosComponente.add(new Componente(new ImageView("/img/gtx1080.jpg"), "Nvidia gtx 1080", "600", "230", "/img/gtx1080.jpg", LocalDate.of(2018, 2, 18), LocalDate.of(2018, 2, 18), 123, "Producto 1"));
         datosComponente.add(new Componente(new ImageView("/img/cascos.jpg"), "Cascos Razer Proaso 7.1", "150", "60", "/img/cascos.jpg", LocalDate.of(2018, 2, 18), LocalDate.of(2018, 2, 18), 123, "Producto 1"));
         datosComponente.add(new Componente(new ImageView("/img/grafica2.png"), "Nvidia gtx 1050 ti", "150", "620", "/img/grafica2.png", LocalDate.of(2018, 2, 18), LocalDate.of(2018, 2, 18), 123, "Producto 1"));
//          datosComponente.add(new Componente(new ImageView("/img/grafica3.png"), "Nvidia gtx 1060","360","120", "/img/grafica3.png"));
//          datosComponente.add(new Componente(new ImageView("/img/grafica4.png"), "AMD Rx580","350","120", "/img/grafica4.png"));
//          datosComponente.add(new Componente(new ImageView("/img/grafica5.png"), "Nvidia gtx 170 ti","450","17", "/img/grafica5.png"));
//          datosComponente.add(new Componente(new ImageView("/img/placa1.png"), "Asus Z170","109","234", "/img/placa1.png"));
//          datosComponente.add(new Componente(new ImageView("/img/placa2.png"), "Asus Z270","300","127", "/img/placa2.png"));
//          datosComponente.add(new Componente(new ImageView("/img/placa3.png"), "MSI Gaming M5","185","257", "/img/placa3.png"));
//          datosComponente.add(new Componente(new ImageView("/img/placa4.png"), "MSI Gaming M7","320","120", "/img/placa4.png"));
//          datosComponente.add(new Componente(new ImageView("/img/placa5.png"), "Gigabyte Pro","170","220", "/img/placa5.png"));
//          datosComponente.add(new Componente(new ImageView("/img/procesador1.png"), "Intel I5 6600K","169","320", "/img/procesador1.png"));
//          datosComponente.add(new Componente(new ImageView("/img/procesador2.jpg"), "Intel I7 7700K","299","220", "/img/procesador2.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/procesador3.jpg"), "Intel I3 5400","120","120", "/img/procesador3.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/procesador4.jpg"), "AMD Ryzen 5","240","154", "/img/procesador4.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/procesador5.jpg"), "AMD Ryzen 7","390","120", "/img/procesador5.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/raton1.jpg"), "Logitech Pro 12000 dpi","69","620", "/img/raton1.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/raton2.jpg"), "Razer Chroma","87","520", "/img/raton2.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/teclado1.jpg"), "Asus K120","180","120", "/img/teclado1.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/teclado2.jpg"), "Tacens gaming plus","49","150", "/img/teclado2.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/torre1.jpg"), "Corsair G800","199","70", "/img/torre1.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/torre2.jpg"), "NZXT H700I Mate","199","80", "/img/torre2.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/torre3.jpg"), "Thermaltake View 71","199","90", "/img/torre3.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/torre4.jpg"), "Phanteks Enthoo EvolV","189","77", "/img/torre4.jpg"));
//          datosComponente.add(new Componente(new ImageView("/img/torre5.jpg"), "Cooler Master MasterCase Pro 5","159","86", "/img/torre5.jpg"));

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
        URL location = GestorInventario.class.getResource("/view/VistaPrincipal.fxml");
        loader.setLocation(location);
        try {
            layoutPrincipal = loader.load();
        } catch (IOException ex) {

        }
        //Doy al controlador acceso a la aplicación principal
        VistaPrincipalController controller = loader.getController();
        controller.setGestorInventario(this);

        Scene escena = new Scene(layoutPrincipal);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();

        //Muestro la escena
        escenarioPrincipal.show();

        //Intento cargar el último archivo abierto
        File archivo = getRutaArchivoComponetes();
        if (archivo != null) {
            cargaComponentes(archivo);
        }
    }

    public void muestraInventario() {
        FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("/view/VistaInventario.fxml");
        loader.setLocation(location);
        try {
            vistaInventario = loader.load();
        } catch (IOException ex) {

        }
        //añado a centro la vista inventario
        layoutPrincipal.setCenter(vistaInventario);

        VistaComponenteController controller = loader.getController();
        controller.setGestorInventario(this);

    }

    public void muestraDetalle(Componente componente) {
        FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("/view/VistaDetalle.fxml");
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

    public boolean muestraNuevo(Componente componente) {
        FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("/view/VistaNuevo.fxml");
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

    //Vista editarComponente
    public boolean muestraEditarComponente(Componente componente) {

        //Cargo la vista nuevo a partir de VistaNuevo.fxml
        FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("/view/VistaNuevo.fxml");
        loader.setLocation(location);
        try {
            editarComponente = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(GestorInventario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
//        
        //Creo el escenario de edición (con modal) y establezco la escena
        Stage escenarioEdicion = new Stage();
        escenarioEdicion.setTitle("Editar Persona");
        escenarioEdicion.initModality(Modality.WINDOW_MODAL);
        escenarioEdicion.initOwner(escenarioPrincipal);
        Scene escena = new Scene(editarComponente);
        escenarioEdicion.setScene(escena);

        //Asigno el escenario de edición y el componente seleccionado al controlador
        VistaNuevoController controller = loader.getController();
        controller.setEscenarioNuevo(escenarioEdicion);
        controller.setComponente(componente);

        //Muestro el diálogo ahjsta que el ussuario lo cierre
        escenarioEdicion.showAndWait();

        //devuelvo el botón pulsado
        return controller.isGuardarClicked();

    }

    //Obtengo la ruta del archivo de la preferencias de usuario en Java
    public File getRutaArchivoComponetes() {

        Preferences prefs = Preferences.userNodeForPackage(GestorInventario.class);
        String rutaArchivo = prefs.get("rutaArchivo", null);
        System.out.println(rutaArchivo);
        if (rutaArchivo != null) {
            return new File(rutaArchivo);
        } else {
            return null;
        }
    }

    //Guardo la ruta del archivo en las preferencias de usuario en Java
    public void setRutaArchivoComponentes(File archivo) {

        Preferences prefs = Preferences.userNodeForPackage(GestorInventario.class);
        if (archivo != null) {
            //Añado la ruta a las preferencias
            prefs.put("rutaArchivo", archivo.getPath());
            //Actualizo el título del escenario a partir del archivo
            escenarioPrincipal.setTitle("Libreta de direcciones - " + archivo.getName());
        } else {
            //Elimino la ruta de las preferencias
            prefs.remove("rutaArchivo");
            //Actualizo el título del escenario quitando el nombre del archivo
            escenarioPrincipal.setTitle("Libreta de direcciones");
        }

    }

    //Cargo componentes de un fichero
    public void cargaComponentes(File archivo) {

        try {
            //Contexto
            JAXBContext context = JAXBContext.newInstance(Empaquetador.class);
            Unmarshaller um = context.createUnmarshaller();

            //Leo XML del archivo y hago unmarshall
            Empaquetador empaquetador = (Empaquetador) um.unmarshal(archivo);

            //Borro los anteriores
            datosComponente.clear();
            datosComponente.addAll(empaquetador.getComponentes());

            //Guardo la ruta del archivo al registro de preferencias
            setRutaArchivoComponentes(archivo);

        } catch (Exception e) {
            //Muestro alerta
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No se pueden cargar datos de la ruta " + archivo.getPath());
            alerta.setContentText(e.toString());
            alerta.showAndWait();

        }

    }

    //Guardo componentes en un fichero
    public void guardaComponentes(File archivo) {

        try {
            //Contexto
            JAXBContext context = JAXBContext.newInstance(Empaquetador.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Empaqueto los datos de los componentes
            Empaquetador empaquetador = new Empaquetador();
            empaquetador.setComponentes(datosComponente);

            //Marshall y guardo XML a archivo
            m.marshal(empaquetador, archivo);

            //Guardo la ruta delk archivo en el registro
            setRutaArchivoComponentes(archivo);

        } catch (Exception e) { // catches ANY exception
            //Muestro alerta
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No se puede guardar en el archivo " + archivo.getPath());
            alerta.setContentText(e.toString());
            alerta.showAndWait();
        }
    }
    

    public void crearGrafico() {

        //Cargo la vista estadísticas
        FXMLLoader loader = new FXMLLoader();
        URL location = GestorInventario.class.getResource("/view/VistaEstadistica.fxml");
        loader.setLocation(location);
        try {
            vistaEstadisticas = loader.load();

        } catch (IOException ex) {
            Logger.getLogger(GestorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Inicializo un nuevo escenario y asigno el principal
        Stage escenarioEstadisticas = new Stage();
        escenarioEstadisticas.setTitle("Estadísticas");
        escenarioEstadisticas.initModality(Modality.WINDOW_MODAL);
        escenarioEstadisticas.initOwner(escenarioPrincipal);

        //Cargo la escena que contiene ese layout de estadisticas
        Scene escena = new Scene(vistaEstadisticas);
        escenarioEstadisticas.setScene(escena);

        //Asigno el controlador
        VistaEstadisticasController controller = loader.getController();
        controller.setDatosComponente(datosComponente);

        //Muestro el escenario
        escenarioEstadisticas.show();

    }
    

    public Stage getPrimaryStage() {
        return escenarioPrincipal;
    }

    public static void main(String[] args) {
        launch(args);
    }

    

    

}
