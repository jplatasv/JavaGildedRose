package com.gildedrose;

public class BackstagePassItem extends StandardItem
{
	public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
	
	protected BackstagePassItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public BackstagePassItem(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	@Override
	protected int getQualityAlterationToday() {
		
		boolean between10And6DaysPrior = this.sellIn <= 10 && this.sellIn > 5;
		boolean between5And0DaysPrior = this.sellIn <= 5 && this.sellIn > 0;
		boolean expired = this.sellIn <= 0;
		
		if ( between10And6DaysPrior ) { return 2; }
		if ( between5And0DaysPrior ) { return 3; }
		if ( expired ) { return -quality; }
		
		return 1;
	}
	
	@Override
	protected void updateItemQuality() {
		int qualityImprovementToday = getQualityAlterationToday();
		this.sellIn--;
		quality = quality + qualityImprovementToday;
	}
}
