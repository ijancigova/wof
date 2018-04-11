/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.questy;

import fri.worldOfFri.hra.Hrac;


/**
 *
 * @author iva
 */
public class NajdiNavleky extends Quest {

    public NajdiNavleky() {
        super("Quest: Najdi sekeru.");
    }
    
    @Override
    public void skontrolujCiSplneny(Hrac hrac) {
        if (hrac.maPredmet("navleky")) {
            this.oznacAkoSplneny(); 
            System.out.println("Mas navleky, splnil/a si quest.");
        }
    } 
    
}
