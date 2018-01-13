package nyc.c4q.MovieDBUserTest.viewHolder;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.MovieDBUserTest.DetailActivity;
import nyc.c4q.MovieDBUserTest.Models.TvResults;
import nyc.c4q.MovieDBUserTest.R;

public class TVViewHolder extends RecyclerView.ViewHolder {
    private TextView tvTitle, tvOverview, tvGenre, tvAirDate;
    private ImageView tvPoster;

    public TVViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvPoster = itemView.findViewById(R.id.tv_poster);
    }

    public void onBind(final TvResults results) {
        tvTitle.setText(results.getName());
        final StringBuilder fullImagePath = new StringBuilder();
        fullImagePath.append("http://image.tmdb.org/t/p/w185/");
        fullImagePath.append(results.getPoster_path());
        Picasso.with(itemView.getContext())
                .load(fullImagePath.toString()).into(tvPoster);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDetailActvity = new Intent(itemView.getContext(), DetailActivity.class);
                goToDetailActvity.putExtra("title",results.getOriginal_name());
                goToDetailActvity.putExtra("release",results.getFirst_air_date());
                goToDetailActvity.putExtra("rating",results.getVote_average());
                goToDetailActvity.putExtra("desc",results.getOverview());
                goToDetailActvity.putExtra("poster",fullImagePath.toString());
                itemView.getContext().startActivity(goToDetailActvity);

            }
        });
    }
}
