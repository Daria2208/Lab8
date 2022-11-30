import java.util.*;

public class main {
    public static void main(String[] args) {
        ArrayList listOfStrings = new ArrayList(); // объявление array-листа (списка)
        String menu = "1. Добавить. \n" +
                "2. Удалить. \n" +
                "3. Поиск дубликатов. \n" +
                "4. Вывести реверс строк. \n" +
                "5. Поиск подстроки. \n" +
                "6. Вывести список. \n" +
                "7. Показать длины строк. \n" +
                "8. Выход." ;

        while(true) {
            System.out.println(menu);
            Scanner in1 = new Scanner(System.in); //для ввода с консоли
            System.out.print("Выберите команду: "); 
            int choice = in1.nextInt(); // ввод номера из меню

            switch (choice) {
                case (1):
                    System.out.println("Введите строку: \n");
                    Scanner in2 = new Scanner(System.in);
                    String newString = in2.nextLine(); // ввод строки
                    listOfStrings.add(newString); // добавление строки в список
                    break;
                case (2):
                System.out.print("Введите номер: ");
                int index = in1.nextInt();

                    if(index <0 || index >= listOfStrings.size())
                        System.out.println("Неправильный номер \n");
                    else
                        listOfStrings.remove(index);
                    break;
                case (3):
                    Map<String, Integer> words = new HashMap<String, Integer>();
                    for (int i = 0; i < listOfStrings.size(); i++) {
                        String tempString = listOfStrings.get(i).toString();

                        if (words.containsKey(tempString)) {
                            words.put(tempString, words.get(tempString) + 1);
                        } else {
                            words.put(tempString, 1);
                        }
                    }
                    for (Map.Entry<String, Integer> entry : words.entrySet()) {
                        if(entry.getValue()>1) {
                            System.out.println("Строка = " + entry.getKey() + ", раз = " + entry.getValue());
                        }
                    }
                    break;
                case (4):
                    int counter;
                    for (counter = 0; counter < listOfStrings.size(); counter++) {
                        String reverse = new StringBuffer(listOfStrings.get(counter).toString()).reverse().toString();
                        System.out.println(reverse);
                    }
                    break;
                case (5):
                    System.out.println("Введите строку для поиска: \n");
                    Scanner in3 = new Scanner(System.in);
                    String subStr = in3.nextLine();
                    int existingSubstrings = 0;
                    for(int i = 0; i<listOfStrings.size(); i++){
                        if(listOfStrings.get(i).toString().lastIndexOf(subStr) != -1){
                            existingSubstrings++;
                            System.out.println("Найденые строки: " + listOfStrings.get(i).toString());
                        }
                    }
                    if(existingSubstrings==0){
                        System.out.println("Строка не найдена. \n");
                    }
                    break;
                case (6):
                    for(int i = 0; i<listOfStrings.size(); i++){
                        System.out.println("["+ i + "]" + listOfStrings.get(i));
                    }
                    break;
                case (7):
                    ArrayList sortedStrings = new ArrayList();
                    sortedStrings = listOfStrings;

                    class StringLengthSort implements Comparator<String>{
                        @Override
                        public int compare(String o1, String o2) {
                            if(o1.length() < o2.length()){
                                return 1;
                            }else{
                                if(o1.length() > o2.length()){
                                    return -1;
                                }else{
                                    return 0;
                                }
                            }
                        }
                    }
                    Comparator<String> stringLengthComparator = new StringLengthSort();
                    Collections.sort(sortedStrings, stringLengthComparator); // sorting
                    for(Object str : sortedStrings){
                        System.out.println(str.toString() + " : " + str.toString().length() + " букв ");
                    }
                    break;
                case (8):
                    return;
                default:
                    System.out.println("Неправильный номер команды!");
                    break;
            }
        }
    }
}