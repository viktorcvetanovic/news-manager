package org.newsmanager;

import org.newsmanager.data.Post;

import java.util.List;

public class PostCreator {


    public List<Post> mapHtmlToPosts(String html) {
        return List.of(new Post("Proba", "DA VIDIM DA LI RADI"));
    }
}
