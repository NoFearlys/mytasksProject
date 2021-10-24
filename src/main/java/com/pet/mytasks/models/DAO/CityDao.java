package com.pet.mytasks.models.DAO;


import com.pet.mytasks.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityDao extends JpaRepository<City, Integer> {

    public List<City> findByName(String name);

}