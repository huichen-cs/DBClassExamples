import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart implements Iterable<CartItem> {
    private List<CartItem> items;
    private BigDecimal total;

    public ShoppingCart() {
        items = new LinkedList<CartItem>();
        total = new BigDecimal(0);
    }

    public void addItem(CartItem item) {
        for (CartItem cartItem: items) {
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
