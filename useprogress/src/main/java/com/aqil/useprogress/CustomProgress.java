package com.aqil.useprogress;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;


/**
 * Created by aqil on 4/9/2016.
 */


public class CustomProgress extends Dialog {

    TextView tvCompleted;
    TextView tvFilename;
    TextView tvStatus;
    TextView tvTotal;
    TextView tvDots;

    HorizontalProgressBar animateHorizontalProgressBar;

    Handler mhandler;

    int counter = 0;


    public CustomProgress(Context context) {
        super(context);
        init();
        // TODO Auto-generated constructor stub
    }

    public void setMax(int max) {
        animateHorizontalProgressBar.setMax(max);
        tvTotal.setText(String.valueOf(max));
    }

    public  void setProgress(int progress){
        animateHorizontalProgressBar.setProgress(progress);
        tvCompleted.setText(String.valueOf(progress));
    }

    @Override
    public  void show(){
        super.show();
        startDotLoader();
    }

    public void setLabel(String label){
        tvStatus.setText(label);
    }

    public void setCurrentValue(String contentValue) {
        tvFilename.setText(contentValue);
    }

    public void init() {
        mhandler = new Handler();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.amazingloader);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        tvDots = findViewById(R.id.dot);
        tvStatus = findViewById(R.id.tvstatus);
        tvTotal = findViewById(R.id.total);
        tvCompleted = findViewById(R.id.got);
        animateHorizontalProgressBar = findViewById(R.id.animate_progress_bar);
        tvFilename = findViewById(R.id.file);

    }

    private void startDotLoader() {
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                counter++;
                if (counter == 1) {
                    tvDots.setText(".");
                } else if (counter == 2) {
                    tvDots.setText("..");
                } else if (counter == 3) {
                    tvDots.setText("...");
                } else if (counter == 4) {
                    tvDots.setText("");
                } else {
                    counter = 0;
                }

                startDotLoader();

            }
        }, 500);

    }

}
