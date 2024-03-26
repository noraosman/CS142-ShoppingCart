/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingcartgui;

import java.text.NumberFormat;

/**
 * This class represent items.
 * The class calculates the price of items including bulk pricing.
 * It also has a toString method.
 */
public class Item {
    private String name;
    private double price;
    private int bulkQuantity;
    private double bulkPrice;

    /**
     * constructs item that does not have a bulk price 
     * @param name name of the item
     * @param price  regular price of the item
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    /**
     * constructs item that has a bulk price 
     * @param name name of the item
     * @param price  regular price of the item
     * @param bulkQuantity quantity to get bulk discount
     * @param bulkPrice bulk pricing 
     */
    public Item(String name, double price, int bulkQuantity, double bulkPrice) {
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
    }

    /**
     * gets the item name 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets pricing for specific quantity
     * will calculate bulk discount if applicable
     * @param quantity item quantity bought
     * @return price
     */
    public double priceFor(int quantity) {
        if (bulkQuantity == 0) {
            // calculates regular pricing
            return price * quantity;
        } else {
            // calculates the bulk pricing
            double bulkTotal = bulkPrice * (quantity / bulkQuantity);
            double remainder = price * (quantity % bulkQuantity);
            return bulkTotal + remainder;
        }
    }

    /**
     * formats the item, price and bulk discount
     * @return item description
     */
    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        // regular price
        String singlePrice = String.format("%s, %s", name, nf.format(price));
        if (bulkQuantity == 0) {
            return singlePrice;
        } else {
            // add bulk price
            String bulkPrices = String.format(" (%d for %s)", bulkQuantity, nf.format(bulkPrice));
            return (singlePrice + bulkPrices);
        }
    }

}
