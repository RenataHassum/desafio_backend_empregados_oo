package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();

		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefone: ");
		String phone = sc.next();

		Address address = new Address(email, phone);
		Department department = new Department(departmentName, payDay, address);

		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("Dados do funcionário %d: \n", i + 1);

			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salário: ");
			double salary = sc.nextDouble();

			Employee employees = new Employee(name, salary);
			department.addEmployee(employees);
		}

		showReport(department);

		sc.close();
	}

	private static void showReport(Department department) {

		System.out.println("\nFOLHA DE PAGAMENTO: ");
		System.out.printf("Departamento %s = R$ %.2f\n", department.getName(), department.payroll());
		System.out.printf("Pagamento realizado no dia %d\n", department.getPayDay());
		System.out.println("Funcionários: ");

		for (Employee emp : department.getEmployees()) {
			System.out.println(emp.getName());
		}

		System.out.printf("Para dúvidas favor entrar em contato: %s", department.getAddress().getEmail());

	}
}
