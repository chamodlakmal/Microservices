package com.chamiviews.ratingdataservice.resources;

import com.chamiviews.ratingdataservice.models.Rating;
import com.chamiviews.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ratingsdata")
public class RatingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){


        UserRating userRatings=new UserRating();
        userRatings.initData(userId);
        return userRatings;
    }
}
