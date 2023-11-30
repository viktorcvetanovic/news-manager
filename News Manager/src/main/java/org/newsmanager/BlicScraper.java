package org.newsmanager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class BlicScraper implements Scraper {

    @Override
    public String scrape() {
        try {
            Document doc = Jsoup.connect("https://www.blic.rs/vesti").get();
            System.out.println(doc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
