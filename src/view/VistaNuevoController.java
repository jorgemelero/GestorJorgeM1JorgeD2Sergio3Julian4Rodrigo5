/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorInventario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.Componente;
import util.Fechas;

/**
 *
 * @author dam
 */
public class VistaNuevoController {

    @FXML
    private TextField fotoTextField;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField precioTextField;
    @FXML
    private TextField stockTextField;
    @FXML
    private TextArea descripcion;

    private Componente componente;
    private Stage escenarioNuevo; //Escenario de edición
    private boolean guardarClicked = false;
    private GestorInventario gestorInventario;
    String ruta = "/img/";

    @FXML
    private void initialize() {

    }
    
    //Es llamado por la apliación principal para tener una referencia de vuelta de si mismo
    public void setGestorInventario(GestorInventario gestorInventario) {

        this.gestorInventario = gestorInventario;
    }

    //Establece el escenario de edición
    public void setEscenarioNuevo(Stage escenarioNuevo) {
        this.escenarioNuevo = escenarioNuevo;
    }

    public boolean isGuardarClicked() {
        return guardarClicked;
    }

    @FXML
    private void anadir() {
        System.out.println(ruta + " " + fotoTextField.getText());
        if (datosValidos()) {

            //Asigno datos a propiedades de persona
            LocalDate now = LocalDate.now();
            //String valor = ruta();
            System.out.println(fotoTextField.getText());
            componente.setFoto(new ImageView(ruta));
            componente.setNombre(nombreTextField.getText());
            componente.setPrecio(precioTextField.getText());
            componente.setStock(stockTextField.getText());
            componente.setFechaAlta(now);
            componente.setFechaMod(now);
            componente.setDescripcion(descripcion.getText());
            componente.setRuta(fotoTextField.getText());
            guardarClicked = true; //Cambio valor booleano
            escenarioNuevo.close(); //Cierro el escenario de edición

        }
    }

    //LLamado cuando se pulsa Cancelar
    @FXML
    private void cancelar() {
        escenarioNuevo.close();
    }

    //Validación de datos
    private boolean datosValidos() {

        //Inicializo string para mensajes
        String mensajeError = "";
       
        //Compruebo los campos
        if (nombreTextField.getText() == null || nombreTextField.getText().length() == 0) {
            mensajeError += "Nombre no válido.\n";
        }
        //if (fotoTextField.getText() == null || fotoTextField.getText().length() == 0) {
        //    mensajeError += "foto  no válidos.\n";
        //}
        if (precioTextField.getText() == null || precioTextField.getText().length() == 0) {
            mensajeError += "Dirección no válida.\n";
        }

        if (stockTextField.getText() == null || stockTextField.getText().length() == 0) {
            mensajeError += "Código postal no válido.\n";
        }
        if (mensajeError.length() == 0) {
            System.out.println(ruta + " " + fotoTextField.getText());
            return true;
        } else {
            //Muestro alerta y devuelvo false
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos no válidos");
            alerta.setContentText("Por favor, corrige los errores");
            alerta.showAndWait();
            System.out.println(ruta);
            return false;
        }
         
    }

    //Establece la componente a editar
    public void setComponente(Componente componente) {
        this.componente = componente;

        nombreTextField.setText(componente.getNombre());
        precioTextField.setText(componente.getPrecio());
        stockTextField.setText(componente.getStock());
        descripcion.setText(componente.getDescripcion());
        //codigoPostalTextField.setText(Integer.toString(persona.getCodigoPostal()));
        //ciudadTextField.setText(persona.getCiudad());
        //fechaDeNacimientoTextField.setText(UtilidadDeFechas.formato(persona.getFechaDeNacimiento()));
        //fechaDeNacimientoTextField.setPromptText("dd/mm/yyyy");

    }

    @FXML
    public void ruta() {
        FileChooser fileChooser = new FileChooser();
        //Muestro el diálogo de guardar
        File archivo = fileChooser.showOpenDialog(escenarioNuevo);
        //System.out.println(archivo.getParent());
      
        byte [] contenido = null;
        try {
           contenido = Files.readAllBytes(Paths.get(archivo.getParent(), archivo.getName()));
        } catch (IOException ex) {
            System.out.println("error al leer");
        }
        File destino = new File("E:\\prueba2\\GestorJorgeM1JorgeD2Sergio3Julian4Rodrigo5-master\\src\\img");
        System.out.println(destino.getParent());
        //System.out.println(contenido);
        try {
            Files.write(Paths.get(destino.toString(),archivo.getName()),contenido);
        } catch (IOException ex) {
            System.out.println("error al escribir");
        }
          ruta = "/img/" + archivo.getName();
        fotoTextField.setText(ruta);
         //return ruta;

    }

}
