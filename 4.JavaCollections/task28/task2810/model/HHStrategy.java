package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Miha on 17.05.2017.
 */
public class HHStrategy implements Strategy {


    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString) {

        int page = 0;
        Document document = null;
        List<Vacancy> vacancyList = new ArrayList<>();

        while (true) {
            document = getDocument(searchString, page);

            Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

            if (elements.size() == 0) break;
            if(elements.isEmpty()) break;
            for (Element element : elements) {
                if (element != null) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName("http://hh.ua/search/vacancy?text=java+%s&page=%d");
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());

                    vacancyList.add(vacancy);
                }
            }
            page++;
        }

        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) {
        String url = String.format(URL_FORMAT, searchString, page);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (jsoup)").referrer("some text").timeout(5000).get();
        }
        catch (IOException e) {}
        return doc;
    }
}
