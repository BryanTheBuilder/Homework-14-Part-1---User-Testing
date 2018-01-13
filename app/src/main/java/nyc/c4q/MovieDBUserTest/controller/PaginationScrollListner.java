package nyc.c4q.MovieDBUserTest.controller;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by c4q on 1/13/18.
 */

public abstract class PaginationScrollListner extends RecyclerView.OnScrollListener {

  GridLayoutManager gridLayoutManager;

  public PaginationScrollListner(GridLayoutManager gridLayoutManager) {
    this.gridLayoutManager = gridLayoutManager;
  }

  @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);

    int visibleItemCount = gridLayoutManager.getChildCount();
    int totalItemCount = gridLayoutManager.getItemCount();
    int firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();

    if (!isLoading() && !isLastPage()) {
      if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
          && firstVisibleItemPosition >= 0) {
        loadMoreItems();
      }
    }
  }

  protected abstract void loadMoreItems();

  public abstract int getTotalPageCount();

  public abstract boolean isLastPage();

  public abstract boolean isLoading();
}
