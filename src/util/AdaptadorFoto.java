/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author milopez
 */
public class AdaptadorFoto  extends XmlAdapter<String, ImageView>{

    @Override
    public ImageView unmarshal(String v) throws Exception {
    ImageView foto = new ImageView(new Image(v));
    return foto;
    }

    @Override
    public String marshal(ImageView v) throws Exception {
    return v.toString();
    }
    
}
