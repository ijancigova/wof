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
public abstract class Quest {
    private String nazov;
    private StavQuestu stav;

    public Quest(String nazov) {
        this.nazov = nazov;
        this.stav = StavQuestu.NAZADANY;
    }
    
    public void prijmi(Hrac hrac) {
        this.stav = StavQuestu.ZADANY;
    }
    
    // nechceme priamo davat setter
    protected void oznacAkoSplneny() {
        if (this.stav == StavQuestu.ZADANY) {
            this.stav = StavQuestu.HOTOVY;
        }
    }
    
    // nechceme priamo davat setter
    protected void oznacAkoNesplneny() {
        if (this.stav == StavQuestu.ZADANY) {
            this.stav = StavQuestu.NESPLNENY;
        }
    }
    
    public String getPopis() {
        return this.nazov;
    }
    
    public StavQuestu getStav() {
        return this.stav;
    }
    
    public abstract void skontrolujCiSplneny(Hrac hrac); 
  
}
