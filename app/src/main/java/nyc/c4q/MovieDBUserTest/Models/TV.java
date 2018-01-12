package nyc.c4q.MovieDBUserTest.Models;

import java.util.List;

/**
 * Created by c4q on 1/11/18.
 */

public class TV {

  private int page;
  private int total_results;
  private int total_pages;

  private List<TvResults> tvresults;

  public int getPage() {
    return page;
  }

  public int getTotal_results() {
    return total_results;
  }

  public int getTotal_pages() {
    return total_pages;
  }

  public List<TvResults> getResults() {
    return tvresults;
  }

}
