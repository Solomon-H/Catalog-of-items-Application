package com.lendingcatalog.model;

public interface CatalogItem {
    boolean matchesName(String searchStr);
    boolean matchesCreator(String searchStr);
    boolean matchesYear(int searchYear);
    void registerItem();
}
