import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import model.City;
import model.Employee;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        City tula= new City(3,"Тула");
        City kaluga = new City(4, "Калуга");

        Employee manua = employeeDao.create(new Employee("Маня", "Федотова","жен", 22));
        System.out.println("Добавлен сотрудник" + manua);
        Employee vika = employeeDao.create(new Employee("Вика", "Сидорова","жен", 25));
        System.out.println("Добавлен сотрудник" + vika);

        System.out.println( "Все сотрудники ");
        employeeDao.readAll().forEach(System.out::println);

        employeeDao.readById(vika.getId())
                .ifPresent(employee -> System.out.println("Найден сотрудник " + employee));

        vika.setName("Катя");
        vika.setAge(45);
        vika = employeeDao.updateById(vika);
        System.out.println("Обновленный сотрудник " + vika);

        employeeDao.deleteById(manua).ifPresent(employee -> System.out.println("Удаленный сотрудник: " +employee));

        System.out.println("Все сотрудники");
        employeeDao.readAll().forEach(System.out::println);

    }

}
