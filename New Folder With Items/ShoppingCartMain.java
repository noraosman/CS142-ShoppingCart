/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingcartgui;

/**
 * Nora Osmanova, CS&141, Summer 2022
 * Project #5, 08/19/2022
 *
 * This program's behavior is to create a virtual shopping cart for
 * the user. The program lets user add items from the catalog to shopping cart
 * and check out at the end.
 */
public class ShoppingCartMain {
    public static void main(String[] args) {
        Catalog list = new Catalog("Wishlist for Christmas", 11);
        list.add(new Item("Avengers lego set", 150.00));
        list.add(new Item("The Weeknd After Hours album", 80.00));
        list.add(new Item("Horizon Zero Dawn game set", 60.00));
        list.add(new Item("REI CTY 1.1 bycicle", 700.00));
        list.add(new Item("Fuzzy socks", 7.00, 10, 15.00));
        list.add(new Item("Kitty jacket", 29.99));
        list.add(new Item("A in CS class", 100.00, 5, 1.00 ));
        list.add(new Item("World Atlas", 124.99));
        list.add(new Item("Assorted Coloring books", 19.99, 10, 25.99));
        list.add(new Item("Kona Coffee", 17.99, 5, 70.00));
        list.add(new Item("Mountain Range decal", 6.99));

        ShoppingCartGUI cartGUI = new ShoppingCartGUI(list);
        cartGUI.showGUI();

    }
}