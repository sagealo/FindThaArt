package com.hfad.findthaart;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface HarvardArtService {
    //we know the baseURL is https://api.harvardartmuseums.org
    //so the following generates:
    //https://www.harvardartmuseums.org/collections/object/6108?position=8
    // @ symbol refers to annotation

    @GET("/{type}")
    Call<ArtResponse> searchByResourceType(@Path("type")String type,
                                           @Query("size")int size,
                                           @Query("keyword")String keyWord,
                                           @Query("title") String title,
                                           @Query("apikey")String apiKey);

}
