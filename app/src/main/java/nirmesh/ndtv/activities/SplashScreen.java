package nirmesh.ndtv.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import nirmesh.ndtv.DatabaseHelper;
import nirmesh.ndtv.R;
import nirmesh.ndtv.adapters.SplashAdapter;
import nirmesh.ndtv.detailslist.PatientList;
import nirmesh.ndtv.util.AppUtil;

/**
 * Created by asd on 2016-05-09.
 */
public class SplashScreen extends AppCompatActivity {

    private TextView skip, upcoming;
    private RecyclerView recyclerView;
    private ArrayList<PatientList> patientLists = new ArrayList<PatientList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        skip = (TextView) findViewById(R.id.skip);

        recyclerView = (RecyclerView) findViewById(R.id.splash_recycler_view);
        upcoming = (TextView) findViewById(R.id.upcoming);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);

        Cursor cursor = DatabaseHelper.getInstance(this).fetchAcceptedAppointments();
        patientLists.addAll(AppUtil.getPatientListFromCursor(cursor));

        if (patientLists.size() != 0)
            recyclerView.setAdapter(new SplashAdapter(patientLists));
        else
            upcoming.setText("WELCOME \n NO UPCOMNING APPOINTMENT ");

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
    }
}
