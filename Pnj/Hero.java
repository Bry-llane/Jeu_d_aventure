/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pnj;

import Pnj.Monsters.Gargoyle;
import Pnj.Monsters.Gobelin;
import Pnj.Monsters.Boss;
import Pnj.Monsters.Minotaur;
import java.util.ArrayList;
import Interfaces.Attacker;
import Items.Ammunitions.Arrow;
import Items.Ammunitions.Bullet;
import Items.Heal;
import Items.Weapons.Bow;
import Items.Weapons.Gun;
import Items.Item;
import Items.Keys.ChestKey;
import Items.Keys.ExitKey;
import Items.Repair;
import Items.Weapons.Spear;
import Items.Weapons.Sword;
import Items.Weapon;
import projet.ColorConsole;

/**
 *
 * @author midek
 */
public class Hero extends Character implements Attacker {
    private final int DEFAULT_PV = 400;
    private final int DEFAULT_ATT = 40;
    private final int DEFAULT_VOLUME_MAX = 100;
    private final String DEFAULT_NAME = "Hero";
    private final String DEFAULT_PHRASE = "Bonjour";
    
    private ArrayList<Item> inventory;
    private Weapon equipWeapon;
    private final int VOLUME_MAX_INVENTORY;
    private int remainingVolumeIventory;
    private int money;
    
    
    public Hero() {
        super.setAtt(DEFAULT_ATT);
        super.setPv(DEFAULT_PV);
        this.inventory = new ArrayList<>();
        super.setName(DEFAULT_NAME);
        this.equipWeapon = null;
        this.VOLUME_MAX_INVENTORY = DEFAULT_VOLUME_MAX;
        this.remainingVolumeIventory = DEFAULT_VOLUME_MAX;
        this.money = 100;
        super.setPhrase(DEFAULT_PHRASE);
    }

    public Hero(String name) {
        super.setAtt(DEFAULT_ATT);
        super.setPv(DEFAULT_PV);
        this.inventory = new ArrayList<>();
        super.setName(name);
        this.equipWeapon = null;
        this.VOLUME_MAX_INVENTORY = DEFAULT_VOLUME_MAX;
        this.remainingVolumeIventory = DEFAULT_VOLUME_MAX;
        this.money = 100;
        super.setPhrase(DEFAULT_PHRASE);
    }

    @Override
    public boolean canAndBeAttack() {
        return true;
    }
    
    @Override
    public void attack (Character c) {
        if (this.hasEquipWeapon() == true){    
            if (c.canAndBeAttack() == true) {
                int vie = c.getPv();
                int damage = this.equipWeapon.getAtt();

                int criticalChance =  (int) (Math.random() * 10);
                if (criticalChance == 1) {
                    damage = damage * 2;
                    System.out.println("Attaque critique");
                }

                if (c instanceof Gargoyle && (this.equipWeapon instanceof Gun || this.equipWeapon instanceof Bow)) {
                    damage = damage + 10;
                    System.out.println("Arme efficace");
                } else if (c instanceof Gobelin && (this.equipWeapon instanceof Sword)){
                    damage = damage + 10;
                    System.out.println("Arme efficace");
                } else if (c instanceof Minotaur && (this.equipWeapon instanceof Spear)){
                    damage = damage + 10;
                    System.out.println("Arme efficace");
                }
                
                if (this.equipWeapon instanceof Gun) {
                    Gun g = (Gun) this.equipWeapon;
                    if (g.getBulletStock() > 0) {
                        g.useBulletStock();
                        if (vie > damage){
                            c.setPv(vie - damage);
                            System.out.println("Vous avez inflige " + damage + " de degat, il lui reste " + c.getPv() + " de point de vie");
                            c.attack(this);
                        } else {
                            c.setPv(0);
                            System.out.println("Aaaarh \nLe monstre est mort");
                            c = null;

                            if(c instanceof Gobelin) {
                                this.addMoney(50);
                                System.out.println("Vous gagne 50 piece");
                            } else if(c instanceof Gargoyle) {
                                this.addMoney(10);
                                System.out.println("Vous gagne 10 piece");
                            } else if(c instanceof Minotaur) {
                                this.addMoney(30);
                                System.out.println("Vous gagne 30 piece");
                            } else if(c instanceof Boss) {
                                this.addMoney(1000);
                                System.out.println("Vous gagne 1000 piece");   
                            }
                        }  
                        this.equipWeapon.decreaseDurra();
                        if (this.equipWeapon.getDurra() == 0) {
                            System.out.println("votre arme est cassee");
                            this.equipWeapon = null;
                        }                        
                    } else {
                        System.out.println("Pas de balle");
                    }
                }
                
                if (this.equipWeapon instanceof Bow) {
                    if (this.hasArrow() == true ) {
                        this.decreaseArrow();
                        if (vie > damage){
                            c.setPv(vie - damage);
                            System.out.println("Vous avez inflige " + damage + " de degat, il lui reste " + c.getPv() + " de point de vie");
                            c.attack(this);
                        } else {
                            c.setPv(0);
                            System.out.println("Aaaarh \nLe monstre est mort");
                            c = null;

                            if(c instanceof Gobelin) {
                                this.addMoney(50);
                                System.out.println("Vous gagne 50 piece");
                            } else if(c instanceof Gargoyle) {
                                this.addMoney(10);
                                System.out.println("Vous gagne 10 piece");
                            } else if(c instanceof Minotaur) {
                                this.addMoney(30);
                                System.out.println("Vous gagne 30 piece");
                            } else if(c instanceof Boss) {
                                this.addMoney(1000);
                                System.out.println("Vous gagne 1000 piece");   
                            }
                        }
                        this.equipWeapon.decreaseDurra();
                        if (this.equipWeapon.getDurra() == 0) {
                            System.out.println("votre arme est cassee");
                            this.equipWeapon = null;
                        }
                    } else {
                        System.out.println("Pas de fleche");
                    }
                }
                
                if (this.equipWeapon instanceof Spear || this.equipWeapon instanceof Sword) {
                    if (vie > damage){
                        c.setPv(vie - damage);
                        System.out.println("Vous avez inflige " + damage + " de degat, il lui reste " + c.getPv() + " de point de vie");
                        c.attack(this);
                    } else {
                        c.setPv(0);
                        System.out.println("Aaaarh \nLe monstre est mort");
                        c = null;

                        if(c instanceof Gobelin) {
                            this.addMoney(50);
                            System.out.println("Vous gagne 50 piece");
                        } else if(c instanceof Gargoyle) {
                            this.addMoney(10);
                            System.out.println("Vous gagne 10 piece");
                        } else if(c instanceof Minotaur) {
                            this.addMoney(30);
                            System.out.println("Vous gagne 30 piece");
                        } else if(c instanceof Boss) {
                            this.addMoney(1000);
                            System.out.println("Vous gagne 1000 piece");   
                        }
                    }
                    this.equipWeapon.decreaseDurra();
                    if (this.equipWeapon.getDurra() == 0) {
                        System.out.println("votre arme est cassee");
                        this.equipWeapon = null;
                    }
                }
                
            } else {
                System.out.println("La cible ne peut etre attaquee ");
            } 
        } else {
            System.out.println("Vous n'avez pas equipe d'arme, USE weapon pour en equiper");
        }
    }
    
    public void useItem(Item item) {
        //prned object Hill ou repear
        if(item instanceof Heal) {
            int pvToAdd = ((Heal) item).getPvGive();
            this.setPv(this.getPv() + pvToAdd);
        } else if (item instanceof Repair) {
            if(this.hasEquipWeapon()) {
                int pvToActualItem = ((Repair) item).getDurraGive();
                this.equipWeapon.setDurra(this.equipWeapon.getDurra() + pvToActualItem);
            }
        } 
    }
    
    public ArrayList<Item> getItems() {
        return this.inventory;
    }
    
    public void equipItem(Weapon arme) {
        if (this.hasEquipWeapon() == false) {
            this.equipWeapon = arme;
            this.remainingVolumeIventory = this.remainingVolumeIventory - arme.getVolume();
            arme = null;
        } else {
            Weapon temp = this.equipWeapon; //old arme
            this.equipWeapon = arme; // newarme
            this.remainingVolumeIventory = this.remainingVolumeIventory - arme.getVolume();

        }
    }
    
    public boolean hasEquipWeapon() {
        if (this.equipWeapon != null) {
            return true;
        }
        return false;
    }
    
    public void addMoney(int newMoney) {
        this.money = this.money + newMoney;
    }
    
    public void addItem(Item add) {
        if (this.remainingVolumeIventory > add.getVolume()) {
            this.remainingVolumeIventory = this.remainingVolumeIventory - add.getVolume();
            this.inventory.add(add);
        } else {
            System.out.println(ColorConsole.RED_BOLD + "Vous n'avez plus assez de place dans votre inventaire" + ColorConsole.WHITE_BOLD);
        }
    }
    
    public boolean hasExitKey() { 
        for(int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i) instanceof ExitKey) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasChestKey() { 
        for(int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i) instanceof ChestKey) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasArrow() { 
        for(int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i) instanceof Arrow) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasBullet() { 
        for(int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i) instanceof Bullet) {
                return true;
            }
        }
        return false;
    }
    
    public void decreaseArrow() {
        if (this.hasArrow() == true){
            int i;
            for(i = 0; i < this.inventory.size(); i++) {
                if (this.inventory.get(i) instanceof Arrow) {
                    Arrow n = (Arrow) this.inventory.get(i);
                    n.useAmmunition();
                    if (n.getStock()== 0) {
                        this.removeItem(i);
                    }   
                } 
            }       
        }
    }   
    
    public void decreaseBullet() {
        if (this.hasExitKey() == true){
            int i;
            for(i = 0; i < this.inventory.size(); i++) {
                if (this.inventory.get(i) instanceof ExitKey) {
                    ExitKey n = (ExitKey) this.inventory.get(i);
                    n.useKey();
                    if (n.getNbKey() == 0) {
                        this.removeItem(i);
                    }   
                } 
            }       
        }
    }   
    
    public int getVolumeMax(){
        return this.VOLUME_MAX_INVENTORY;
    }
    
    public void decreasePv() {
        this.setPv(this.getPv() - 50);
    }
    
    public void decreaseExitKey() {
        if (this.hasExitKey() == true){
            int i;
            for(i = 0; i < this.inventory.size(); i++) {
                if (this.inventory.get(i) instanceof ExitKey) {
                    ExitKey n = (ExitKey) this.inventory.get(i);
                    n.useKey();
                    if (n.getNbKey() == 0) {
                        this.removeItem(i);
                    }   
                } 
            }       
        }
    }     
    
    public void decreaseChestKey() {
        if (this.hasExitKey() == true){
            int i = 0;
            for(i = 0; i < this.inventory.size(); i++) {
                if (this.inventory.get(i) instanceof ChestKey) {
                    ChestKey n = (ChestKey) this.inventory.get(i);
                    n.useKey();
                    if (n.getNbKey() == 0) {
                        this.removeItem(i);
                    }   
                } 
            }       
        }
    }    
    
    public void removeItem(int index) {
        if(index >= 0 && index < this.inventory.size()) {
            this.remainingVolumeIventory = this.remainingVolumeIventory + this.inventory.get(index).getVolume();
            this.inventory.remove(index);
        }
    }
    
    public int getRemainningVolume() {
        return this.remainingVolumeIventory;
    }
    
    public int getMoney() {
        return this.money;
    }
    
    public void setMoney(int newMoney) {
        this.money = newMoney;
    }
    
    @Override
    public void talk(String phrase) {
        System.out.println(phrase);
    }   
}
