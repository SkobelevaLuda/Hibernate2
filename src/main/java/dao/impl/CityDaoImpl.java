package dao.impl;

import dao.CityDao;
import dao.HibernateSessionFactoryUtil;
import model.City;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class CityDaoImpl implements CityDao {
    @Override
    public City create(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            //Serializable createdId = session.save(city);
           // City createdCity = session.get(City.class, createdId);
            session.saveOrUpdate(city);
            transaction.commit();
            return city;
        }

    }

    @Override
    public Optional<City> readById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(City.class, id));
        }
    }

    @Override
    public List<City> readAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM City ", City.class).list();
        }
    }

    @Override
    public City updateById(City city) {
        EntityManager entityManager = HibernateSessionFactoryUtil.getSessionFactory()
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        City updateById = entityManager.merge(city);
        entityTransaction.commit();
        return updateById;
    }

    @Override
    public Optional<City> deleteById(City city) {
        Optional<City> cityOptional = readById(city.getCityId());
        if (cityOptional.isPresent()){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(cityOptional.get());
                transaction.commit();
                return cityOptional;
            }
        }
        return Optional.empty();
    }
}


