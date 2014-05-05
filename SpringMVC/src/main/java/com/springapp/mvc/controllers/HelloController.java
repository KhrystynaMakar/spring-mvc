package com.springapp.mvc.controllers;

import com.springapp.mvc.entity.Fruit;
import com.springapp.mvc.repo.RepoFruit;
import com.springapp.mvc.repo.RepoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private RepoFruit repoFruit;

    @Autowired
    private RepoOrder repoOrder;

    @PostConstruct
    private void postConstruct(){
        System.out.println("debug line");
    }

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String printList(ModelMap model) {
        try {
            ArrayList<Fruit> fruits = repoFruit.showAll();
            model.addAttribute("fruitsList", fruits);
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("message", "Selecting error.");
            return "Error";
        }
        return "list";
	}

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
            model.addAttribute("message", "Welcome!");
        return "welcome";
    }

    @RequestMapping(value="/update/{iID}", method = RequestMethod.GET)
    public String edit(ModelMap model, @PathVariable("iID") int iID) {
        try {
            Fruit fruit = repoFruit.findOne(iID);
            model.addAttribute("fruit", fruit);
        } catch (SQLException e) {
            model.addAttribute("message", "Updating error.");
            return "error";
        }
        return "update";
    }

    @RequestMapping(value="/update/{iID}", method = RequestMethod.POST)
    public String edit1(ModelMap model, Fruit fruit){
        try {
            repoFruit.update(fruit);
            model.addAttribute("fruit", fruit);
        } catch (SQLException e) {
            model.addAttribute("message", "Updating error.");
            return "error";
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ModelMap model, Fruit fruit){
        try {
            int iID = repoFruit.save(fruit);
            fruit.setiID(iID);
            model.addAttribute("fruit", fruit);
        } catch (SQLException e) {
            model.addAttribute("message", "Adding error.");
            return "error";
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model){
        Fruit fruit = new Fruit();
        model.addAttribute("fruit", fruit);
        return "createNew";
    }

    @RequestMapping("/delete/{iID}")
    public String deleteCar(@PathVariable("iID") int iID, ModelMap model){
        try {
            repoFruit.delete(iID);
            printList(model);
        } catch (SQLException e) {
            model.addAttribute("message", "Deleting error.");
            return "Error";
        }
        return "list";
    }

}