package com.chamiviews.client.resources;

import com.chamiviews.client.models.News;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/news")
public class ClientResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{newsId}")
    @HystrixCommand(fallbackMethod = "getFallbackNews")
    public News getNews(@PathVariable("newsId") String newsId) {
        News news = restTemplate.getForObject("http://news-info-service/getNews/" + newsId, News.class);
        return news;
    }

    public News getFallbackNews(@PathVariable("newsId") String newsId) {
        return new News(newsId, "No", "No");
    }


}
