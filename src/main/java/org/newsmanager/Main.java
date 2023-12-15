package org.newsmanager;

import org.newsmanager.util.FileParser;

public class Main {
    public static void main(String[] args) {
        Scraper scraper = new BlicScraper();
        Selenium selenium = new Selenium();

        selenium.login(FileParser.parseUser());
        scraper.scrape().forEach(selenium::createPost);
    }

}