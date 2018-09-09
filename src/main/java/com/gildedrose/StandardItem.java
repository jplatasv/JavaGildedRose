package com.gildedrose;

public class StandardItem extends AbstractItem
{
	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	protected int getQualityAlterationToday() {
		int qualityAlterationToday = this.sellIn <= 0 ? 2 : 1;
		return qualityAlterationToday;
	}
	
	@Override
	protected void updateItemQuality() {
		int qualityDegradationToday = getQualityAlterationToday();
		this.sellIn--;
		quality = quality - qualityDegradationToday;
	}
}
