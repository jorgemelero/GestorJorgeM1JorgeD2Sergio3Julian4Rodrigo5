/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorInventario;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import modelo.Componente;

/**
 *
 * @author Sergio
 */
public class VistaEstadisticasController {
    
    GestorInventario g = new GestorInventario();

    @FXML
    private BarChart<String, Integer> graficoBarras;

    @FXML
    private CategoryAxis ejeX;

    @FXML
    private NumberAxis ejeY;

    //tenemos que recoger los datos de datosComponente
    private Componente components;
    
    ObservableList<String> producto = FXCollections.observableArrayList();
    ObservableList<String> producto2 = FXCollections.observableArrayList();
    ObservableList<Componente> compo = FXCollections.observableArrayList();

    //Se invoca justo después de que se ha cargado el archivo FXML
    @FXML
    private void initialize() {
            compo = g.getDatosComponente();
        for (int i = 0; i < compo.size(); i++) {
            producto.add(compo.get(i).getNombre());
            producto2.add(compo.get(i).getStock());
        }

        //Asigno los nombres de Componentes a categorías
        ejeX.setCategories((ObservableList<String>) producto);

        //Etiquetas de los ejes
        ejeX.setLabel("Nombre Componente");
        ejeY.setLabel("Numero de Articulos");

    }

    public void setDatosComponente(List<Componente> componentes) {
        int[] numCant = new int[compo.size()];
        ArrayList<String> nombres = new ArrayList<>();
        System.out.println(compo.size());
        for (Componente c : componentes) {
            boolean b = false;
            String n = c.getNombre();
            nombres.add(n);
            for(int i = 0; i < nombres.size();i++){
                if(nombres.get(i).equals(n)){
                    numCant[i] = Integer.parseInt(c.getStock());
                }
            }

        }
         //Genero la serie
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("Cantidad por articulo");
        for (int i = 0; i < numCant.length; i++) {
            series.getData().add(new XYChart.Data<>(producto.get(i), numCant[i]));
        }

        //Añado la serie al gráfico
        graficoBarras.getData().add(series);
    }

}
