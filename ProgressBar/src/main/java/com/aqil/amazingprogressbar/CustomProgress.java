package com.aqil.amazingprogressbar;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;


/**
 * Created by admin on 4/9/2016.
 */


public class CustomProgress extends Dialog {

    TextView tvCompleted;
    TextView tvFilename;
    TextView tvStatus;
    TextView tvTotal;
    TextView tvDots;

    AnimateHorizontalProgressBar animateHorizontalProgressBar;

    Handler mhandler;

    int count = 0;


   public CustomProgress(Context context) {
       super(context);
       init();
       // TODO Auto-generated constructor stub
   }

   public  void setMax(int max){
       animateHorizontalProgressBar.setMax(max);
       tvTotal.setText(String.valueOf(max));
   }

    public  void setProgress(int progress){
        animateHorizontalProgressBar.setProgress(progress);
        tvCompleted.setText(String.valueOf(progress));
    }

    public void setLabel(String label){
        tvStatus.setText(label);
    }

   void init(){
       mhandler = new Handler();
       setContentView(R.layout.amazingloader);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
       setCancelable(false);
       setCanceledOnTouchOutside(false);
       tvDots = (TextView) findViewById(R.id.dot);
       tvStatus = (TextView) findViewById(R.id.tvstatus);
       tvTotal = (TextView) findViewById(R.id.total);
       tvCompleted = (TextView) findViewById(R.id.got);
       animateHorizontalProgressBar = (AnimateHorizontalProgressBar) findViewById(R.id.animate_progress_bar);
       tvFilename = (TextView) findViewById(R.id.file);
       startDotLoader();
   }

   private  void startDotLoader() {
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                count++;
                if (count == 1) {
                    tvDots.setText(".");
                } else if (count == 2) {
                    tvDots.setText("..");
                } else if (count == 3) {
                    tvDots.setText("...");
                } else if (count == 4) {
                    tvDots.setText("");
                } else {
                    count = 0;
                }

                startDotLoader();

            }
        }, 500);

    }

}
