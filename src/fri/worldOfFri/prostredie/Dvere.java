/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;


public class Dvere implements IDvere {

    private Miestnost prvaMiestnost;
    private Miestnost druhaMiestnost;
    
    Dvere(Miestnost prvaM, Miestnost druhaM) {
        this.prvaMiestnost = prvaM;
        this.druhaMiestnost = druhaM;
        
        this.prvaMiestnost.nastavDvere(this.druhaMiestnost.getNazov(),this);
        this.druhaMiestnost.nastavDvere(this.prvaMiestnost.getNazov(),this);
    }
    
    @Override
    public boolean zamknute() {
        return false;
    }

    @Override
    public Miestnost dajDruhuMiestnost(Miestnost tatoMiestnost) {
        return tatoMiestnost == this.prvaMiestnost ? this.druhaMiestnost : this.prvaMiestnost;   
    }
    
}
