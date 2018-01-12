package nyc.c4q.MovieDBUserTest.Models;

import java.util.List;

/**
 * Created by c4q on 1/11/18.
 */

public class TvResults {
  private String original_name;
  private List<Integer> genre_ids;
  private String name;
  private double popularity;
  private List<String> origin_country;
  private int vote_count;
  private String first_air_date;
  private String backdrop_path;
  private String original_language;
  private int id;
  private double vote_average;
  private String overview;
  private String poster_path;

  public String getOriginal_name() {
    return original_name;
  }

  public List<Integer> getGenre_ids() {
    return genre_ids;
  }

  public String getName() {
    return name;
  }

  public double getPopularity() {
    return popularity;
  }

  public List<String> getOrigin_country() {
    return origin_country;
  }

  public int getVote_count() {
    return vote_count;
  }

  public String getFirst_air_date() {
    return first_air_date;
  }

  public String getBackdrop_path() {
    return backdrop_path;
  }

  public String getOriginal_language() {
    return original_language;
  }

  public int getId() {
    return id;
  }

  public double getVote_average() {
    return vote_average;
  }

  public String getOverview() {
    return overview;
  }

  public String getPoster_path() {
    return poster_path;
  }
}
