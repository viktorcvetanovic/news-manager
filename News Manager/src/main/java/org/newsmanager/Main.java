package org.newsmanager;

import org.newsmanager.util.FileParser;

public class Main {
    public static void main(String[] args) {
        Selenium selenium = new Selenium();
        selenium.login(FileParser.parseUser());
        Scraper scraper = new BlicScraper();
        scraper.scrape();
        PostCreator postCreator = new PostCreator();
        postCreator.mapHtmlToPosts(scraper.scrape())
                .forEach(selenium::createPost);
    }
}