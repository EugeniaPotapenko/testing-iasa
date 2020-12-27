/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.potapenko.java_tasks;
//import java.lang.Object;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewMain NM = new NewMain();
        // TODO code application logic here
        System.out.println("Start Task 1:");
        NM.getInterersFromList(Arrays.asList(1,2,"a","b"));
        System.out.println("Finish Task.");
        /*---------------------------------*/
        System.out.println("Start Task 2:");
        NM.first_non_repeating_letter("sTreSS");
        System.out.println("Finish Task.");
        /*---------------------------------*/
        System.out.println("Start Task 3:");
        NM.show_digital_root(79123);
        System.out.println("Finish Task.");
        /*---------------------------------*/
        System.out.println("Start Task 4:");
        Task4 T4 = new Task4(Arrays.asList(1,3,6,2,2,0,4,5));
        T4.getTarget(5);
        //T4.getTargetStream(5);
        System.out.println("Finish Task.");
        /*---------------------------------*/
        System.out.println("Start Task 5:");
        Task5 T5= new Task5("Fred:Corwill;Wilfred:Corwill;Barny:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Affred:Corwill");
        T5.ShowFriends();
        System.out.println("Finish Task.");
       
        System.out.println("Start Task 1 Ext:");
        System.out.println(NM.nextBiggest(12));
        System.out.println(NM.nextBiggest(513));
        System.out.println(NM.nextBiggest(2017));
        System.out.println(NM.nextBiggest(1111));
    }
 //public void getInterersFromList(Object [] args){
 
    public void getInterersFromList(List<Object> args) {
        System.out.print("{");
        boolean coma=false;
        for (Object o : args) {
            if( Integer.class == o.getClass()) {
                if(coma) System.out.print(",");
                System.out.print(o);
                coma=true;
            }
        }
        System.out.println("}");
    }
    public void first_non_repeating_letter(String s){
        //int lastIndexOf = s.lastIndexOf(s.charAt(0));
        System.out.print(s);
        String varS = s.toUpperCase();
        for(int i=0;i<varS.length();i++){
        if(i==varS.lastIndexOf(varS.charAt(i))) {
            System.out.println(" --> "+s.charAt(i));
            return;
        }
        }
        
    }
     public void show_digital_root(Integer val){
     System.out.print(val);
     digital_root(val);
     System.out.println();
     }
    
    public void digital_root(Integer val){
    if(val<10) return;
    System.out.print("-->");
    List<Integer> L = new ArrayList<>();
    while(val>0){
        int i = val%10;
        L.add(i); 
        val = val / 10;
        }
     for (Integer it=L.size()-1;it>-1;it--){
         System.out.print(L.get(it));
         if(it>0)System.out.print("+");
         val+=L.get(it);
     }
    System.out.print(" = "+val+"  ");
    if(val>9)digital_root(val);
    }  
    public Integer nextBiggest(Integer val){
        System.out.print(val+" --> ");
    if(val<12) return -1;
    List<Integer> L = new ArrayList<>();
    Integer p=10;
    Integer accum;
    Integer r;
    accum=val;
    while(accum > 0){
        r=accum%p;
        accum/=p;
        L.add(r);
    }
    boolean ch=false;
    for(int i=0; i<L.size()-1;i++){
        if(L.get(i)>L.get(i+1)){
            Integer M = L.get(i);
            L.set(i,L.get(i+1));
            L.set(i+1,M);
            ch=true;
            }
        if(ch)break;
        }
    p=1;accum=0;
    for(int i=0; i<L.size();i++){
        accum+=(L.get(i)*p);
        p*=10;
    }
    //System.out.println(L);
    if(ch) return accum;
        else return -1;
    }
    //extra task 1
    static int NextBiggerNumber(int number) {

        int size = getCountsOfDigits(number);
        Integer[] numbers = new Integer[size];
        boolean Swaped = false;
        for (int i = numbers.length - 1; i >= 0; i--) {
            numbers[i] = number%10;
            number /=10;
        }

        for (int i = 0; i + 1 < numbers.length; i++) {
            if (numbers[i] < numbers[i + 1] ) {
                var temp = numbers[i + 1];
                numbers[i + 1] = numbers[i];
                numbers[i] = temp;
                Swaped = true;
                break;
            }
        }
        if (Swaped) {
            int result = 0;
            for (int i = 0; i < numbers.length; i++ ) {
                result *= 10;
                result += numbers[i];
            }
            return result;
        } else {
            return -1;
        }
    }
}
}
