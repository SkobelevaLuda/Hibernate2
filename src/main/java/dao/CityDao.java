package dao;

import model.City;
import model.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {
    City create(City city);

    Optional<City> readById(long id);

    List<City> readAll();

    City updateById(City city);

    Optional<City> deleteById(City city);
}