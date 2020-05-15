package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i= 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data: ");
			System.out.print("Outourced (y/n)? ");
			char response = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hour = sc.nextInt();
			System.out.print("Value per hour: ");
			double value = sc.nextDouble();
			if(response =='y') {
				System.out.print("Additional charge: ");
				double additional = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hour, value, additional);
				list.add(emp);
			}
			else if (response == 'n') {
				Employee emp = new Employee(name, hour, value);
				list.add(emp);
			}
			System.out.println();
		}
		System.out.println("PAYMENTS:");
		for(Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
	}

}
