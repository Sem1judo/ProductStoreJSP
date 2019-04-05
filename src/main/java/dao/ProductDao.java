package dao;

import beans.Product;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDao<Product> {

    @Override
    public String getCreateQuery() {
        return "{call addProduct(?,?,?)}";
    }

    @Override
    public String getSelectQuery() {
        return "select *from products";
    }

    @Override
    public String getDeleteQuery() {
        return "{call deleteProduct(?)}";
    }

    @Override
    public String getUpdateQuery() {
        return "{call updateProduct(?,?,?,?,?)}";
    }

    @Override
    public String getSelectByQuery() {
        return "{call readProduct(?,?,?,?,?)}";
    }

    @Override
    public Product getUserFromCS(int id, CallableStatement cs) {
        Product someProduct = null;
        try {
            someProduct = new Product();
            someProduct.setId(id);
            someProduct.setProductName(cs.getString(2));
            someProduct.setQuantityProduct(cs.getInt(3));
            someProduct.setPrice(cs.getDouble(4));
            someProduct.setExpiredDate(cs.getTimestamp(5).toLocalDateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return someProduct;
    }

    @Override
    public void setCSParam(CallableStatement cs) {
        try {
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4, Types.DOUBLE);
            cs.registerOutParameter(5, Types.TIMESTAMP);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setCS(CallableStatement cs, Product product) {
        try {
            cs.setString(1, product.getProductName());
            cs.setInt(2, product.getQuantityProduct());
            cs.setDouble(3, product.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void setUpdateCS(CallableStatement cs, Product product) {
        try {
            cs.setInt(1, product.getId());
            cs.setString(2, product.getProductName());
            cs.setInt(3, product.getQuantityProduct());
            cs.setDouble(4, product.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> parseRS(ResultSet resultSet) {
        List<Product> products = new ArrayList<>();
        try {

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("productName"));
                product.setQuantityProduct(resultSet.getInt("quantityProduct"));
                product.setPrice(resultSet.getDouble("price"));
//                product.setExpiredDate(resultSet.getTimestamp("expiredDate").toLocalDateTime());
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
