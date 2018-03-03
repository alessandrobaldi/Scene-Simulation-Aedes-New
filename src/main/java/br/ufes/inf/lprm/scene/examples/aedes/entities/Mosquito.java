/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.inf.lprm.scene.examples.aedes.entities;

/**
 *
 * @author alessandro
 */
public class Mosquito {
   private int days = 0;
   private boolean controlfly = false;
   private boolean controleggs = false;

    

    public int getDays() {
        return days;
    }

    public boolean isControlfly() {
        return controlfly;
    }

    public void setControlfly(boolean controlfly) {
        this.controlfly = controlfly;
    }

    public boolean isControleggs() {
        return controleggs;
    }

    public void setControleggs(boolean controleggs) {
        this.controleggs = controleggs;
    }

    public void setDays(int days) {
        this.days = days;
    }
   
}
