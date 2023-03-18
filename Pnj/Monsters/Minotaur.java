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
public class Minotaur extends Monster{
    private final int DEFAULT_PV = 120;
    private final int DEFAULT_ATT = 5;
    private final String DEFAULT_PHRASE = "Prepare toi a mourir";
    
    public Minotaur () {
        super.setName("Minotaur");
        super.setPv(this.DEFAULT_PV);
        super.setAtt(this.DEFAULT_ATT);
        super.setPhrase(DEFAULT_PHRASE);
        
    }
    
    public Minotaur (String name, String phrase) {
        super.setName(name);
        super.setPv(this.DEFAULT_PV);
        super.setAtt(this.DEFAULT_ATT);
        super.setPhrase(phrase);
    }
    
    @Override
    public boolean canAndBeAttack() {
        return true;
    }
    
    @Override
    public void talk(String phrase) {
        System.out.println(phrase);
    }
    
    public void defaulttalk() {
        System.out.println(super.getPhrase());
    }
}