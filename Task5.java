/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.potapenko.java_tasks;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Asus
 */

public class Task5 {

   
public class Person implements Comparable<Person>{
    public Person(String arg){
    String[] S = arg.split(":");
    FistName = S[0];
    SurName = S[1];
    }
     @Override
    public int compareTo(Person p) {
        int i = this.SurName.compareTo(p.SurName);
        if(i==0) return this.FistName.compareTo(p.FistName);
            else return i;
    }
    public String asString(){return FistName+" : "+SurName;}
    public String FistName;
    public String SurName;
    }

public ArrayList<Person> Friends;
public Task5(String arg){
    String[] s = arg.split(";");
    Friends = new ArrayList();
    for(String L:s) Friends.add(new Person(L));
}
public void ShowFriends(){
    Collections.sort(Friends);
    Friends.forEach((p) -> {
        System.out.println(p.asString());
    });
}

}
