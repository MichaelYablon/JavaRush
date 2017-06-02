package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Miha on 05.05.2017.
 */
public class AdvertisementManager {
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException
    {
        List<Advertisement> list = new ArrayList<>();
        // убираем из отбора видео если они больше времени приготовления
        for (Advertisement advertisement : storage.list())
        {
            if (advertisement.getDuration() <= timeSeconds && advertisement.getHits() > 0)
                list.add(advertisement);
        }
        // если нет видео, то показыть нечего выбрасываем исключение
        if (list.isEmpty())
        {
            throw new NoVideoAvailableException();
        }
        // рекурсивно подбираем лучший вариант показа
        //list = filterVideos(list, 0);
        // сортируем от самых прибыльных к менее
        Collections.sort(list, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                long a1 = o1.getAmountPerOneDisplaying();
                long a2 = o2.getAmountPerOneDisplaying();
                if (a1 < a2) return 1;
                else if (a1 > a2) return -1;
                long sec1 = (long) ((a1 * 1000f) / o1.getDuration());
                long sec2 = (long) ((a2 * 1000f) / o2.getDuration());
                if (sec1 > sec2) return 1;
                else if (sec1 < sec2) return -1;
                return 0;
            }
        });
        long sumAmount = 0;
        int sumDuration = 0;
        for (Advertisement a : list)
        {
            sumAmount += a.getAmountPerOneDisplaying();
            sumDuration += a.getDuration();
        }
        // регистрируем событие перед выводом видео
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(list, sumAmount, sumDuration));
        // выводим видео
        for (Advertisement a : list)
        {
            int priceOneSecond = (int) (a.getAmountPerOneDisplaying() * 1000 / a.getDuration());
            ConsoleHelper.writeMessage(a.getName() + " is displaying... " + a.getAmountPerOneDisplaying() + ", " + priceOneSecond);
            a.revalidate();
        }
    }
    // храню лучшую комбинацию показа видео
    private List<Advertisement> bestCombination = new ArrayList<>();
    // рекурсивная процедура для подбора лучшей комбинации видео

}
