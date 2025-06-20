package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class ProductController {
    private static int idGenerator;
    private static List<Product> products = DataManager.getDataManager().getProduct();

    public static Product createProduct(String productName, String productDescription, double price, int stock, Category category, User loggedInUser) {
        if (isProductExists(productName) == null) {
            return null;
        }
        Product newProduct = new Product(++idGenerator, productName, productDescription, price, stock, category, (Seller) loggedInUser);
        products.add(newProduct);
        category.getProduct().add(newProduct);
        return newProduct;
    }

    public static boolean updateProduct(int id, String productName, String productDescription, double price, int stock) {
        Product product = isProductExist(id);
        if (product != null) {
            product.setProductName(productName);
            product.setDescription(productDescription);
            product.setPrice(price);
            product.setStock(stock);
            return true;
        }
        return false;
    }

    public static boolean removeProduct(Product product) {
        if (product != null) {
            products.remove(product);
            Category category = product.getCategory();
            if (category != null) {
                category.getProduct().remove(product);
                return true;
            }
        }
        return false;
    }

    public static Product isProductExist(int productId) {
        for (Product obj : products) {
            if (obj.getId() == productId) {
                return obj;
            }
        }
        return null;
    }

    public static Product isProductExists(String productName) {
        for (Product obj : products) {
            if (obj.getProductName().equals(productName)) {
                return obj;
            }
        }
        return null;
    }

    public static boolean removeProductByCategory(List<Product> productList) {
        if (!productList.isEmpty()) {
            for (Product obj : productList) {
                if (products.contains(obj)) {
                    products.remove(obj);
                }
            }
            return true;
        }
        return false;
    }
}
