package com.lendingcatalog.model;
import java.util.UUID;
import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

public class Tool implements CatalogItem {
    // attribute of the class.
    private String id;
    private String type;
    private String manufacturer;
    private int count;

    // tool constructor that takes parameters
    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    // getter method
    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCount() {
        return count;
    }

    /// overriding method
    @Override
    public boolean matchesName(String searchStr) {
        return type.toLowerCase().contains(searchStr.toLowerCase());
    }

    // This method find and return the matching manufacture of the tool.
    @Override
    public boolean matchesCreator(String searchStr) {
        return manufacturer.toLowerCase().contains(searchStr.toLowerCase());
    }

    // This method return false because it didn't have a date
    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {
        this.id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(toString(),"src/main/resources/logs/tool.log", true);
        } catch (FileStorageException e) {
            System.out.println("unable to log tool ");
        }

    }

    // The toString method is used to convert to string
    @Override
    public String toString() {
        return "* " + type + System.lineSeparator()
                + " - Manufacturer by: " + manufacturer + System.lineSeparator()
                + " - count: " + count + System.lineSeparator()
                + " - Id: " + id;

      }

}
