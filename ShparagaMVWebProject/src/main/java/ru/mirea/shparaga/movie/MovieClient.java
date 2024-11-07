package ru.mirea.shparaga.movie;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MovieClient {

    private static final String BASE_URL = "https://raw.githubusercontent.com";
    private final MovieService movieService;

    public MovieClient() {
        Retrofit client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(JsonMapper.builder().build()))
                .build();
        movieService = client.create(MovieService.class);
    }

    public MovieService getMovieService() {
        return movieService;
    }
}
