

import beans.Product;
import dao.AbstractDao;
import dao.ProductDao;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


public class AbstractDaoTest {
    @Test
    public void create() {
        Product product = new Product();
        product.setProductName("JavaProduct");
        product.setQuantityProduct(1);
        product.setPrice(9999);
        AbstractDao<Product> productAbstractDao = new ProductDao();
        productAbstractDao.create(product);
    }

   @Test
   public void read() {
       AbstractDao<Product> productAbstractDao = new ProductDao();
       Product product = productAbstractDao.read(14);
       System.out.println(product);
       assertNotNull(product);
   }

    @Test
    public void delete() {
        AbstractDao<Product> pl = new ProductDao();
        pl.delete(9);
        assertNotNull(pl);

    }

    @Test
    public void update() {

        AbstractDao<Product> pl = new ProductDao();
        Product product = pl.read(1);
        product.setQuantityProduct(12);
        pl.update(product);
    }

    @Test
    public void getAll() {
        AbstractDao<Product> productAbstractDao = new ProductDao();
        System.out.println(productAbstractDao.getAll());
    }
}
