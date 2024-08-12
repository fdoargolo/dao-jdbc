package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("---TEST 1: seller findById----");
		System.out.print("Enter the Id: ");
		int id = scanner.nextInt();

		Seller seller = sellerDao.findById(id);
		System.out.println(seller);

		System.out.println();
		System.out.println("---TEST 2: seller findByDepartment----");
		System.out.print("Enter the department: ");
		int dep = scanner.nextInt();
		Department department = new Department(dep, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		scanner.close();
	}

}
