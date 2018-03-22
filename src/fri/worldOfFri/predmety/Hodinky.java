/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.predmety;
import fri.worldOfFri.hra.Hrac;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jancigova2
 */
public class Hodinky implements IPredmet, IPouzitelny {
    
    public Hodinky() {
    
    }
    
    @Override
    public String getMeno() {
        return "hodinky";
    }
    
    @Override
    public String getPopis() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    @Override
    public void pouzi(Hrac hrac) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        System.out.print("Teraz je ");
        System.out.println(dateFormat.format(date));
    }
    
    
}
