package org.newsmanager;

import org.newsmanager.data.Post;
import org.newsmanager.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

    WebDriver driver = new ChromeDriver();
    public void login(User user){
        driver.get("https://serbiannews.ca/wp-login.php");
        WebElement username = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_pass"));
        WebElement buttonLogin = driver.findElement(By.id("wp-submit"));
        username.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        buttonLogin.click();
    }

    public void createPost(Post post){
        driver.get("https://serbiannews.ca/wp-admin/post-new.php?post_type=page");
        WebElement buttonText = driver.findElement(By.id("content-html"));
        buttonText.click();
        WebElement header = driver.findElement(By.id("title"));
        header.sendKeys(post.getHeader());
        WebElement body = driver.findElement(By.id("content"));
        body.sendKeys(post.getBody());
    }

}
