/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;


public class DvereNaKluc implements IDvere {

    private Miestnost prvaMiestnost;
    private Miestnost druhaMiestnost;
    private boolean suZamknute;
    
    DvereNaKluc(Miestnost prvaM, Miestnost druhaM) {
        this.prvaMiestnost = prvaM;
        this.druhaMiestnost = druhaM;
        
        this.prvaMiestnost.nastavDvere(this.druhaMiestnost.getNazov(),this);
        this.druhaMiestnost.nastavDvere(this.prvaMiestnost.getNazov(),this);
        
        this.suZamknute = true;
    }
    
    @Override
    public boolean zamknute() {
        return this.suZamknute;
    }

    public void odomkniZamkni() {
        if (this.suZamknute) {
            System.out.println("odomykam");
        } else {
            System.out.println("zamykam");
        }
        
        this.suZamknute = !this.suZamknute;
    }

    @Override
    public Miestnost dajDruhuMiestnost(Miestnost tatoMiestnost) {
        return tatoMiestnost == this.prvaMiestnost ? this.druhaMiestnost : this.prvaMiestnost;   
    }
    
}
