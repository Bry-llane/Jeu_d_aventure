/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pnj;

import Interfaces.Talker;

/**
 *
 * @author matte
 */
public class OtherCharacter extends Character implements Talker {
    
    
    
    public OtherCharacter() {
        super.setName("OtherCharacter");
    }
    
    public OtherCharacter(String name, String phrase) {
        super.setName(name);
        super.setPhrase(phrase);
    }
    
    @Override
    public void talk(String phrase) {
        System.out.println(phrase);
    }
    
    public void defaulttalk() {
        System.out.println(super.getPhrase());
    }
}
