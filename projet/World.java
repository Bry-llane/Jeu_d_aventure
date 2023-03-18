/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

/**
 *
 * @author matte
 */

import Exits.Exit;
import Exits.KeyExit;
import Exits.QuestionExit;
import Items.Ammunitions.Arrow;
import Items.Ammunitions.Bullet;
import Items.Chests.KeyChest;
import Items.Heals.GreatHeal;
import Items.Heals.LittleHeal;
import Items.Keys.ExitKey;
import Items.Repairs.GreatRepairStone;
import Items.Repairs.LittleRepairStone;
import Items.Weapons.Bow;
import Items.Weapons.Gun;
import Items.Weapons.Spear;
import Items.Weapons.Sword;
import Pnj.Dealer;
import Pnj.Hero;
import Pnj.Monsters.Boss;
import Pnj.Monsters.Gargoyle;
import Pnj.Monsters.Gobelin;
import Pnj.Monsters.Minotaur;
import Pnj.OtherCharacter;
import Pnj.Princess;
import java.util.ArrayList;
import java.util.Scanner;


public class World {
    
    private Hero hero;
    
    public World (Hero hero) {
        this.hero = hero;
    }
    
    public void levelStartMessage(int level) {
        System.out.println("   ==============");
        System.out.println(ColorConsole.WHITE_BOLD + "      Niveau "+ level);
        System.out.println("   ==============\n");
    }
    private void toGo(String where) {
        System.out.println(where);
        if(where == null) {
            
        } else if (where.equals("level_1")) {
            this.level1();
        } else if (where.equals("level_2")) {
            this.level2();
        } else if (where.equals("level_3")) {
            this.level3();
        } else if (where.equals("level_4")) {
            this.level4();
        } else if (where.equals("level_5")) {
            this.level5();
        } else if (where.equals("level_6")) {
            this.level6();
        }
    }
    public void level1() {
        this.levelStartMessage(1);
        Place level = new Place("etage 1");
        level.addHero(this.hero);
        //Structure level_1
        
        /*les Exits*/
        Exit exit1 = new Exit("level_3");
        Exit exit2 = new Exit("level_4");
        
        level.addExit(exit1);
        level.addExit(exit2);
        
        /*les Pnj*/
        OtherCharacter pnj1 = new OtherCharacter("Guide", "Bienvenue, jeune hero\nLa princesse est retenue au level_6, vous devez la sauvez");
        
        level.addPnj(pnj1);
        
        /*les Monstres*/
        Gargoyle m1 = new Gargoyle();
        Gobelin m12 = new Gobelin();
        Minotaur m13 = new Minotaur();
        
        level.addPnj(m1);
        level.addPnj(m12);
        level.addPnj(m13);
        
        /*les Items*/
        Sword sword1 = new Sword();
        Spear Spear1 = new Spear();
        GreatHeal GreatHeal1 = new GreatHeal();
        LittleHeal LittleHeal1 = new LittleHeal();
        LittleHeal LittleHeal2 = new LittleHeal();
        LittleHeal LittleHeal3 = new LittleHeal();
        LittleHeal LittleHeal4 = new LittleHeal();
        LittleRepairStone LittleRepairStone1 = new LittleRepairStone();
        LittleRepairStone LittleRepairStone2 = new LittleRepairStone();
        LittleRepairStone LittleRepairStone3 = new LittleRepairStone();
        
        level.addItem(sword1);
        level.addItem(Spear1);
        level.addItem(GreatHeal1);
        level.addItem(LittleHeal1);
        level.addItem(LittleHeal2);
        level.addItem(LittleHeal3);
        level.addItem(LittleHeal4);
        level.addItem(LittleRepairStone1);
        level.addItem(LittleRepairStone2);
        level.addItem(LittleRepairStone3);
        
        
        ScanUser su = new ScanUser(level);
        
        while(su.loopYet()) {
            su.readUser();
        }
        
        this.toGo(su.getWhereGo());
        
    }
    
    public void level2() {
        this.levelStartMessage(2);
        Place level = new Place("etage 2");
        level.addHero(this.hero);
        //Structure level_2
        
        /*les Exits*/
        Exit exit1 = new Exit("level_1");
        QuestionExit qexit1 = new QuestionExit(1, "L'universite de Poitiers a ete fondee en quelle annee\n1 - > 1431\n2 - > 1432\n3 - > 1433\n4 - > 1430","level_4");
        
        level.addExit(exit1);
        level.addExit(qexit1);
        
        /*les Pnj*/
        OtherCharacter pnj1 = new OtherCharacter("Chevalier", "C'est quoi ce labyrinthe");
        
        level.addPnj(pnj1);
        
        /*les Monstres*/
        Gobelin m9 = new Gobelin();
        Gobelin m10 = new Gobelin();
        Gobelin m11 = new Gobelin();
        Gobelin m12 = new Gobelin();
        
        level.addPnj(m9);
        level.addPnj(m10);
        level.addPnj(m11);
        level.addPnj(m12);
        
        /*les Items*/
        GreatHeal GreatHeal1 = new GreatHeal();
        GreatHeal GreatHeal2 = new GreatHeal();
        
        level.addItem(GreatHeal1);
        level.addItem(GreatHeal2);
        
        ScanUser su = new ScanUser(level);
        
        while(su.loopYet()) {
            su.readUser();
        }
        
        this.toGo(su.getWhereGo());
    }
    
    public void level3() {
        this.levelStartMessage(3);
        Place level = new Place("etage 3");
        level.addHero(this.hero);
        //Structure level_3
        
        /*les Exits*/
        QuestionExit qexit1 = new QuestionExit(1, "L'age du plus petit du groupe qui a fait le projet\n1 - > 20\n2 - > 19\n3 - > 22\n4 - > 23","level_2");
        KeyExit kexit1 = new KeyExit("level_6");
        
        level.addExit(kexit1);
        level.addExit(qexit1);
        
        /*les Pnj*/
        OtherCharacter pnj1 = new OtherCharacter("Inconnu", "Heuresement qu'il y a un marchand à cet etage");
        
        level.addPnj(pnj1);
        
        /*Dealer*/
        Dealer d = new Dealer("Dealer");
        
        Sword sword1 = new Sword();
        Spear Spear1 = new Spear();
        Gun gun1 = new Gun();
        Bow bow1 = new Bow();
        Arrow arrow = new Arrow(1000);
        Bullet bullet = new Bullet(1000);
        GreatHeal GreatHeal1 = new GreatHeal();
        GreatHeal GreatHeal2 = new GreatHeal();
        GreatHeal GreatHeal3 = new GreatHeal();
        GreatHeal GreatHeal4 = new GreatHeal();
        LittleHeal LittleHeal1 = new LittleHeal();
        LittleHeal LittleHeal2 = new LittleHeal();
        LittleHeal LittleHeal3 = new LittleHeal();
        LittleHeal LittleHeal4 = new LittleHeal();
        LittleRepairStone LittleRepairStone1 = new LittleRepairStone();
        LittleRepairStone LittleRepairStone2 = new LittleRepairStone();
        LittleRepairStone LittleRepairStone3 = new LittleRepairStone();
        LittleRepairStone LittleRepairStone4 = new LittleRepairStone();
        GreatRepairStone GreatRepairStone1 = new GreatRepairStone();
        GreatRepairStone GreatRepairStone2 = new GreatRepairStone();
        GreatRepairStone GreatRepairStone3 = new GreatRepairStone();
        GreatRepairStone GreatRepairStone4 = new GreatRepairStone();
        
        d.addItem(sword1);
        d.addItem(Spear1);
        d.addItem(gun1);
        d.addItem(bow1);
        d.addItem(arrow);
        d.addItem(bullet);
        d.addItem(GreatHeal1);
        d.addItem(GreatHeal2);
        d.addItem(GreatHeal3);
        d.addItem(GreatHeal4);
        d.addItem(LittleHeal1);
        d.addItem(LittleHeal2);
        d.addItem(LittleHeal3);
        d.addItem(LittleHeal4);
        d.addItem(LittleRepairStone1);
        d.addItem(LittleRepairStone2);
        d.addItem(LittleRepairStone3);
        d.addItem(LittleRepairStone4);
        d.addItem(GreatRepairStone1);
        d.addItem(GreatRepairStone2);
        d.addItem(GreatRepairStone3);
        d.addItem(GreatRepairStone4);
        
        level.addPnj(d);
        
        /*les Monstres*/
        Gargoyle m1 = new Gargoyle();
        Gargoyle m2 = new Gargoyle();
        Gargoyle m3 = new Gargoyle();
        Gargoyle m4 = new Gargoyle();
        Gargoyle m5 = new Gargoyle();
        Gargoyle m6 = new Gargoyle();
        Gargoyle m7 = new Gargoyle();
        Gargoyle m8 = new Gargoyle();
        
        level.addPnj(m1);
        level.addPnj(m2);
        level.addPnj(m3);
        level.addPnj(m4);
        level.addPnj(m5);
        level.addPnj(m6);
        level.addPnj(m7);
        level.addPnj(m8);
        
        /*les Items*/
        
        
        ScanUser su = new ScanUser(level);
        
        while(su.loopYet()) {
            su.readUser();
        }
        
        this.toGo(su.getWhereGo());
    }
        
    public void level4() {
        this.levelStartMessage(4);
        Place level = new Place("etage 4");
        level.addHero(this.hero);
        //Structure level_4
        
        /*les Exits*/
        QuestionExit qexit1 = new QuestionExit(3, "La derniere version de java est sorti en quel annee\n1 - > 2020\n2 - > 2019\n3 - > 2021\n4 - > 2018","level_5");
        
        level.addExit(qexit1);
        
        /*les Pnj*/
        OtherCharacter pnj1 = new OtherCharacter("Perruq", "Bonjour, .........");
        
        level.addPnj(pnj1);
        
        /*les Monstres*/
        Minotaur m13 = new Minotaur();
        Minotaur m14 = new Minotaur();
        Minotaur m15 = new Minotaur();
        Minotaur m16 = new Minotaur();
        Minotaur m17 = new Minotaur();
        Minotaur m18 = new Minotaur();
        Minotaur m19 = new Minotaur();
        Minotaur m20 = new Minotaur();
        Minotaur m21 = new Minotaur();
        Minotaur m22 = new Minotaur();
        
        level.addPnj(m13);
        level.addPnj(m14);
        level.addPnj(m15);
        level.addPnj(m16);
        level.addPnj(m17);
        level.addPnj(m18);
        level.addPnj(m19);
        level.addPnj(m20);
        level.addPnj(m21);
        level.addPnj(m22);
        
        /*les Items*/
        Sword s1 = new Sword();
        Sword s2 = new Sword();
        
        level.addItem(s1);
        level.addItem(s2);
        
        ScanUser su = new ScanUser(level);
        
        while(su.loopYet()) {
            su.readUser();
        }
        
        this.toGo(su.getWhereGo());
    }
            
    public void level5() {
        this.levelStartMessage(5);
        Place level = new Place("etage 5");
        level.addHero(this.hero);
        //Structure level_5
        
        /*les Exits*/
        QuestionExit qexit1 = new QuestionExit(1, "Pain chocolat ou chocolatine?\n1 - > Pain chocolat\n2 - > Chocolatine","level_4");
        Exit kexit2 = new Exit("level_3"); 
        level.addExit(qexit1);
        level.addExit(kexit2);
        
        /*les Pnj*/
        OtherCharacter pnj1 = new OtherCharacter("Guide", "Vous y etes presque, courage");
        OtherCharacter pnj2 = new OtherCharacter("Enfant", "Y a un marchand au level_3 si vous manquez de ressources");
        
        level.addPnj(pnj1);
        level.addPnj(pnj2);
        
        /*les Monstres*/
        Gargoyle m1 = new Gargoyle();
        Gargoyle m2 = new Gargoyle();
        Gargoyle m3 = new Gargoyle();
        Gargoyle m4 = new Gargoyle();
        Gargoyle m5 = new Gargoyle();
        Gargoyle m6 = new Gargoyle();
        Gargoyle m7 = new Gargoyle();
        Gargoyle m8 = new Gargoyle();
        Gobelin m9 = new Gobelin();
        Gobelin m10 = new Gobelin();
        Gobelin m11 = new Gobelin();
        Gobelin m12 = new Gobelin();
        Minotaur m13 = new Minotaur();
        Minotaur m14 = new Minotaur();
        Minotaur m15 = new Minotaur();
        Minotaur m16 = new Minotaur();
        Minotaur m17 = new Minotaur();
        Minotaur m18 = new Minotaur();
        Minotaur m19 = new Minotaur();
        Minotaur m20 = new Minotaur();
        Minotaur m21 = new Minotaur();
        Minotaur m22 = new Minotaur();
        
        level.addPnj(m1);
        level.addPnj(m2);
        level.addPnj(m3);
        level.addPnj(m4);
        level.addPnj(m5);
        level.addPnj(m6);
        level.addPnj(m7);
        level.addPnj(m8);
        level.addPnj(m9);
        level.addPnj(m10);
        level.addPnj(m11);
        level.addPnj(m12);
        level.addPnj(m13);
        level.addPnj(m14);
        level.addPnj(m15);
        level.addPnj(m16);
        level.addPnj(m17);
        level.addPnj(m18);
        level.addPnj(m19);
        level.addPnj(m20);
        level.addPnj(m21);
        level.addPnj(m22);
         
        /*les Items*/
        ExitKey ekey1 = new ExitKey();
        
        level.addItem(ekey1);
        
        
        ScanUser su = new ScanUser(level);
        
        while(su.loopYet()) {
            su.readUser();
        }
        
        this.toGo(su.getWhereGo());
    }
                
    public void level6() {
        this.levelStartMessage(6);
        Place level = new Place("etage 6");
        level.addHero(this.hero);
        //Structure level_6
        
        /*les Exits*/
        
        
        /*les Pnj*/
        Princess princess = new Princess();
        
        level.addPnj(princess);
        
        /*les Monstres*/
        Boss boss = new Boss();
        
        level.addPnj(boss);
        
        /*les Items*/
        
        
        ScanUser su = new ScanUser(level);
        
        while(su.loopYet()) {
            su.readUser();
        }
        
        this.toGo(su.getWhereGo());
    }
}
