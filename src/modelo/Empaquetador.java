/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rodrigo
 */
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "componente") //Define el nombre del elemento raíz XML
public class Empaquetador {
    
    private List<Componente> componentes;
    
    @XmlElement(name = "Componente") //Opcional para el elemento especificado
    public List<Componente> getComponentes(){
        return componentes;
    }
    
    public void setComponentes(List<Componente> componentes){
        this.componentes = componentes;
    }
    
}
