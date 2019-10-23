package fr.wcs.hibernateProject.hibernateProject.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import fr.wcs.hibernateProject.hibernateProject.entities.Cars;
import fr.wcs.hibernateProject.hibernateProject.repositories.CarsDao;

@Component
public class Output implements CommandLineRunner {

	private Logger LOG = LoggerFactory.getLogger("car");
	
	@Autowired
	private CarsDao carDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Check nb cars in DB
		LOG.info("************************************************************");
		LOG.info("Cars in DB : " + carDao.count());
		
		// Create new car
		LOG.info("************************************************************");
		Cars carNew = new Cars("Delorean Motor Car", "Silver", 400000);
		LOG.info(carNew + " has been added in DB !");
		carDao.save(carNew);
		LOG.info(carNew + " has been saved !");
		
		// Add an other car
		LOG.info("************************************************************");
		Cars newCar = new Cars("Ford Mustang", "Blue", 140000);
		LOG.info(newCar + " has been added in DB !");
		carDao.save(newCar);
		LOG.info(newCar + " has been saved !");
		
		// Read all car in DB
		LOG.info("************************************************************");
		LOG.info("Your garage cars list");
		for(Cars car : carDao.findAll()) {
			LOG.info(car.toString());
		};

		// Update car
		LOG.info("************************************************************");
		Cars carUpdate = carDao.findById(1L).get();
		LOG.info("You drove too much !");
		carUpdate.setKilometers(5678901);
		carDao.save(carUpdate);
		
		// Delete car
		LOG.info("************************************************************");
		Cars carBroke = carDao.findById(2L).get();
		LOG.info("AOUTCH ! You broke the " +  carBroke.getBrand());
		carDao.deleteById(2L);
		
		// Return the remaining cars
		LOG.info("************************************************************");
		LOG.info("Your garage cars list");
		for(Cars car : carDao.findAll()) {
			LOG.info(car.toString());
		};

	}
	
}
