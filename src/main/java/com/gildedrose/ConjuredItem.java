package com.gildedrose;

public class ConjuredItem extends StandardItem
{
	public static final String NAME = "Conjured Mana Cake";
	
	protected ConjuredItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public ConjuredItem(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	@Override
	protected int getQualityAlterationToday() {
		int standardQualityAlterationToday = super.getQualityAlterationToday();
		return standardQualityAlterationToday * 2;
	}
}
