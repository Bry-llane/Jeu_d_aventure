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
public class Boss extends Monster{
    private final int DEFAULT_PV = 350;
    private final int DEFAULT_ATT = 50;
    private final String DEFAULT_PHRASE = "Je pensais pas que t'arriverai jusqu'ici, mais c'est la fin de ton voyage";
    
    public Boss () {
        super.setName("Boss");
        super.setPv(this.DEFAULT_PV);
        super.setAtt(this.DEFAULT_ATT);
        super.setPhrase(DEFAULT_PHRASE);
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
