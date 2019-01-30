package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> listEmp = new ArrayList<Employee>();
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("\nEmployee #" + i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			listEmp.add(new Employee(id, name, salary));
		}

		// Minha lógica
/**/		
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int checkID = sc.nextInt();
		List<Employee> result = listEmp.stream().filter(x -> x.getId() == checkID).collect(Collectors.toList());
		if (!result.isEmpty()) {
			System.out.print("Enter the percentage: ");
			double perc = sc.nextDouble() / 100;
			int index = listEmp.indexOf(result.get(0));
			listEmp.get(index).aumento(perc);
			System.out.println("\nList of employees:");

			for (Employee e : listEmp) {
				System.out.println(e);
			}
		} else {
			System.out.println("Não existe o id informado!");
		}
/**/
		// Lógica do professor
		// PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:
/*
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

		// PART 3 - LISTING EMPLOYEES:

		System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : list) {
			System.out.println(obj);
		}
*/
		sc.close();
	}

}
