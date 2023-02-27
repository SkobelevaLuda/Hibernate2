package dao.impl;

import dao.CityDao;
import dao.HibernateSessionFactoryUtil;
import model.City;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class CityDaoImpl implements CityDao {
    @Override
    public City create(City city) {
        return null;
    }

    @Override
    public Optional<City> readById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(City.class, id));
        }
    }

    @Override
    public List<City> readAll() {
        return null;
    }

    @Override
    public City updateById(City city) {
        return null;
    }

    @Override
    public Optional<City> deleteById(City city) {
        return Optional.empty();
    }
}


