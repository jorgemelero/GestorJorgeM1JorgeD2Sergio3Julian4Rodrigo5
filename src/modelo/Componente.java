/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;

/**
 *
 * @author dam
 */
public class Componente {

    //private ImageView foto;
    private final StringProperty foto;
    private final StringProperty nombre;
    private final StringProperty precio;
    private final StringProperty stock;
    
    public Componente(){
        this(null,null,null,null);
    }

    public Componente(String foto, String nombre, String precio, String stock) {
        //this.foto = foto;
        this.foto = new SimpleStringProperty(foto);
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleStringProperty(precio);
        this.stock = new SimpleStringProperty(stock);

    }

//    public ImageView getFoto() {
//        return foto;
//    }
//
//    public void setFoto(ImageView foto) {
//        this.foto = foto;
//    }
    
    
     public String getFoto() {
        return foto.get();
    }

    public StringProperty fotoProperty() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto.set(foto);
    }
    
    public String getNombre() {
        return nombre.get();
    }

    public StringProperty NombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getPrecio() {
        return precio.get();
    }

    public StringProperty PrecioProperty() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio.set(precio);
    }

    public String getStock() {
        return stock.get();
    }

    public StringProperty StockProperty() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock.set(stock);
    }

}
