import java.util.Objects;

public class Laptop {
    private String brand;
    private int ram; // в гигабайтах
    private int storage; // в гигабайтах
    private String operatingSystem;
    private String color;

    // Конструктор
    public Laptop(String brand, int ram, int storage, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Laptop{brand='%s', ram=%dGB, storage=%dGB, operatingSystem='%s', color='%s'}",
                brand, ram, storage, operatingSystem, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram && storage == laptop.storage && Objects.equals(brand, laptop.brand) &&
                Objects.equals(operatingSystem, laptop.operatingSystem) && Objects.equals(color, laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, storage, operatingSystem, color);
    }
}
