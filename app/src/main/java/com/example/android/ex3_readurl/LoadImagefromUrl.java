package com.example.android.ex3_readurl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Krivnon on 2016-07-04.
 */


public class LoadImagefromUrl extends AsyncTask<Object,Void,Bitmap> {
    ImageView iv = null;

    @Override
    protected Bitmap doInBackground(Object... objects) {
        this.iv = (ImageView) objects[0];
        String url = (String) objects[1];

        return loadBitmap(url);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        iv.setImageBitmap(bitmap);
    }
    public Bitmap loadBitmap(String url){
        URL newurl = null;
        Bitmap bitmap =null;
        try {
            newurl = new URL(url);
            bitmap = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
