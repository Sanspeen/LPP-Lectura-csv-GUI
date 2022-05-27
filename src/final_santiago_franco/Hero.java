/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_santiago_franco;

/**
 *
 * @author User
 */
public class Hero implements isStrong{
    private String name;
    private int healthPoints;
    private int resistencePoints;
    private int atackPoints;
    private int defensePoints;
    private int accuracyPoints;
    private int escapePoints;
    private int total;

    public Hero(String name, int healthPoints, int resistencePoints, int atackPoints, int defensePoints, int accuracyPoints, int escapePoints,int total) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.resistencePoints = resistencePoints;
        this.atackPoints = atackPoints;
        this.defensePoints = defensePoints;
        this.accuracyPoints = accuracyPoints;
        this.escapePoints = escapePoints;
        this.total = total;
    }
    
    public Hero() {
    }

    public int getEscapePoints() {
        return escapePoints;
    }

    public void setEscapePoints(int escapePoints) {
        this.escapePoints = escapePoints;
    }

    public int getAccuracyPoints() {
        return accuracyPoints;
    }

    public void setAccuracyPoints(int accuracyPoints) {
        this.accuracyPoints = accuracyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getResistencePoints() {
        return resistencePoints;
    }

    public void setResistencePoints(int resistencePoints) {
        this.resistencePoints = resistencePoints;
    }

    public int getAtackPoints() {
        return atackPoints;
    }

    public void setAtackPoints(int atackPoints) {
        this.atackPoints = atackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public boolean isStrong() {
        
        if(this.total > 18){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    
}
