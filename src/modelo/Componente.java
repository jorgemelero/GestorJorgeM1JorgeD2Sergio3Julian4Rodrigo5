/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author dam
 */
public class Componente {

    private ImageView foto;
    private final StringProperty nombre;
    private final StringProperty precio;
    private final StringProperty stock;
    private final String ruta;
    
    public Componente(){
        this(null,null,null,null,null);
    }

    public Componente(ImageView foto, String nombre, String precio, String stock, String ruta) {
        this.foto = (ImageView)foto;
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleStringProperty(precio);
        this.stock = new SimpleStringProperty(stock);
        this.ruta = ruta;

    }

    public String getRuta() {
        return ruta;
    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
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
