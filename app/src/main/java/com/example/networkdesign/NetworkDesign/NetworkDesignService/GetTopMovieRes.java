package com.example.networkdesign.NetworkDesign.NetworkDesignService;

import com.example.networkdesign.NetworkDesign.Model.Movie;
import com.example.networkdesign.core.Network.HttpErrData;

import java.util.List;

public class GetTopMovieRes {

    /**
     * movie : [{"act":"rose","name":"avater","actvie":"true"},{"act":"two","name":"avater","actvie":"true"}]
     * count : 10
     */

    private int count;
    private List<Movie> movie;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "count=" + count +
//                ", movie=" + movie.toString() +
//                '}';
//    }
}
