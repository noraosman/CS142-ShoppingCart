/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingcartgui;

/**
 * This class adds items to the shopping cart.
 * It applies discount if the box is checked.
 */
public class ShoppingCart {
    private static final double DISCOUNT = 0.9;
    
    private ItemOrder[] itemOrders;
    private boolean isDiscounted;

    /**
     * constructor to create a new shopping cart.
     * @param size  max size for the cart
     */
    public ShoppingCart(int size) {
        this.itemOrders = new ItemOrder[size];
        this.isDiscounted = false;
    }

    /**
     * adds or updates item to item order.
     * if added it will be at the end of the list.
     * @param itemOrder item order to add or update
     */
    public void add(ItemOrder itemOrder) {
        for (int i = 0; i < itemOrders.length; i++) {
            if (itemOrders[i] == null) {
                // adding to end of list.
                itemOrders[i] = itemOrder;
                return;
            } else if (itemOrder.getItem() == itemOrders[i].getItem()) {
                // found item, updating
                itemOrders[i] = itemOrder;
                return;
            }
        }
    }

    /**
     * sets whether there is a discount.
     * @param isDiscounted if there is a discount
     */
    public void setDiscount(boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

    /**
     * return item order list 
     * @return item order list
     */
    public ItemOrder[] getItemOrders() {
        return itemOrders;
    }

    /**
     * gets the total for the shopping cart.
     * will also apply discount if there is one
     * @return the total amount
     */
    public double getTotal() {
        double total = 0;
        // getting the total of  all the items in the list.
        for (int i = 0; i < itemOrders.length; i++) {
            if (itemOrders[i] != null) {
                total += itemOrders[i].getPrice();
            }
        }
        // applying a discount
        if(isDiscounted){
            total = total * ShoppingCart.DISCOUNT;
        }
        return total;
    }

}
