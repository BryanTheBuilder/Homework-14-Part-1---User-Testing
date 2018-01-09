package nyc.c4q.MovieDBUserTest.Models;

import java.util.List;

/**
 * Created by c4q on 1/8/18.
 */

public class Popular {

  private int page;
  private List<Results> results;
  private int total_results;
  private int total_pages;

  public int getPage() {
    return page;
  }

  public List<Results> getResults() {
    return results;
  }

  public int getTotal_results() {
    return total_results;
  }

  public int getTotal_pages() {
    return total_pages;
  }
}
