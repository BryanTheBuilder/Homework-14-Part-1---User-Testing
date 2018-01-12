package nyc.c4q.MovieDBUserTest.Models;

import java.util.List;

public class MovieResults {
  private String poster_path;
  private boolean adult;
  private String overview;
  private String release_date;
  private List<Integer> genre_ids;
  private int id;
  private String original_title;
  private String original_language;
  private String title;
  private String backdrop_path;
  private double popularity;
  private int vote_count;
  private boolean video;
  private double vote_average;

  public String getPoster_path() {
    return poster_path;
  }

  public boolean getAdult() {
    return adult;
  }

  public String getOverview() {
    return overview;
  }

  public String getRelease_date() {
    return release_date;
  }

  public List<Integer> getGenre_ids() {
    return genre_ids;
  }

  public int getId() {
    return id;
  }

  public String getOriginal_title() {
    return original_title;
  }

  public String getOriginal_language() {
    return original_language;
  }

  public String getTitle() {
    return title;
  }

  public String getBackdrop_path() {
    return backdrop_path;
  }

  public double getPopularity() {
    return popularity;
  }

  public int getVote_count() {
    return vote_count;
  }

  public boolean getVideo() {
    return video;
  }

  public double getVote_average() {
    return vote_average;
  }
}
