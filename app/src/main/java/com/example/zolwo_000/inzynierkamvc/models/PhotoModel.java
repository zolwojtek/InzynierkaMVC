package com.example.zolwo_000.inzynierkamvc.models;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import com.example.zolwo_000.inzynierkamvc.utils.PhotoParameters;
import com.example.zolwo_000.inzynierkamvc.R;
import com.example.zolwo_000.inzynierkamvc.views.FView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class PhotoModel extends FModel<FView> {
    private ImageView imageView;
    private String name;
    private FrameLayout frameLayout;
    //private int photoId;

    public FrameLayout getFrameLayout() {
        return frameLayout;
    }

    public void setFrameLayout(FrameLayout frameLayout) {
        this.frameLayout = frameLayout;
    }

    public PhotoParameters getPhotoParameters() {
        return photoParameters;
    }

    public void setPhotoParameters(PhotoParameters photoParameters) {
        this.photoParameters = photoParameters;
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(photoParameters.getPhotoWidth(), photoParameters.getPhotoHeight());
        layoutParams.setMargins(0, photoParameters.getRowMargin(), photoParameters.getColumnMargin(), 0);
        frameLayout.setLayoutParams(layoutParams);
    }

    private PhotoParameters photoParameters;


    public PhotoModel(String name) {
        this.name = name;

    }

    public void setImageViewInTable(Activity activity){
        //int photoId = activity.getResources().getIdentifier(name, "drawable", activity.getPackageName());
        File file = new File(name);
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        imageView = new ImageView(activity);
        //imageView.setImageResource(photoId);
        imageView.setImageBitmap(bitmap);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        imageView.setBackgroundColor(Color.WHITE);
        frameLayout = new FrameLayout(activity);
        frameLayout.addView(imageView);
        setBorder(3);
    }

    public void setExposedImageView(Activity activity){
        //int photoId = activity.getResources().getIdentifier(name, "drawable", activity.getPackageName());
        File file = new File(name);
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        RelativeLayout layout = (RelativeLayout) activity.findViewById(R.id.correctPhotoRelativeLayout);
        imageView = new ImageView(activity);
        RelativeLayout.LayoutParams imageLayoutParams = new RelativeLayout.LayoutParams(screenWidth-200, screenHeight-250);
        imageLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        imageView.setLayoutParams(imageLayoutParams);
        imageView.setBackgroundColor(Color.WHITE);
        //imageView.setImageResource(photoId);
        imageView.setImageBitmap(bitmap);
        layout.addView(imageView);



    }




    public void setBorder(int borderWidth) {
        frameLayout.setPadding(borderWidth, borderWidth, borderWidth, borderWidth);
        frameLayout.setBackgroundColor(Color.BLACK);
    }

    public void setOnClickListener(View.OnClickListener photoClickListener)
    {
        imageView.setOnClickListener(photoClickListener);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setPhotoAlpha(int alpha) {
        imageView.setImageAlpha(alpha);
    }

    //--------------TYNCZASOWE--------------//
    private Activity activity = null;
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
