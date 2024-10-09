package org.launchcode.codingevents.controllers;


import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

  //TODO: MODEL BINDING:::::


  @GetMapping
    public String displayEvents(Model model){
      model.addAttribute("title", "All Events");
      model.addAttribute("events", EventData.getAll());
      return "events/index";

  }

  //lives at /events/create
  @GetMapping("create")
  public String displayCreateEventForm(Model model){
    model.addAttribute("title", "Create Event");
    return "events/create";
  }


  //TODO: Replace the @RequestParam for eventName and eventDescription to be... @ModelAttribute Event newEvent
  //It will look at the request data and look for fields that match the identifiers
  //We can then just add an event by doing .add(newEvent)   Spring will do the work and create event for us because of the @ModelAttribute
  @PostMapping("create")
  public String processCreateEventForm(@ModelAttribute Event newEvent){
    EventData.add(newEvent);
    return "redirect:/events";
  }



  @GetMapping("delete")
  public String displayDeleteEventForm(Model model){
    model.addAttribute("title", "Delete Events");
    model.addAttribute("events", EventData.getAll());
    return "events/delete";
  }



  @PostMapping("delete")
  public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds){

    if (eventIds != null) {
      for (int id : eventIds) {
        EventData.remove(id);
      }
    }
      return "redirect:/events";
  }



  //TODO: Create a method to display an edit form
  //PathVariable---> the eventId param goes inside {}
  @GetMapping("edit/{eventId}")
  public String displayEditForm(Model model, @PathVariable int eventId) {
    Event eventToEdit = EventData.getById(eventId);
    model.addAttribute("event", eventToEdit);
    String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
    model.addAttribute("title", title);
    return "/events/edit";
  }

  //TODO: Create a method to process the Edit Form
  //Here we are using setters to set the args passed in as the values of the fields of the event
  @PostMapping("edit")
  public String processEditForm(int eventId, String name, String description) {
    Event eventToEdit = EventData.getById(eventId);
    eventToEdit.setName(name);
    eventToEdit.setDescription(description);
    return "redirect:/events";
  }

  //Get Handlers typically display the forms and the Post Handlers are going to process the forms
}
