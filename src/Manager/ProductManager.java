package Manager;

import Model.Product;
import ReadAndWrite.ReadAndWriteProduct;
import javafx.scene.Camera;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IProductManager<Product> {
    List<Product> productList;
    ReadAndWriteProduct readAndWriteProduct;

    public ProductManager() {
        readAndWriteProduct = new ReadAndWriteProduct();
        if (readAndWriteProduct.ReadFile() != null) {
            productList = readAndWriteProduct.ReadFile();
        } else {
            productList = new ArrayList<>();
        }
    }

    @Override
    public void add(Product product) {
        productList.add(product);
        readAndWriteProduct.writeFile(productList);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(int id, Product product) {
        int index = findIndexById(id);
        productList.set(index, product);
        readAndWriteProduct.writeFile(productList);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        productList.remove(index);
        readAndWriteProduct.writeFile(productList);
    }

    @Override
    public List<Product> showAll() {
        readAndWriteProduct.ReadFile();
        return this.productList;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> newlist = new ArrayList<>();
        for (Product product : productList
        ) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                newlist.add(product);
            }
        }
        readAndWriteProduct.ReadFile();
        return newlist;
    }

    @Override
    public List<Product> listProductType(String productType) {
        List<Product> newlist = new ArrayList<>();
        for (Product product : productList
        ) {
            if (product.getProductType().toLowerCase().contains(productType.toLowerCase())) {
                newlist.add(product);
            }
        }
        readAndWriteProduct.ReadFile();
        return newlist;
    }

    @Override
    public Product searchProductById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        readAndWriteProduct.ReadFile();
        return null;
    }

    public boolean checkIdInList(int id) {
        for (Product product : productList
        ) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
