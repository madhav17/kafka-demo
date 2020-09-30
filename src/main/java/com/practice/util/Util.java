package com.practice.util;

import com.practice.dto.TweetDTO;
import com.practice.dto.UserDTO;
import com.practice.es.repository.Tweet;
import com.practice.es.repository.User;

public class Util {

    public static Tweet convertToTweet(TweetDTO tweetDTO) {
        Tweet tweet = new Tweet();

        tweet.setId(tweetDTO.getId());
        tweet.setId_str(tweetDTO.getId_str());
        tweet.setText(tweetDTO.getText());
        tweet.setLang(tweetDTO.getLang());
        tweet.setFilter_level(tweetDTO.getFilter_level());
        tweet.setTimestamp_ms(tweetDTO.getTimestamp_ms());
        tweet.setCreated_at(tweetDTO.getCreated_at());
        tweet.setUser(convertToUser(tweetDTO.getUser()));
        return tweet;
    }

    public static User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setId_str(userDTO.getId_str());
        user.setName(userDTO.getName());
        user.setScreen_name(userDTO.getScreen_name());
        user.setLocation(userDTO.getLocation());
        user.setDescription(userDTO.getDescription());
        user.setFollowers_count(userDTO.getFollowers_count());
        user.setFriends_count(userDTO.getFriends_count());
        user.setListed_count(userDTO.getListed_count());
        user.setFavourites_count(userDTO.getFavourites_count());
        user.setStatuses_count(userDTO.getStatuses_count());
        user.setCreated_at(userDTO.getCreated_at());
        user.setProfile_image_url_https(userDTO.getProfile_image_url_https());
        user.setProfile_banner_url(userDTO.getProfile_banner_url());
        user.setDefault_profile(userDTO.getDefault_profile());
        user.setDefault_profile_image(userDTO.getDefault_profile_image());
        return user;
    }
}
