package Merch;

import java.util.ArrayList;

public class CustomerShoppingCart
{
    private ArrayList<Merchandise> shoppingCart = new ArrayList<Merchandise>();

    private int numberOfItems = 0;
    private float totalPrice = 0;

    public ArrayList<Merchandise> getShoppingCart() {
        return shoppingCart;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public boolean AddItem(Merchandise item)
    {
        if ( item == null )
            return false;

        shoppingCart.add(item);
        this.numberOfItems++;
        this.totalPrice += item.getPrice();

        return true;
    }

    public boolean RemoveItem(Merchandise item)
    {
        if ( item == null )
            return false;

        shoppingCart.remove(item);
        this.numberOfItems--;
        this.totalPrice -= item.getPrice();

        item.setQuantity(item.getQuantity() + 1);

        return true;
    }

}
