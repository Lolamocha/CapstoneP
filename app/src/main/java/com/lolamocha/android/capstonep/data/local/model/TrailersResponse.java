package com.lolamocha.android.capstonep.data.local.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class TrailersResponse {

    @SerializedName("results")
    private List<Trailer> trailers;

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }
}
