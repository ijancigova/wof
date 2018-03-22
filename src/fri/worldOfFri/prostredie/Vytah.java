/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.hra.Hrac;
import fri.worldOfFri.predmety.IPouzitelny;


public class Vytah extends Miestnost implements IPouzitelny {
    private int aktualnePoschodie;
    private boolean ideHore;
    
    public Vytah() {
        super("vytah", "vytah sa da pouzit");
        this.aktualnePoschodie = 0;
        this.ideHore = true;
    }
    
    public void pouzi(Hrac hrac) {
           //dajDverePodlaPoschodia
           //zavri dvere
           //posun
           //dajDverePodlaPoschodia
           //otvor dvere
    }
    
    public DvereVytahove dajDverePodlaPoschodia(int poschodie) {
        ..
        DvereVytahove dvereV = (DvereVytahove) tmpDvere;
        ...
        return dvereV
    }
}
