package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
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
		scanner.close();
	}

}
