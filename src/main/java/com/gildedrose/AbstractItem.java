package com.gildedrose;

public abstract class AbstractItem extends Item
{
	protected AbstractItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	protected void applyParentRules() {
		applyRuleQualityCannotExceed50();
		applyRuleQualityCannotBeNegative();
	}
	
	protected void applyRuleQualityCannotExceed50() {
		this.quality = this.quality > 50 ? 50 : quality;
	}
	
	protected void applyRuleQualityCannotBeNegative() {
		this.quality = this.quality < 0 ? 0 : quality;
	}
	
	public final void updateQuality() {
		updateItemQuality();
		applyParentRules();
    }
	
	protected abstract void updateItemQuality();
}
