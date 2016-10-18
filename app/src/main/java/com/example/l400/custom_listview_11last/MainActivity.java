package com.example.l400.custom_listview_11last;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] movie_poster = {R.drawable.av,R.drawable.jungle,R.drawable.original,
            R.drawable.raees,R.drawable.sesi,R.drawable.sesion,R.drawable.sin};
    String[] movie_title;
    String[] movie_rating;
    MovieAdapter movieAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        movie_rating = getResources().getStringArray(R.array.movie_rating);
        movie_title = getResources().getStringArray(R.array.movie_title);
        int i = 0;
        movieAdapter = new MovieAdapter(this,R.layout.row_layout);
        listView.setAdapter(movieAdapter);
        for(String titles : movie_title){
            MovieDataProvider movieDataProvider = new MovieDataProvider(movie_poster[i],
                    titles,movie_rating[i]);
            movieAdapter.add(movieDataProvider);
            i++;
        }

    }
}
