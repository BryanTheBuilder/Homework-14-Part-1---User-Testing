package nyc.c4q.MovieDBUserTest.viewHolder;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nyc.c4q.MovieDBUserTest.DetailActivity;
import nyc.c4q.MovieDBUserTest.Models.MovieResults;
import nyc.c4q.MovieDBUserTest.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView movieTitle, movieGenre, movieReleaseDate;
    private ImageView moviePoster;

    public MovieViewHolder(View itemView) {
        super(itemView);
        movieTitle = itemView.findViewById(R.id.movie_title);
        moviePoster = itemView.findViewById(R.id.movie_poster);
    }

    public void onBind(final MovieResults results) {
        movieTitle.setText(results.getTitle());
        String url = "http://image.tmdb.org/t/p/w185/";
        String path = results.getPoster_path();

        final StringBuilder fullImagePath = new StringBuilder();
        fullImagePath.append(url);
        fullImagePath.append(path);

        Picasso.with(itemView.getContext())
                .load(fullImagePath.toString())
                .error(R.drawable.broken_image)
                .into(moviePoster);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDetailActivity = new Intent(itemView.getContext(), DetailActivity.class);
                goToDetailActivity.putExtra("movie_id", results.getId());
                goToDetailActivity.putExtra("title", results.getOriginal_title());
                goToDetailActivity.putExtra("release", results.getRelease_date());
                goToDetailActivity.putExtra("rating", results.getVote_average());
                goToDetailActivity.putExtra("lang", results.getOriginal_language());
                goToDetailActivity.putExtra("desc", results.getOverview());
                goToDetailActivity.putExtra("poster", fullImagePath.toString());
                goToDetailActivity.putExtra("votes",results.getVote_count());
                goToDetailActivity.putExtra("lang",results.getOriginal_language());


                itemView.getContext().startActivity(goToDetailActivity);

            }


        });
    }
}
