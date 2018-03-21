/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.predmety;

import fri.worldOfFri.hra.Hrac;



/**
 *
 * @author jancigova2
 */
public class Predmet implements IPredmet {
    private String meno;
    private String popis;
    
    public Predmet(String meno, String popis) {
        this.meno = meno;
        this.popis = popis;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }
    
    @Override
    public String getPopis() {
        return this.popis;
    }
    @Override
    public void pouzi(Hrac hrac) {
        System.out.println("Tento predmet nema specialne pouzitie");
    }    
}
