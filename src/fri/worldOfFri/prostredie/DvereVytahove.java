/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;


public class DvereVytahove extends Dvere {
    
    private boolean otvoreneDvere; 
    private int poschodie;
            
    public DvereVytahove(Vytah vytah, Miestnost druhaM, int poschodie) {
        super(vytah, druhaM);
        this.otvoreneDvere = false;
        this.poschodie = poschodie;
    }
   
    @Override
    public boolean zamknute() {
        return !this.otvoreneDvere;
    }
    
    public void odomkniZamkni() {
        this.otvoreneDvere = !this.otvoreneDvere;
    }

    public int getPoschodie() {
        return this.poschodie;
    }

}
