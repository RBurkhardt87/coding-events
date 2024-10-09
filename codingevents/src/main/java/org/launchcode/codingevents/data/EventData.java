package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    //Class is used to store data, static methods and properties
    //Point of how Event objects are stored
    //We are encapsulating the behavior of how event objects are stored so no one else needs to know

    //TODO: need a place to put event (data structure of some type)
    //We need a place to keep the event. It is static, which means there will only be one
    //Map is an interface that allows you to do key/value pairs. We want to code to interfaces whenever we can
    //We could make it a HashMap, but it is a little better to make it a Map instead
    //Integers will be the IDs and Events will be event objects
    //BY MAKING IT FINAL IT MEANS THE MAP ITSELF CAN'T CHANGE, BUT DOESN'T MEAN THE DATA INSIDE IT CAN'T CHANGE <--- So if we try to change the collection we will get an error
    private static final Map<Integer, Event> events = new HashMap<>();

    //TODO: app should be able to get all events
    //The Map interface allows us to use .values() and just return all the values in the key/value pairs
    //Collection is an interface that extends the Iterable interface (behaviors that has behaviors of looping over a collection)
    public static Collection<Event> getAll(){
        return events.values();
    }

    //TODO: app should be able to get a single event
    //Here we will return the event value for the id that is passed in
    public static Event getById(int id){
        return events.get(id);
    }


    //TODO: app should be able to "add" an event
    //we are putting the id as the integer (key) and the event as the value
    public static void add(Event event) {
        events.put(event.getId(), event);
    }

    //TODO: app should be able to "delete/remove" an event
    //This will remove the event with the id that is passed
    public static void remove(int id){
        events.remove(id);
    }



}
