package nyc.c4q.MovieDBUserTest.Models;

import java.util.List;

/**
 * Created by c4q on 1/19/18.
 */

public class MovieReview {
  private int id;
  private int page;
  private List<MovieReviewDisplay> results;
  private int total_pages;
  private int total_results;

  public int getId() {
    return id;
  }

  public int getPage() {
    return page;
  }

  public List<MovieReviewDisplay> getResults() {
    return results;
  }

  public int getTotal_pages() {
    return total_pages;
  }

  public int getTotal_results() {
    return total_results;
  }
}
