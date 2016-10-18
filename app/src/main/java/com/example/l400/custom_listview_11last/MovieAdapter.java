package com.example.l400.custom_listview_11last;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l400 on 9/28/2016.
 */
public class MovieAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public MovieAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }
    static class Datahandler{
     ImageView imageView;
        TextView title;
        TextView rating;

    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        Datahandler datahandler;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            datahandler = new Datahandler();
            datahandler.imageView =(ImageView) row.findViewById(R.id.movie_poster);
            datahandler.title = (TextView)row.findViewById(R.id.movie_name);
            datahandler.rating =(TextView)row.findViewById(R.id.movie_rating);
            row.setTag(datahandler);
        }
        else {

                    datahandler = (Datahandler) row.getTag();
        }
        MovieDataProvider movieDataProvider ;
        movieDataProvider =(MovieDataProvider)this.getItem(position);
        datahandler.imageView.setImageResource(movieDataProvider.getMovie_poster());
        datahandler.title.setText(movieDataProvider.getMovie_title());
        datahandler.rating.setText(movieDataProvider.getMovie_rating());

        return row;
    }
}
