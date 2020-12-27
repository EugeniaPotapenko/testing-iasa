/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.potapenko.java_tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author Asus
 */
public class Task4 {
    public ArrayList<Integer> L;
    public Stream<Integer> ST;
    public Integer pos;
    public Integer target;
    public Map<Integer,Integer> M;
    
    public Task4(List<Integer> arg){
    L = new ArrayList<>(arg);
    M = new HashMap<>() {};
    }
    public void getTargetStream(Integer t){
        target=t;
        M.clear();
        System.out.println("Stream");
        ST = L.stream().parallel();
        pos=0;
        ST.forEach(p -> searshPairStream(p));
        printresult();
    }
    
    public void getTarget(Integer t){
        pos=0;
        target=t;
        M.clear();
    for(Integer i1: L){
        pos++;
        if(i1>t) continue;
        searshPair(i1);
        }
    printresult();
    }
    public void searshPair(Integer v){
    for(Integer i=pos; i<L.size();i++)
        if((v+L.get(i))==target) M.put(i,pos-1);
    }
    public void searshPairStream(Integer v){
     pos++;
     for(Integer i=pos; i<L.size();i++)
        if((v+L.get(i))==target) M.put(i,pos-1);
    }
    public void addPair(Integer it1,Integer it2){
    if((it1+it2)==target) System.out.println(it1+"-"+it2);
    }
    
    public void printresult(){
    for(Map.Entry m: M.entrySet()){
    System.out.println(L.get((int) m.getValue())+" , "+L.get((int) m.getKey()));
    }
    }
}
