/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.time.Month;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import util.Adaptador;
import util.AdaptadorFoto;

/**
 *
 * @author dam
 */
public class Componente {

    private ImageView foto;
    private final StringProperty nombre;
    private final StringProperty precio;
    private final StringProperty stock;
    private LocalDate fechaAlta;
    private LocalDate fechaMod;
    private String ruta;
    private String descripcion;
    private Integer codigo;
    
    public Componente(){
        this(null,null,null,null,null,null,null,null,null);
    }

    public Componente(ImageView foto, String nombre, String precio, String stock, String ruta, 
                      LocalDate fechaAlta,LocalDate fechaMod, Integer codigo,String descripcion) {
        this.foto = (ImageView)foto;
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleStringProperty(precio);
        this.stock = new SimpleStringProperty(stock);
        this.fechaAlta = fechaAlta;
        this.fechaMod = fechaMod;
        this.ruta = ruta;
        this.descripcion = descripcion;
        this.codigo = codigo;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

   

    public String getRuta() {
        return ruta;
    }
     public void setRuta(String ruta) {
        this.ruta = ruta;
    }
     @XmlJavaTypeAdapter(AdaptadorFoto.class)
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
    
    @XmlJavaTypeAdapter(Adaptador.class)
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    @XmlJavaTypeAdapter(Adaptador.class)
    public LocalDate getFechaMod() {
        return fechaMod;
    }
      public LocalDate setFechaAlta(LocalDate fecha) {
        fechaAlta = fecha;
        return fechaAlta;
    }
    
     public LocalDate setFechaMod(LocalDate fecha) {
         fechaMod = fecha;
        return fechaMod;
    }
     
    

}
