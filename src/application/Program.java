package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        System.out.println("==== Exemple 1 - Department Manual Instance ====");
        Department dep = new Department(1, "Books");
        System.out.println(dep);

        System.out.println("\n==== Exemple 2 - Seller Manual Instance ====");
        Seller seller = new Seller(21, "Bob", "bob@email.com", new Date(), 3000.0, dep);
        System.out.println(seller);

        System.out.println("\n==== Exemple 3 - Seller findById ====");
        SellerDao sellerDao = DaoFactory.createSellerDao();
        seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
