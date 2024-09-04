import java.util.*;
import java.util.stream.Collectors;

public class HomeWork {

    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Dell", 8, 256, "Windows 10", "Black"));
        laptops.add(new Laptop("Apple", 16, 512, "macOS", "Silver"));
        laptops.add(new Laptop("HP", 4, 128, "Windows 10", "Gray"));


        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Запрос критериев фильтрации
        Map<Integer, String> criteriaMap = new LinkedHashMap<>();
        criteriaMap.put(1, "RAM");
        criteriaMap.put(2, "Storage");
        criteriaMap.put(3, "Operating System");
        criteriaMap.put(4, "Color");

        System.out.println("Введите цифру, соответствующую необходимому критерию фильтрации:");
        criteriaMap.forEach((key, value) -> System.out.println(key + " - " + value));

        Map<String, Object> filters = new HashMap<>();
        int criterion = scanner.nextInt();

        switch (criterion) {
            case 1: // RAM
                System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
                int minRam = scanner.nextInt();
                filters.put("ram", minRam);
                break;
            case 2: // Storage
                System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                int minStorage = scanner.nextInt();
                filters.put("storage", minStorage);
                break;
            case 3: // Operating System
                System.out.print("Введите операционную систему: ");
                scanner.nextLine(); // consume the newline
                String os = scanner.nextLine();
                filters.put("operatingSystem", os);
                break;
            case 4: // Color
                System.out.print("Введите цвет: ");
                String color = scanner.nextLine();
                filters.put("color", color);
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }

        // Фильтрация
        List<Laptop> filteredLaptops = filterLaptops(laptops, filters);
        System.out.println("Ноутбуки, удовлетворяющие критериям:");
        filteredLaptops.forEach(System.out::println);
    }

    public static List<Laptop> filterLaptops(List<Laptop> laptops, Map<String, Object> filters) {
        return laptops.stream()
                .filter(laptop -> {
                    boolean matches = true;
                    if (filters.containsKey("ram")) {
                        matches = matches && laptop.getRam() >= (Integer) filters.get("ram");
                    }
                    if (filters.containsKey("storage")) {
                        matches = matches && laptop.getStorage() >= (Integer) filters.get("storage");
                    }
                    if (filters.containsKey("operatingSystem")) {
                        matches = matches && laptop.getOperatingSystem().equalsIgnoreCase((String) filters.get("operatingSystem"));
                    }
                    if (filters.containsKey("color")) {
                        matches = matches && laptop.getColor().equalsIgnoreCase((String) filters.get("color"));
                    }
                    return matches;
                })
                .collect(Collectors.toList());
    }
}
