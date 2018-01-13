package nyc.c4q.MovieDBUserTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Shant on 1/13/2018.
 */

public class DetailActivity extends AppCompatActivity {

    private TextView voteCount;
    private TextView title;
    private TextView release;
    private TextView rating;
    private TextView language;
    private TextView desc;
    private TextView country;
    private ImageView poster;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        setVariables();

    }

    public void setVariables() {
        title = findViewById(R.id.detail_title);
        release = findViewById(R.id.detail_release);
        rating = findViewById(R.id.detail_rating);
        poster = findViewById(R.id.detail_image);
        desc = findViewById(R.id.detail_desc);
        ratingBar = findViewById(R.id.detail_rating_bar);
        voteCount = findViewById(R.id.detail_votes);
        language = findViewById(R.id.detail_language);
        country = findViewById(R.id.detail_country);

        getIntents();
    }

    public void getIntents() {
        Bundle extras = getIntent().getExtras();

        StringBuilder releaseText = new StringBuilder();
        releaseText.append(extras.getString("release"));
        release.setText(releaseText.toString());
        title.setText(extras.getString("title"));
        rating.setText(Double.toString(extras.getDouble("rating")));
        desc.setText(extras.getString("desc"));
        ratingBar.setRating((float) extras.getDouble("rating") / 2);
        voteCount.setText("(" + extras.get("votes") + ")");
        language.setText(extras.getString("language").toUpperCase());
        Picasso.with(getBaseContext()).load(extras.getString("poster")).into(poster);
    }

}
