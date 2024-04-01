package market;



import market.exceptions.ProductNotFoundException;
import market.exceptions.QuantityIsNegativeException;
import market.exceptions.UserNotFoudException;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private List<User> users;
    private List<Product> products;
    private List<Order> orders;


    public Market() {
        users = new ArrayList<>(List.of(
                new User("Tom", 45, "11111",Gender.MALE),
                new User("Bob", 26, "22222", Gender.MALE),
                new User("Jim", 53, "33333", Gender.MALE),
                new User("Anna", 40, "44444", Gender.FEMALE)
        ));
        products = new ArrayList<>(List.of(
                new Product("Milk", 89),
                new Product("Bread", 26),
                new Product("Cheese", 125)
        ));
        orders = new ArrayList<>();
    }

    public int createOrder(User user) throws UserNotFoudException {
        if (!users.contains(user)) throw new UserNotFoudException("user not found, " + user);
        Order order = new Order(user);
        orders.add(order);
        return order.getId();
    }

    public Order addProductToOrder(int orderId, Product product, int quantity)
            throws ProductNotFoundException, QuantityIsNegativeException {
        if (!products.contains(product)) throw new ProductNotFoundException("product not found");
        if (quantity <= 0) throw new QuantityIsNegativeException("quantity of product "+ product + " is negative ");
        Order order = orders.stream().filter(o -> o.getId() == orderId).findFirst().get();
        order.add(product, quantity);
        return order;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
