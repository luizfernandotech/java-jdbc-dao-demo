package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        List<Seller> list = null;

        System.out.println("==== Exemple 1 - Department Manual Instance ====");
        Department dep = new Department(1, "Books");
        System.out.println(dep);

        System.out.println("\n==== Exemple 2 - Seller Manual Instance ====");
        Seller seller = new Seller(21, "Bob", "bob@email.com", new Date(), 3000.0, dep);
        System.out.println(seller);

        System.out.println("\n==== Exemple 3 - Seller findById ====");
        seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== Exemple 4 - Seller findByDepartment ====");
        Department department = new Department(2, null);
        list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n==== Exemple 5 - Seller findAll ====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n==== Exemple 6 - Seller insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@email.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id: " + newSeller.getId());

        System.out.println("\n==== Exemple 7 - Seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Roberto Carlos");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n==== Exemple 8 - Seller delete ====");
        System.out.println("Enter the ID to delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
