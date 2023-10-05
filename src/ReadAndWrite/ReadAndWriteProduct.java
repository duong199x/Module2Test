package ReadAndWrite;

import Model.Product;
import javafx.scene.Camera;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteProduct {
    File file = new File("Data/products.csv");

    public void writeFile(List<Product> list) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Product product : list
            ) {
                line += product.getId() + "," + product.getName() + "," + product.getQuantity() + "," + product.getPrice() + "," + product.getProductType() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Product> ReadFile() {
        ArrayList<Product> list = new ArrayList<>();
        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Product product = new Product(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
                list.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
