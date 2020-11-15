package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        List<Seller> list = new ArrayList<>();

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
    }
}
