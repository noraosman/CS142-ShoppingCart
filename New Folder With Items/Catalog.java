/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingcartgui;

/**
 * This class is catalog of items.
 * It also the size of item array.
 */
public class Catalog {
    private String name;
    private Item[] itemList;

    /**
     * constructs a catalog of items 
     * @param name name of the catalog
     * @param size max size of catalog
     */
    public Catalog(String name, int size) {
        this.name = name;
        this.itemList = new Item[size];
    }

    /**
     * adds items to the catalog
     * @param item items in the catalog
     * @return true if added, false otherwise
     */
    public boolean add(Item item) {
        // get next available spot
        int next = size();
        if(next >= itemList.length){
            // item list is full
            return false;
        }
        // adding item
        itemList[next] = item;
        return true;
    }

    /**
     *  the number of items in the catalog
     * @return count
     */
    public int size(){
        int size = 0;
        for (int i = 0; i < itemList.length; i++){
            // found an item
            if (itemList[i] != null){
                size += 1;

            }
        }
        return size;
    }

    /**
     * gets item at an index 
     * @param index to get item at
     * @return item
     */
    public Item getIndex(int index) {
        return itemList[index];
    }

    /**
     * gets the catalog name
     * @return name
     */
    public String getName(){
        return name;
    }
}

