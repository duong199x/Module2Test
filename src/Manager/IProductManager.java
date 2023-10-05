package Manager;

import java.util.List;

public interface IProductManager<E> {
    public void add(E e);
    public int findIndexById(int id);
    public void edit(int id, E e);
    public void delete(int id);
    public List<E> showAll();
    public List<E> findByName(String name);
    public List<E> listProductType(String productType);
    public E searchProductById(int id);

}
