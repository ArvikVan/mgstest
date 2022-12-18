package arv.mgstest.service;

import arv.mgstest.model.Message;
import arv.mgstest.model.SimpleArray;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author ArvikV
 * @version 1.0
 * @since 06.04.2022
 */
@Service
public class EventServiceImpl implements EventService {
    private List arrayList = new ArrayList<>();

    /**
     * метод для генерации последовательности простых чисел
     * @param message задаем длину массива
     * @return на выходе последовательность простых чисел
     * @throws InterruptedException ошибку ловим
     */
    @Override
    public SimpleArray showMainArray(Message message) throws InterruptedException {
        Thread.sleep(1000); // simulated delay
        String arrLength = HtmlUtils.htmlEscape(message.getName());
        arrayList = primeNumbersTill(Integer.parseInt(arrLength));
        return new SimpleArray(arrayList + " Длина массива составляет: " + arrayList.size());
    }

    /**
     * метод для генерации 5 последовательностей по 6 элементов в каждой
     * из последовательности showMainArray(HelloMessage message)
     * @return на выходе 5 последовательностей
     * @throws InterruptedException ошибку ловим
     */
    @Override
    public SimpleArray showGeneratedArray() throws InterruptedException {
        HashMap hashMap = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            hashMap.put(i, getListOfNumForGeneratedArrays());
        }
        return new SimpleArray(hashMap.values() + " 5 последовательностей из 6 чисел");
    }

    /**
     * метод генерации последовательности каждые 10 секунд
     * @return на выходе последовательность
     * @throws InterruptedException ошибку ловим
     */
    @Override
    public SimpleArray showGeneratedAuto() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SimpleArray(getListOfNumForGeneratedArrays() + " генерация последовательностей каждые 10 секунд");
    }

    /**
     * метод определения последовательности из 5 уникальных элементов
     * @return на выходе последовательность
     */
    private HashSet getListOfNumForGeneratedArrays() {
        HashSet hashSet = new HashSet();
        int i = 0;
        while (hashSet.size() != 6) {
            int randomIndex = (int) (Math.random() * arrayList.size());
            hashSet.add(arrayList.get(randomIndex));
            i++;
        }
        return hashSet;
    }

    /**
     * метод генерации структуры данных простых чисел
     * @param length на входе длинна последовательности
     * @return на выходе структура данных простых чисел
     */
    public static List<Integer> primeNumbersTill(int length) {
        ArrayList result = new ArrayList();
        int i = 1;
        while (result.size() != length) {
            if (isPrime(i)) {
                result.add(i);
            }
            i++;
        }
        return result;
    }

    /**
     * простые числа ищем
     * @param x на входе число
     * @return на выходе простое число
     */
    private static boolean isPrime(int x) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }
    @Scheduled(fixedDelay = 3600000)
    private boolean dates () {
//        LocalDate start = LocalDate.ofYearDay(2021, 1);
//        LocalDate end = LocalDate.ofYearDay(2021, 10);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        List<String> list = start.datesUntil(end).map(x -> x.format(formatter)).collect(Collectors.toList());
//        System.out.println(list);
        int x = 565;
        if (x < 0) {
            return false;
        }
        int number = x;
        int reverse = 0;
        while (number > 0) {
            reverse = reverse*10 + number%10;
            number/=10;
        }
        return x == reverse;
    }
}
