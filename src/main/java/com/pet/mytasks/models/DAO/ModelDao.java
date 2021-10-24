package com.pet.mytasks.models.DAO;

import com.pet.mytasks.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelDao  extends JpaRepository<Model, Integer> {

    List<Model> findByVersion(String version);

    List<Model> findByName(String name);

}

