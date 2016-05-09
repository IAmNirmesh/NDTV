package nirmesh.ndtv.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import nirmesh.ndtv.R;
import nirmesh.ndtv.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    Runnable navigateToAppointment = new Runnable() {
        public void run() {
            Fragment fragment = new MainFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment).commitAllowingStateLoss();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigateToAppointment.run();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                finish();
            } else {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            super.onBackPressed();
        }else {
            Intent i = new Intent(this,SplashScreen.class);
            startActivity(i);
        }
    }

    public void callHome() {
        navigateToAppointment.run();
    }
}
