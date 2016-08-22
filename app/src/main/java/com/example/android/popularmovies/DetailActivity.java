package com.example.android.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class DetailFragment extends Fragment {

        private static final String LOG_TAG = DetailFragment.class.getSimpleName();

        private Movie mMovie;

        public DetailFragment() {
            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Intent intent = getActivity().getIntent();
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
                mMovie = intent.getParcelableExtra(Intent.EXTRA_TEXT);
                ((TextView) rootView.findViewById(R.id.text_title)).setText(mMovie.getTitle());
                ImageView moviePoster = (ImageView) rootView.findViewById(R.id.image_poster);
                Picasso.with(getContext()).load(mMovie.getImageUrl()).fit().into(moviePoster);
                ((TextView) rootView.findViewById(R.id.text_release_date)).setText(mMovie.getReleaseDate());
                ((TextView) rootView.findViewById(R.id.text_rating)).setText(Double.toString(mMovie.getUserRating()));
                ((TextView) rootView.findViewById(R.id.text_overview)).setText(mMovie.getOverview());
            }

            return rootView;
        }
    }
}
