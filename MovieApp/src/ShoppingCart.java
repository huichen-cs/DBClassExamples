import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a shopping cart that can hold multiple items.
 * It provides methods to add items, check if the cart is empty, and iterate over the items.
 */
public class ShoppingCart implements Iterable<CartItem> {
  private List<CartItem> items;
  private BigDecimal total;

  public ShoppingCart() {
    items = new LinkedList<CartItem>();
    total = new BigDecimal(0);
  }

  /**
   * Adds an item to the shopping cart. If the item already exists in the cart, it
   * increments the quantity.
   * 
   *
   * @param item the item to be added to the cart
   */
  public void addItem(CartItem item) {
    for (CartItem cartItem : items) {
      if (cartItem.getItemNum() == item.getItemNum()) {
        cartItem.setQtyToOrder(item.getQtyToOrder() + 1);
        total = total.add(item.getItemPrice());
        return;
      }
    }
    items.add(item);
    total = total.add(item.getItemPrice());
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  public Iterator<CartItem> iterator() {
    return items.iterator();
  }
}
