package org.newsmanager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.newsmanager.data.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlicScraper implements Scraper {

    @Override
    public List<Post> scrape() {
        List<Post> posts;
        try {
            Document mainPage = Jsoup.connect("https://www.blic.rs/najnovije-vesti/").get();
            List<Element> news = mainPage.getElementById("tab-blic-info")
                    .getElementsByTag("article");
            System.out.println(news.size());
            posts = news.stream()
                    .map(e->{
                        String link = e.getElementsByClass("news__img")
                                .get(0)
                                .getElementsByTag("a")
                                .get(0)
                                .attr("href");
                        String header = "";
                        String body = "";
                        try {
                            Document newsInformation = Jsoup.connect(link).get();
                            header = newsInformation.getElementsByTag("h1").text();
                            body =  newsInformation.getElementsByClass("article__text")
                                    .get(0)
                                    .getElementsByTag("p")
                                    .stream()
                                    .map(Element::text)
                                    .collect(Collectors.joining(" "));

                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        System.out.println(link);
                        return new Post(header,body);
                    })
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return posts;
    }
}
