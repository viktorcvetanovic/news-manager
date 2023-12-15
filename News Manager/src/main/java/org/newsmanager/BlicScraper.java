package org.newsmanager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.newsmanager.data.Post;

import java.io.IOException;
import java.util.List;

public class BlicScraper implements Scraper {

    @Override
    public List<Post> scrape() {
        try {
            Document doc = Jsoup.connect("https://www.blic.rs/vesti").get();
            System.out.println(doc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
