import java.util.*;

public class Mila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split("_");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }

        int[] arr1 = parseArray(parts[0]);
        int[] arr2 = parseArray(parts[1]);

        System.out.println(findCommonElements(arr1, arr2));
    }

    private static int[] parseArray(String part) {
        String[] numbers = part.split("\\s+");
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    private static String findCommonElements(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countArr1 = new HashMap<>();
        Set<Integer> commonElements = new HashSet<>();

        // Заполнение счетчика первого массива
        for (int num : arr1) {
            countArr1.put(num, countArr1.getOrDefault(num, 0) + 1);
        }

        // Поиск общих элементов во втором массиве
        for (int num : arr2) {
            if (countArr1.containsKey(num)) {
                commonElements.add(num);
                countArr1.put(num, countArr1.get(num) - 1);
                if (countArr1.get(num) == 0) {
                    countArr1.remove(num);
                }
            }
        }

        // Сортировка результатов
        List<Integer> list = new ArrayList<>(commonElements);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Integer num : list) {
            sb.append(num).append(" ");
        }

        return sb.toString().trim();
    }
}
