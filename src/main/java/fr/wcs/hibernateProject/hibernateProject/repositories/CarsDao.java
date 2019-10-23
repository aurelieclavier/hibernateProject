package fr.wcs.hibernateProject.hibernateProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.wcs.hibernateProject.hibernateProject.entities.Cars;

@Repository
public interface CarsDao extends JpaRepository<Cars, Long> {

}
