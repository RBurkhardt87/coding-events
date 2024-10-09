package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event {

    //TODO: create unique id property
    private int id;

    //TODO: create a nextId -- nextId is declared static, therefore, every single object of Event will share it
    //By initializing to 1, that means the first object will get the id of #1. And then we will update the nextId inside the constructor
    //so that, with every object the nextId will go up by one. And they will all have access to this increase because it is static and belongs to the class
    //   this.id = nextId   (says that every object gets a unique id based off the nextId)          nextId++ (will increment the id number by 1 with each new object)
    //IF NEXTID WASN'T STATIC THEN THE UPDATED ID# WOULD NOT WORK. EVERY OBJECT WOULD BE ID#1
    private static int nextId = 1;

    //TODO:fields
    private String name;
    private String description;


    //TODO:constructor
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextId;
        nextId++;
    }

    //TODO:getter-name
    public String getName() {
        return name;
    }

    //TODO:setter-name
    public void setName(String name) {
        this.name = name;
    }

    //TODO:getter-description
    public String getDescription() {
        return description;
    }

    //TODO:setter-description
    public void setDescription(String description) {
        this.description = description;
    }

    //TODO: ONLY make a getter for id. We want to access the value, but never change it.
    //and we don't need a getter or setter for nextId because we are just using it in the constructor to help create a unique id for each object of the class
    public int getId() {
        return id;
    }

    //TODO:toString method
    @Override
    public String toString() {
        return name;
    }

    //TODO: create equals and hashcode methods based on id ONLY
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
