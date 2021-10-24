package com.pet.mytasks.controllers;

import com.pet.mytasks.models.DAO.ModelDao;
import com.pet.mytasks.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/model")
public class RestModelController {

    @Autowired
    private ModelDao modelDao;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Model getModel (@PathVariable int id){
        try{
            return modelDao.findById(id).get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteModel(@PathVariable int id){
        try{
            modelDao.deleteById(id);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    @PutMapping(produces = "application/json")
    public void createModel(@RequestBody Model model){
        try{
            modelDao.save(model);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }
}
