package com.example.java8inaction.entity;

import java.util.Arrays;
import java.util.List;

/**
 * @author: slm
 */
public class Trader{

   static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario","Milan");
   static Trader alan = new Trader("Alan","Cambridge");
   static Trader brian = new Trader("Brian","Cambridge");
   public static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
