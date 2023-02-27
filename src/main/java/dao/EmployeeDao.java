package dao;

import model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    Employee create(Employee employee);

    Optional<Employee> readById(long id);

    List<Employee> readAll();

    Employee updateById(Employee employee);

    Optional<Employee> deleteById(Employee employee);
}

