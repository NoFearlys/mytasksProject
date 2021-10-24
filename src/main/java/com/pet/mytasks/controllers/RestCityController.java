package com.pet.mytasks.controllers;

import com.pet.mytasks.models.City;
import com.pet.mytasks.models.DAO.CityDao;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/city")
public class RestCityController {

    @Autowired
    private CityDao cityDao;

    @GetMapping(value = "/{id}", produces = "application/json")
    public City getCity (@PathVariable int id){
        try{
            return cityDao.findById(id).get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteCity(@PathVariable int id){
        try{
            cityDao.deleteById(id);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    @PutMapping(produces = "application/json")
    public void createCity(@RequestBody City city){
        try{
            cityDao.save(city);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }
}