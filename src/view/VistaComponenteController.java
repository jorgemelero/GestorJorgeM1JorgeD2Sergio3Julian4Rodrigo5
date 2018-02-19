/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorInventario;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        fotoColumn.setCellValueFactory(new PropertyValueFactory<Componente, String>("foto"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Componente, String>("nombre"));
        precioColumn.setCellValueFactory(new PropertyValueFactory<Componente, String>("precio"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<Componente, String>("stock"));
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

    public String getNombre(Componente componente) {
        return componente.getNombre();
    }

    @FXML
    private void mostrarDetallesComponente(Componente componente) {
        Componente seleccionado = (Componente) tablaComponente.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
              tablaComponente.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 ) {
           gestorInventario.muestraDetalle(seleccionado);
        }
    });
            

        }

    }

    @FXML
    private void crearComponente() {
        Componente temporal = new Componente();
        boolean guardarClicked = gestorInventario.muestraNuevo(temporal);
        if (guardarClicked) {
            gestorInventario.getDatosComponente().add(temporal);
        }

    }

    
   @FXML
    private void borrarPersona() {
        //Capturo el indice seleccionado y borro su item asociado de la tabla
        int indiceSeleccionado = tablaComponente.getSelectionModel().getSelectedIndex();
        if (indiceSeleccionado >= 0) {
            tablaComponente.getSelectionModel().clearSelection(indiceSeleccionado);
            //Borro item
            Alert alerta1 = new Alert(AlertType.CONFIRMATION);
            //Muestro alerta para asegurar que se quiere borrar componente
            alerta1.setTitle("Atención");
            alerta1.setHeaderText("Va a borrar un componente de la lista");
            alerta1.setContentText("¿Seguro que desea borrar este componente?");
            Optional<ButtonType> result = alerta1.showAndWait();
            if (result.get() == ButtonType.OK) {
                tablaComponente.getItems().remove(indiceSeleccionado);
            } else {
                alerta1.close();
            }
        } else {
            //Muestro alerta
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle("Atención");
            alerta.setHeaderText("Componente no seleccionado");
            alerta.setContentText("Por favor, selecciona un componente de la tabla");
            alerta.showAndWait();
        }
    }
    
    //Muestro el diálogo editar componente cuando el usuario hace clic en el botón de Editar
    @FXML
    private void editarComponente() {
        Componente seleccionada = (Componente) tablaComponente.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            boolean guardarClicked = gestorInventario.muestraEditarComponente(seleccionada);
            if (guardarClicked) {
                mostrarDetallesComponente(seleccionada);
            }

        } else {
            //Muestro alerta
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Alerta");
            alerta.setHeaderText("Componente no seleccionada");
            alerta.setContentText("Por favor, selecciona un componente");
            alerta.showAndWait();
        }
    }

}
