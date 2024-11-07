package ru.mirea.shparaga.movie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MovieProcessor {

    public static void main(String[] args) {
        MovieClient movieClient = new MovieClient();
        MovieService movieService = movieClient.getMovieService();

        Call<List<Movie>> moviesCall = movieService.getMovies();

        moviesCall.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body();

                    Optional<Movie> maxCastMovie = movies.stream()
                            .filter(movie -> movie.getYear() < 2000)
                            .max(Comparator.comparingInt(movie -> movie.getCast().size()));

                    maxCastMovie.ifPresent(movie -> {
                        System.out.println("Фильм с наибольшим количеством актёров до 2000 года: " + movie);
                    });
                } else {
                    System.out.println("Ошибка при получении данных");
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                System.out.println("Ошибка запроса: " + t.getMessage());
            }
        });
    }
}
