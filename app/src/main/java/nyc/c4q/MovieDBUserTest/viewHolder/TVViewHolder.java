package nyc.c4q.MovieDBUserTest.viewHolder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.MovieDBUserTest.Models.TvResults;
import nyc.c4q.MovieDBUserTest.R;

public class TVViewHolder extends RecyclerView.ViewHolder {
    private TextView tvTitle, tvOverview, tvGenre, tvAirDate;
    private ImageView tvPoster;

    public TVViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvOverview = itemView.findViewById(R.id.tv_overview);
        tvGenre = itemView.findViewById(R.id.tv_genre);
        tvAirDate = itemView.findViewById(R.id.tv_air_date);
        tvPoster = itemView.findViewById(R.id.tv_poster);
    }

    public void onBind(TvResults results) {
        tvTitle.setText(results.getName());
        tvOverview.setText(results.getOverview());
        tvAirDate.setText(results.getFirst_air_date());
        Picasso.with(itemView.getContext())
                .load(results.getPoster_path())
                .into(tvPoster);
    }
}
