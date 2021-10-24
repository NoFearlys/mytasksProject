package com.pet.mytasks.controllers;


import com.pet.mytasks.models.DAO.TaskDao;
import com.pet.mytasks.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task")
public class RestTaskController {

    @Autowired
    private TaskDao TaskDao;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Task getTask (@PathVariable int id){
        try{
            return TaskDao.findById(id).get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteTask(@PathVariable int id){
        try{
            TaskDao.deleteById(id);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    @PutMapping(produces = "application/json")
    public void createTask(@RequestBody Task task){
        try{
            TaskDao.save(task);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }
}
