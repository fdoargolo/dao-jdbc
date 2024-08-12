package application;

import java.util.Date;
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
		
		System.out.println();
		System.out.println("---TEST 3: seller findAll----");
		list = sellerDao.findAll();		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("---TEST 4: seller insert----");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0 , department);
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
		
		scanner.close();
		
		
	}

}
