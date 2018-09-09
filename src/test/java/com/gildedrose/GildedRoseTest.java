package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest
{
    @Test
    public void standardItem_QualityElapses1DayTest() {
        Item[] items = new Item[] { new Item("Standard Item", 2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Standard Item", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }
    
    @Test
    public void standardItem_SellinExpiresTest() {
        Item[] items = new Item[] { new Item("Standard Item", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Standard Item", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }
    
    @Test
    public void standardItem_SellinIsExpiredTest() {
        Item[] items = new Item[] { new Item("Standard Item", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Standard Item", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    public void standardItem_QualityNeverGetsNegativeTest() {
        Item[] items = new Item[] { new Item("Standard Item", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Standard Item", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void agedBrie_QualityElapses1DayTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    public void agedBrie_SellinExpiresTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    public void agedBrie_SellinIsExpiredTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    public void agedBrie_QualityNeverExceeds50Test() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    public void sulfuras_QualityElapses1DayTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }
    
    @Test
    public void sulfuras_SellinExpiresTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }
    
    @Test
    public void sulfuras_SellinIsExpiredTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityElapses1DayBefore10DaysPriorTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityElapses1Day10DaysPriorTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityElapses1DayBetween10And5DaysPriorTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityElapses1Day5DaysPriorTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityElapses1DayAfter5DaysPriorTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_SellinExpiresTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_SellinIsExpiredTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityNeverGetsNegativeTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityNeverExceeds50TestBefore10DaysPrior() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityNeverExceeds50TestBetween10And5DaysPrior() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    public void backstagePasses_QualityNeverExceeds50TestAfter5DaysPrior() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
