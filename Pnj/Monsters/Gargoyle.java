/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pnj.Monsters;

import Pnj.Monster;
import Pnj.Monster;

/**
 *
 * @author matte
 */
public class Gargoyle extends Monster {
    private final int DEFAULT_PV = 60;
    private final int DEFAULT_ATT = 10;
    private final String DEFAULT_PHRASE = "Prepare toi a mourir";
    
    public Gargoyle () {
        super.setName("Gargouille");
        super.setPv(this.DEFAULT_PV);
        super.setAtt(this.DEFAULT_ATT);
        super.setPhrase(DEFAULT_PHRASE);
    }
    
    public Gargoyle (String name, String phrase) {
        super.setName(name);
        super.setPv(this.DEFAULT_PV);
        super.setAtt(this.DEFAULT_ATT);
        super.setPhrase(phrase);
    }
    
    @Override
    public boolean canAndBeAttack() {
        return true;
    }
    
    public void talk(String phrase) {
        System.out.println(phrase);
    }
    
    public void defaulttalk() {
        System.out.println(super.getPhrase());
    }
}
