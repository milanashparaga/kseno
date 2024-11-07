package ru.mirea.shparaga.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private String title;
    private int year;
    private List<String> cast;
    private List<String> genres;
    private String href;
    private String extract;
    private String thumbnail;
    private int thumbnailWidth;
    private int thumbnailHeight;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("year")
    public int getYear() {
        return year;
    }

    @JsonProperty("cast")
    public List<String> getCast() {
        return cast;
    }

    @JsonProperty("genres")
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("extract")
    public String getExtract() {
        return extract;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail_width")
    public int getThumbnailWidth() {
        return thumbnailWidth;
    }

    @JsonProperty("thumbnail_height")
    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", cast=" + cast.size() + " actors" +
                ", genres=" + genres +
                ", href='" + href + '\'' +
                ", extract='" + extract + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", thumbnailWidth=" + thumbnailWidth +
                ", thumbnailHeight=" + thumbnailHeight +
                '}';
    }
}
