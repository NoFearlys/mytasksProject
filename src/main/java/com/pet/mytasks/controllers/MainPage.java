package com.pet.mytasks.controllers;

import com.pet.mytasks.models.Client;
import com.pet.mytasks.models.DAO.ClientDao;
import com.pet.mytasks.models.DAO.ModelDao;
import com.pet.mytasks.models.DAO.TaskDao;
import com.pet.mytasks.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MainPage {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ModelDao modelDao;

    @GetMapping("/")
    public String index(Model model){
        List<Task> tasks = taskDao.findAll();
        List<Client> clients = clientDao.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("clients", clients);
        return "index";
    }


    @GetMapping("/addClient")
    public String client(Model model){
        Client client = clientDao.getOne(1);
        model.addAttribute("client", client);
        return "addClient";
    }

    @GetMapping("/model{id}")
    public String model(Model model, int id){
        com.pet.mytasks.models.Model apparatModel = modelDao.getOne(id);
        model.addAttribute("apparatModel", apparatModel);
        return "model";
    }
}
