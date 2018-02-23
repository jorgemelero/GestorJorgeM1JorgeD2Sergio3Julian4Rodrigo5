/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorInventario;
import java.io.File;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.stage.DirectoryChooser;
import javax.swing.JOptionPane;
import modelo.Componente;

/**
 *
 * @author Rodrigo
 */
public class VistaPrincipalController {

    private GestorInventario gestorInventario;
    VistaComponenteController vista = new VistaComponenteController();

    //Es llamado por la apliación principal para tener una referencia de vuelta de si mismo
    public void setGestorInventario(GestorInventario gestorInventario) {

        this.gestorInventario = gestorInventario;
    }

    @FXML
    private void guardarComo() {

        FileChooser fileChooser = new FileChooser();

        //Filtro para la extensión
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Muestro el diálogo de guardar
        File archivo = fileChooser.showSaveDialog(gestorInventario.getPrimaryStage());
        System.out.println(archivo.getPath());

        if (archivo != null) {
            //Me aseguro de que tiene la extensión correcta
            if (!archivo.getPath().endsWith(".xml")) {
                archivo = new File(archivo.getPath() + ".xml");
            }
            gestorInventario.guardaComponentes(archivo);
        }
    }

    @FXML
    private void nuevo() {
        gestorInventario.getDatosComponente().clear();
        gestorInventario.setRutaArchivoComponentes(null);
    }

    @FXML
    private void abrir() {
        FileChooser fileChooser = new FileChooser();

        //Filtro para la extensión
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Muestro el diálogo de guardar
        File archivo = fileChooser.showOpenDialog(gestorInventario.getPrimaryStage());

        if (archivo != null) {
            gestorInventario.cargaComponentes(archivo);
        }
    }

    @FXML
    private void guardar() {
        File archivo = gestorInventario.getRutaArchivoComponetes();
        if (archivo != null) {
            gestorInventario.guardaComponentes(archivo);
        } else {
            guardarComo();
        }
    }

    @FXML
    private void manual() {
        try {
            File path = new File("src/manual.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void ruta() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File archivo = directoryChooser.showDialog(gestorInventario.getPrimaryStage());

        File path = new File("src/manual.pdf");

        byte[] contenido = null;
        try {
            contenido = Files.readAllBytes(Paths.get(path.getParent(), path.getName()));
        } catch (IOException ex) {
            System.out.println("error al leer");
        }

        System.out.println(archivo.getPath());
        try {
            Files.write(Paths.get(archivo.getAbsolutePath(), path.getName()), contenido);
        } catch (IOException ex) {
            System.out.println("error al escribir");
        }

        //fotoTextField.setText(ruta);
        //return ruta;
    }

    @FXML
    public void grafico() {
        gestorInventario.crearGrafico();
    }

}
