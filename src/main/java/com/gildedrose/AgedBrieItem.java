package com.gildedrose;

public class AgedBrieItem extends StandardItem
{
	public static final String NAME = "Aged Brie";
	
	protected AgedBrieItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public AgedBrieItem(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	@Override
	protected void updateItemQuality() {
		int qualityImprovementToday = getQualityAlterationToday();
		this.sellIn--;
		quality = quality + qualityImprovementToday;
	}
}
