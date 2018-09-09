package com.gildedrose;

public abstract class Item2AbstractItemAdapter
{
	public static AbstractItem adapt(Item item) {
		
		switch(item.name) {		
			case SulfurasItem.NAME:
				return new SulfurasItem(item.sellIn, item.quality);
			case AgedBrieItem.NAME:
				return new AgedBrieItem(item.sellIn, item.quality);
			case BackstagePassItem.NAME:
				return new BackstagePassItem(item.sellIn, item.quality);
			case ConjuredItem.NAME:
				return new ConjuredItem(item.sellIn, item.quality);
			default:
				return new StandardItem(item.name, item.sellIn, item.quality);			
		}	
	}
}
