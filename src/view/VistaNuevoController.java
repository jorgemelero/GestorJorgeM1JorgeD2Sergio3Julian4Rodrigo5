/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Componente;

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

    private Componente componente;
    private Stage escenarioNuevo; //Escenario de edición
    private boolean guardarClicked = false;

    @FXML
    private void initialize() {

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
        if (datosValidos()) {

        //Asigno datos a propiedades de persona
        System.out.println(fotoTextField.getText());
        componente.setFoto(fotoTextField.getText());
        componente.setNombre(nombreTextField.getText());
        componente.setPrecio(precioTextField.getText());
        componente.setStock(stockTextField.getText());

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
        if (fotoTextField.getText() == null || fotoTextField.getText().length() == 0) {
            mensajeError += "foto  no válidos.\n";
        }
        if (precioTextField.getText() == null || precioTextField.getText().length() == 0) {
            mensajeError += "Dirección no válida.\n";
        }

        if (stockTextField.getText() == null || stockTextField.getText().length() == 0) {
            mensajeError += "Código postal no válido.\n";
        }
        if (mensajeError.length() == 0) {
            return true;
        } else {
            //Muestro alerta y devuelvo false
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos no válidos");
            alerta.setContentText("Por favor, corrige los errores");
            alerta.showAndWait();
            return false;
        }

    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }
}
