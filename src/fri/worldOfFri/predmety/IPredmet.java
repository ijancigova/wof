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
public interface IPredmet {

    String getMeno();
    String getPopis();
    void pouzi(Hrac hrac);
    
}
