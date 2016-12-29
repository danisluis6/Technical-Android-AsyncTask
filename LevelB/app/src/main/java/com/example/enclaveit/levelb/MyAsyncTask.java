package com.example.enclaveit.levelb;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by enclaveit on 29/12/2016.
 */

/**
 * You can understand:
 * Parameter 1: I will type of data to transport into MyAsyncTask().excute(X0 => it's X
 * Parameter 2: I will need type of data to update while automation excuting and show view/widget android
 * Parameter 3: I will need return result to show view => It will use in onPostExcute
 */

public class MyAsyncTask extends AsyncTask<Void,Integer,Void> {

    private MainActivity activity;

    public MyAsyncTask(MainActivity activity){
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(activity, "onPreExecute!",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        Toast.makeText(activity, "Update xong roi do!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        for(int i=0;i<=100;i++)
        {
            SystemClock.sleep(100);
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.progressBar);
        int giatri=values[0];
        progressBar.setProgress(giatri);
        TextView counter = (TextView) activity.findViewById(R.id.counter);
        counter.setText(giatri+"%");
    }
}
