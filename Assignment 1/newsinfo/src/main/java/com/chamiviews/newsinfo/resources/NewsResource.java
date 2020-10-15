package com.chamiviews.newsinfo.resources;
import com.chamiviews.newsinfo.models.News;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getNews")
public class NewsResource {


    @RequestMapping("/{newsId}")
    public News getNewsInfo(@PathVariable("newsId") String newsId){

        return new News(newsId,"News Title","Desc");
    }

}
