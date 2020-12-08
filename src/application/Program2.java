package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department department2 = new Department(null,"Carmona");
		departmentDao.insert(department2);
		System.out.println("Inserted! New id = " + department2.getId());
		
		System.out.println("\n=== TEST 4: department update ===");
		department = departmentDao.findById(1);
		department.setName("Programação");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = entrada.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		entrada.close();
	}
}
