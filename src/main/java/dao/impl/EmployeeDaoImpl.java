package dao.impl;
import dao.CityDao;
import dao.EmployeeDao;
import dao.HibernateSessionFactoryUtil;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private final CityDao cityDao = new CityDaoImpl();

    @Override
    public Employee create(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.saveOrUpdate(employee);
            transaction.commit();
            return employee;
        }
    }

    @Override
    public Employee readById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> readAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee ",
                    Employee.class).list();
        }
    }
    @Override
    public Employee updateById(Employee employee) {

        EntityManager entityManager = HibernateSessionFactoryUtil.getSessionFactory()
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Employee updateById = entityManager.merge(employee);
        entityTransaction.commit();
        return updateById;
    }

    @Override
    public void deleteById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
