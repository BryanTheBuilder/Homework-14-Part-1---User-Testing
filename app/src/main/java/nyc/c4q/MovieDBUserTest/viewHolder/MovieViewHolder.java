package nyc.c4q.MovieDBUserTest.viewHolder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.MovieDBUserTest.Models.MovieResults;
import nyc.c4q.MovieDBUserTest.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private TextView movieTitle, movieGenre, movieReleaseDate;
    private ImageView moviePoster;

    public MovieViewHolder(View itemView) {
        super(itemView);
        movieTitle = itemView.findViewById(R.id.movie_title);
        //movieGenre = itemView.findViewById(R.id.movie_genre);
        moviePoster = itemView.findViewById(R.id.movie_poster);
      //  movieReleaseDate = itemView.findViewById(R.id.movie_release_date);
    }

    public void onBind(MovieResults results) {
        movieTitle.setText(results.getTitle());
        //movieReleaseDate.setText(results.getRelease_date());
        String url = "http://image.tmdb.org/t/p/w185/";
        String path = results.getPoster_path();

        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(path);

        Picasso.with(itemView.getContext())
                .load(sb.toString())
                .into(moviePoster);
    }
}
