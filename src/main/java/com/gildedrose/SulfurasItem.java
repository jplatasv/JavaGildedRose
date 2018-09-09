package com.gildedrose;

public class SulfurasItem extends StandardItem
{
	public static final String NAME = "Sulfuras, Hand of Ragnaros";
	
	protected SulfurasItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public SulfurasItem(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	@Override
	protected void updateItemQuality() {
		// Nothing to do. This is legendary
	}
}
