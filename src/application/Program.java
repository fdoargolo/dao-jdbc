package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Will you make changes in the Seller table or Department table? (S/D)");
		char answer = scanner.next().toUpperCase().charAt(0);
		
		while (answer != 'S' && answer != 'D') {
			System.out.println("Try again: (S/D)");
			answer = scanner.next().toUpperCase().charAt(0);
		}
		
		if (answer == 'S') {
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

			System.out.println();
			System.out.println("---TEST 3: seller findAll----");
			list = sellerDao.findAll();
			for (Seller obj : list) {
				System.out.println(obj);
			}

			System.out.println();
			System.out.println("---TEST 4: seller insert----");
			Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
			sellerDao.insert(newSeller);
			System.out.println("Inserted! New Id = " + newSeller.getId());

			System.out.println();
			System.out.println("---TEST 5: seller update----");
			seller = sellerDao.findById(1);
			seller.setName("Mariana");
			sellerDao.update(seller);
			System.out.println("Update completed!");

			System.out.println();
			System.out.println("---TEST 6: seller delete (by id)----");
			System.out.print("Enter the id: ");
			int deleteId = scanner.nextInt();
			sellerDao.deleteById(deleteId);
			System.out.println("Deleted!");
		} else if (answer == 'D') {
		    DepartmentDao depDao = DaoFactory.createDepartmentDao();
	
		    System.out.println();
		    System.out.println("---TEST 7: department insert----");
		    System.out.print("Enter the new Department Name:");
		    scanner.nextLine(); 
		    String depName = scanner.nextLine();
		    System.out.print("Enter the new Department Id:");
		    int depId = scanner.nextInt();
		    Department newDep = new Department(depId, depName);
		    depDao.insert(newDep);
		    System.out.println("Inserted! New dep: " + newDep.toString());

		    System.out.println("---TEST 8: department update----");
		    System.out.print("Enter the department id: ");
		    depId = scanner.nextInt();
		    scanner.nextLine();
		    System.out.print("Enter the new department name: ");
		    depName = scanner.nextLine();
		    Department updateDep = depDao.findById(depId);

		    updateDep.setName(depName);
		    depDao.update(updateDep);
		    
		    System.out.println("---TEST 9: department deleteById----");
		    System.out.print("Enter the department id to delete: ");
		    depId = scanner.nextInt();
		    scanner.nextLine();
		    System.out.println("Deleting department " + depDao.findById(depId));
		    depDao.deleteById(depId);
		    System.out.println("DELETED SUCCESFULLY!");
		    
		    System.out.println("---TEST 10: department findById----");
		    System.out.print("Enter the department id find: ");
		    depId = scanner.nextInt();
		    System.out.println(depDao.findById(depId));
		    System.out.println();
		    System.out.println("---TEST 10: department findAll----");
		    System.out.println(depDao.findAll());
		    System.out.println();
		    
		} else {
			System.out.println("You can choose just");
		}

		scanner.close();

	}

}
