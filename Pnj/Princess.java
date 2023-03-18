/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pnj;

import projet.Place;
import Interfaces.Talker;

/**
 *
 * @author matte
 */
public class Princess extends Character implements Talker {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final Place DEFAULT_PLACE = null;
    private final String DEFAULT_PHRASE = "Enfin, vous êtes la !\nTue le BOSS et sauvez-moi !";
    
    private Place where;
    
    public Princess() {
        super.setName("Princess");
        this.where = DEFAULT_PLACE;
        super.setPhrase(DEFAULT_PHRASE);
    }
    
    public Princess(Place where) {
        this.where = where;
        super.setPhrase(DEFAULT_PHRASE);
    }
    
    public Place getPlace() {
        return this.where;
    }
    
    public void setPlace (Place where) {
        this.where = where;
    }
    
    @Override
    public boolean canAndBeAttack() {
        return false;
    }
    
    @Override
    public void talk(String phrase) {
        System.out.println(phrase);
    }
    
    public void defaulttalk() {
        if (this.where.bossIsAlive() == true) {
            System.out.println(super.getPhrase());
        } else {
            this.talk("Merci de m'avoir sauve !");
        }
    }    
}
