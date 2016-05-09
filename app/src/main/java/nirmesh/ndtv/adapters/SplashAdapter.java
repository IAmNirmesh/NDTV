package nirmesh.ndtv.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nirmesh.ndtv.R;
import nirmesh.ndtv.detailslist.PatientList;
import nirmesh.ndtv.textdrawable.TextDrawable;

/**
 * Created by asd on 2016-05-09.
 */
public class SplashAdapter extends RecyclerView.Adapter<SplashAdapter.ViewHolder> {

    private ArrayList<PatientList> arraylist;

    public SplashAdapter(ArrayList<PatientList> list) {
        this.arraylist = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView name, date;
        public final ImageView imageView;
        public final View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            name = (TextView) view.findViewById(R.id.name);
            date = (TextView) view.findViewById(R.id.date);
            imageView = (ImageView) view.findViewById(R.id.image_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_splash_list, null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PatientList patientList = arraylist.get(position);
        holder.name.setText("" + patientList.name);
        String date = patientList.date;
        String time = "", ndate = "";
        if (!TextUtils.isEmpty(date)) {
            ndate = date.substring(0, 10);
            time = date.substring(11, date.length());
        }
        holder.date.setText("Date: " + ndate + " Time: " + time);

        TextDrawable drawable = TextDrawable.builder().buildRoundRect(patientList.name, Color.GRAY, 10);
        holder.imageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }
}
