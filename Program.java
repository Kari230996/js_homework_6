import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/*
1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
 Реализовать в java.

2. Создать множество ноутбуков.

3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

“Введите цифру, соответствующую необходимому критерию:
1 - Имя
2 - Объем ЖД
3 - Операционная система
4 - Цена 
5 - Сенсорный экран

4. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

5. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */


public class Program {

    public static void main(String[] args) {

        // Task 1-2
        Set<Notebook> notebookSet = new HashSet<>();

        notebookSet.add(new Notebook("Asus", "150 GB", "Windows", 450, false));
        notebookSet.add(new Notebook("Samsung", "250 GB", "Windows", 550, false));
        notebookSet.add(new Notebook("Samsung", "250 GB", "Windows", 500, false));
        notebookSet.add(new Notebook("Samsung", "250 GB", "Windows", 500, false));

        for (Notebook notebook : notebookSet) {
            System.out.println(notebook);
        }

        // Task 3
        Map<String, String> filterCriteria = getFilterCriteria();

        filterNotebooks(notebookSet, filterCriteria);

    }

    public static void filterNotebooks(Set<Notebook> notebooks, Map<String, String> filterCriteria) {
        for (Notebook notebook : notebooks) {
            boolean matchesCriteria = true;

            for (String criterion : filterCriteria.keySet()) {
                String notebookValue = "";

                switch (criterion) {
                    case "name":
                        notebookValue = notebook.getName();
                        break;
                    case "storage":
                        notebookValue = notebook.getStorage();
                        break;
                    case "operationSystem":
                        notebookValue = notebook.getOperationSystem();
                        break;
                    case "price":
                        notebookValue = String.valueOf(notebook.getPrice());
                        break;
                    case "touchScreen":
                        notebookValue = String.valueOf(notebook.getTouchScreen());
                        break;
                }

                String filterValue = filterCriteria.get(criterion);
                if (!filterValue.isEmpty() && notebookValue.compareTo(filterValue) < 0) {
                    matchesCriteria = false;
                    break;
                }
            }

            if (matchesCriteria) {
                System.out.println(notebook);
            }
        }
    }

    // Task 4
    public static Map<String, String> getFilterCriteria() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> filterCriteria = new HashMap<>();
        filterCriteria.put("name", "");
        filterCriteria.put("storage", "");
        filterCriteria.put("operationSystem", "");
        filterCriteria.put("price", "");
        filterCriteria.put("touchScreen", "");

        System.out.println("Введите минимальное значение для критерия 'name': ");
        filterCriteria.put("name", scanner.nextLine());

        System.out.println("Введите минимальное значение для критерия 'storage': ");
        filterCriteria.put("storage", scanner.nextLine());

        System.out.println("Введите минимальное значение для критерия 'operationSystem': ");
        filterCriteria.put("operationSystem", scanner.nextLine());

        System.out.println("Введите минимальное значение для критерия 'price': ");
        filterCriteria.put("price", scanner.nextLine());

        System.out.println("Введите минимальное значение для критерия 'touchScreen': ");
        filterCriteria.put("touchScreen", scanner.nextLine());

        scanner.close();

        return filterCriteria;
    }
}
