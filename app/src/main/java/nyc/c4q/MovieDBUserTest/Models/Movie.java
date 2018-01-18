package nyc.c4q.MovieDBUserTest.Models;

import java.util.List;

/**
 * Created by c4q on 1/11/18.
 */

public class Movie {

  private int page;
  private List<MovieResults> results;
  private int total_results;
  private int total_pages;

  public int getPage() {
    return page;
  }

  public List<MovieResults> getResults() {
    return results;
  }

  public int getTotal_results() {
    return total_results;
  }

  public int getTotal_pages() {
    return total_pages;
  }

}
