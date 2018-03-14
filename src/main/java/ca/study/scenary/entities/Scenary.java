/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.study.scenary.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alessandro
 */

public class Scenary {
    
    private List<House> scenary = new ArrayList<House>();
    int day = 0;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    int total;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void dayPassed() {
        this.day = day+1;
    }
    public List<House> getScenary() {
        return scenary;
    }
   
    public void setScenary(List<House> scenary) {
        this.scenary = scenary;
    }

    public Scenary(String houses, String linkedhouses, String houseswithtrap, String houseswithfocus, String houseswithmosquito, int totaldays) {
        //criar construtores das casas e dos links
        total=totaldays;
        String[] totalHouses = houses.split(",");
        String[] totalLinked = linkedhouses.split(",");
        String[] totalTrap = houseswithtrap.split(",");
        String[] totalFocus = houseswithfocus.split(",");
        String[] totalMosquito = houseswithmosquito.split(",");

        for (int create = 0; create < totalHouses.length; create++) {
            House newHouse = new House(totalHouses[create]);
            scenary.add(newHouse);
        }

        for (int create = 0; create < totalLinked.length; create++) {
            String link = totalLinked[create];
            String[] linkNow = link.split("-");
            House findone = scenary.get(0);
            House findtwo = scenary.get(0);
            for (int find = 0; find < totalHouses.length; find++) {
                if(scenary.get(find).getName().equals(linkNow[0]))
                {
                     findone=scenary.get(find);
                }
                if(scenary.get(find).getName().equals(linkNow[1]))
                {
                     findtwo=scenary.get(find);
                }
            }
            findone.addNeighborhood(findtwo);
            findtwo.addNeighborhood(findone);
        }

         for (int create = 0; create < totalTrap.length; create++) {
            String trap = totalTrap[create];
            for (int find = 0; find < totalHouses.length; find++) {
                if(scenary.get(find).getName().equals(trap))
                {
                    scenary.get(find).addTrap();
                }
            }
         }
         
            for (int create = 0; create < totalFocus.length; create++) {
            String focus = totalFocus[create];
            for (int find = 0; find < totalHouses.length; find++) {
                if(scenary.get(find).getName().equals(focus))
                {
                    scenary.get(find).addFocus();
                }
            }
         }
         
            for (int create = 0; create < totalMosquito.length; create++) {
            String mosquito = totalMosquito[create];
            //House houseMosquito = scenary.get(0);
            for (int find = 0; find < totalHouses.length; find++) {
                if(scenary.get(find).getName().equals(mosquito))
                {
                    scenary.get(find).addMosquito();
                }
            }
         }
    }

   

    public int randomize(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    

    public void clearDay() {
        this.day=this.day+1;
        System.out.println(day);
        for (int verifyingHouses = 0; verifyingHouses < this.scenary.size(); verifyingHouses++) {
            House inHouse = this.scenary.get(verifyingHouses);

            /*if (this.day % 15 == 0) {
                inHouse.setActivefocus(true);
                //System.out.println("Raining");
            }*///aqui tirei

            List<Mosquito> mosquitosInHouse = inHouse.getMosquitos();
            for (int verifyingMosquitos = mosquitosInHouse.size() - 1; verifyingMosquitos >= 0; verifyingMosquitos--) {
                Mosquito mosquitoInHouse = mosquitosInHouse.get(verifyingMosquitos);
                int dayMosquito = mosquitoInHouse.getDays();
                dayMosquito++;
                mosquitoInHouse.setDays(dayMosquito);
                mosquitoInHouse.setControlfly(false);
                mosquitoInHouse.setControleggs(false);
                /*if (dayMosquito == 38) {
                    mosquitosInHouse.remove(verifyingMosquitos);
                    //System.out.println("Mosquito has died");
                }*///aqui tirei
                //System.out.println("Mosquito new day");
            }

            List<Eggs> eggsInHouse = inHouse.getEggs();
            for (int verifyingEggs = eggsInHouse.size() - 1; verifyingEggs >= 0; verifyingEggs--) {
                Eggs eggInHouse = eggsInHouse.get(verifyingEggs);
                int dayEggs = eggInHouse.getDays();
                dayEggs++;
                eggInHouse.setDays(dayEggs);
                //System.out.println("Egg new day");
            }
        }
    }
    
    public void getStats()
    {
        int totalMosquitos = 0;
        int totalEggs = 0;
         for (int verifyingHouses = 0; verifyingHouses < this.scenary.size(); verifyingHouses++) {
         House verify = this.scenary.get(verifyingHouses);
         int mosquitosHere = verify.getMosquitos().size();
         int eggsHere= verify.getEggs().size();
         totalMosquitos=totalMosquitos+mosquitosHere;
         totalEggs=totalEggs+eggsHere;
         }
        System.out.println();
                System.out.println();
                System.out.println("Total: " + totalMosquitos + " mosquitos and "+ totalEggs + " eggs.");
                System.out.println("Days: " + this.day);
         
    }


}
