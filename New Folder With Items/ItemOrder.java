/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingcartgui;

/**
 * This class represents the order for specific item.
 * It also has a method returning the price and the item.
 */
public class ItemOrder {
    private Item item;
    private int quantity;

    /**
     * constructs an item order
     * @param item item ordered
     * @param quantity quantity ordered
     */
    public ItemOrder(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * gets the price for the item ordered
     * @return the price
     */
    public double getPrice(){
        // defer to item class
        return item.priceFor(quantity);
    }

    /**
     * gets the item from the order
     * @return item
     */
    public Item getItem(){
        return item;
    }

}
