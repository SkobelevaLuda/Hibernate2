import dao.CityDao;
import dao.EmployeeDao;
import dao.impl.CityDaoImpl;
import dao.impl.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        CityDao cityDao = new CityDaoImpl();
        int n = 5;
        City krasnodar = new City(5, "Краснодар");
        cityDao.create(krasnodar);
        List<Employee> employees = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            employees.add(new Employee("Вася " + (i + 2), "Федоров" + (i + 1), "муж", 30 + i,
                    krasnodar));
        }
        krasnodar.setEmployees(employees);
        cityDao.delete(krasnodar);
    }


}
