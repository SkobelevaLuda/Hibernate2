package dao;

import model.City;
import model.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {
    City create(City city);

    Optional<City> readById(long id);
    List<City> findAll();
    City update(City city);
    Optional<City> delete(City city);
}