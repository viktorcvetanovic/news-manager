package org.newsmanager;

import org.newsmanager.data.Post;

import java.util.List;

public interface Scraper {

    List<Post> scrape();

}
