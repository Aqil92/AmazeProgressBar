package com.aqil.amazingprogressbar;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.aqil.useprogress.CustomProgress;

/**
 * Created by localadmin on 5/23/2018.
 */

public class MainActivityImp {
  private   CustomProgress customProgress;
    private Context context;

    public MainActivityImp(Context context) {
        this.context = context;
        customProgress=new CustomProgress(context);
        customProgress.setMax(500);
        customProgress.show();
        /*if we use for loop here so it won,t work because of speed of loop*/
        showLoader(1);
    }

    private   void showLoader(int i){

        customProgress.setProgress(i);
        customProgress.setLabel("loading content");
        if(i>30)
            customProgress.setLabel("loading Value");
        else if(i>50)
            customProgress.setLabel("loading 50");
        else if(i>70)
            customProgress.setLabel("loading 70s");
        else if(i>90)
            customProgress.setLabel("loading 90s");

        customProgress.setCurrentValue("Content"+i);

        i++;
        final int count=i;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(count<501)
                    showLoader(count);
                else{
                    customProgress.dismiss();

                    Toast.makeText(context, "Loading Completed!", Toast.LENGTH_SHORT).show();
                }
            }
        },10);

    }
}
