/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pnj;

/**
 *
 * @author matte
 */
public abstract class Monster extends Character {
    private final int DEFAULT_PV = 100;
    private final int DEFAULT_ATT = 25;
    private final String DEFAULT_NAME = "Monster";
    private final String DEFAULT_PHRASE = "Prepare toi a mourir";
    
    public Monster() {
        super.setAtt(DEFAULT_ATT);
        super.setPv(DEFAULT_PV);
        super.setName(DEFAULT_NAME);
        super.setPhrase(DEFAULT_PHRASE);
    }
    
    public Monster(String name) {
        super.setAtt(DEFAULT_ATT);
        super.setPv(DEFAULT_PV);
        super.setName(DEFAULT_PHRASE);
    }
    
    @Override
    public boolean canAndBeAttack() {
        return true;
    }
    
}
