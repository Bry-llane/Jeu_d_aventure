/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pnj;

import Interfaces.Attacker;
import Interfaces.Talker;

/**
 *
 * @author matte
 */
public abstract class Character implements Attacker, Talker {
    private final int DEFAULT_PV = 0;
    private final int DEFAULT_ATT = 0;
    private final String DEFAULT_NAME = "Character";
    private final String DEFAULT_PHRASE = "....";
    
    private int pv;
    private int att;
    private String name;
    private String phrase;
    
    private boolean attack = true;
    private boolean beAttack = true;
        
    public Character() {
        this.name = DEFAULT_NAME;
        this.att = DEFAULT_ATT;
        this.pv = DEFAULT_PV;
        this.phrase = DEFAULT_PHRASE;
    }
    
    public Character(String name, String p) {
        this.name = name;
        this.att = DEFAULT_ATT;
        this.pv = DEFAULT_PV;
        this.phrase = p;
    }
    
    public int getAtt () {
        return this.att;
    }
    public void setAtt (int att) {
        if(att < 0) System.err.println("Attack cannot be negative");
        else this.att = att;
    }
    
    public int getPv () {
        return this.pv;
    }
    public void setPv (int pv) {
        if(att < 0) System.err.println("PV cannot be negative");
        else this.pv = pv;
    }

    public String getName () {
        return this.name;
    }
    public void setName (String name) {
        this.name = name;
    }
    
    public void setPhrase (String p) {
        this.phrase = p;
    }
    
    public String getPhrase () {
        return this.phrase;
    }
    
    @Override
    public boolean canAndBeAttack() {
        return false;
    }
    
    @Override
    public void attack (Character c) {
        if (this.canAndBeAttack() == true) {
            if (c.canAndBeAttack() == true) {
                int vie = c.getPv();
                int damage = this.getAtt();
                int criticalChance =  (int) (Math.random() * 10);
                if (criticalChance == 1) {
                    damage = damage * 2;
                }
                if (vie > damage){
                    c.setPv(vie - damage);
                } else {
                    c.setPv(0);
                }
            } else {
                System.out.println("La cible ne peut être attaquee ");
            }
        } else {
            System.out.println("Ne peut pas attaquer ");
        } 
    }
    
    /*public String toString() {
        String sAttack;
        String sBeAttack;
        
        if(this.canAttack()) sAttack = String.valueOf(this.att);
        else sAttack = "Ne peut pas attaquer";
        
        if(this.canBeAttack()) sBeAttack = "Oui";
        else sBeAttack = "Non";
            
        return " **** " + this.name + " ****\n"
                + "PV: " + this.pv + "\n"
                + "Point d'attaque: " + sAttack + "\n"
                + "Peut être attaquer: " + sBeAttack + "\n"
                ;
    }*/
}
