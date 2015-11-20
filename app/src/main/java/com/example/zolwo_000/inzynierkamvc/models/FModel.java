package com.example.zolwo_000.inzynierkamvc.models;

import com.example.zolwo_000.inzynierkamvc.Views.FView;

import java.util.ArrayList;

/**
 * Created by zolwo_000 on 17.11.2015.
 */
public class FModel<V extends FView> {
    private ArrayList<V> views;
    public FModel(){
        views = new ArrayList<V>();
    }
    public void addView(V view) {
        if(!views.contains(view)) {
            views.add(view);
        }
    }
    public void deleteView(V view) {
        views.remove(view);
    }
    public void notifyViews(){
        for(V view: views) {
            view.update(this);
        }
    }
}
