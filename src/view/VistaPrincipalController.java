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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
            gestorInventario.guardaPersonas(archivo);
        }
    }
    
    @FXML
    public void grafico(){
    gestorInventario.crearGrafico();
    }
    
    @FXML
    public void generarCodBarras() throws DocumentException{
        try {
            String nombre = JOptionPane.showInputDialog(null,"Numero de etiquetas");
            

            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("cohhh.pdf"));
            doc.open();
            
             Paragraph texto = new Paragraph();
            texto.add("NIVIDIA GTX 1050ti");
            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            
            
            Barcode39 code = new Barcode39();
            
            code.setCode("1234567890");
            com.itextpdf.text.Image  img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            
            doc.add(texto);
            doc.add(img);
            
            
            
            doc.close();
            
        } catch (FileNotFoundException ex) {
        }
    }
}
