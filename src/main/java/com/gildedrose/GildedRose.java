package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality()
    {
    	for (int i=0;i<items.length;i++) {
    		items[i] = Item2AbstractItemAdapter.adapt(items[i]);
    		((AbstractItem) items[i]).updateQuality();
    	}
    }
}