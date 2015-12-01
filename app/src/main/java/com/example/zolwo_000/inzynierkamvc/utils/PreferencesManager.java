package com.example.zolwo_000.inzynierkamvc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.zolwo_000.inzynierkamvc.models.ConfigurationModel;

/**
 * Created by Klaudia on 2015-11-06.
 */
public class PreferencesManager {

    SharedPreferences shared;
    public ConfigurationModel config;

    public PreferencesManager(SharedPreferences shared, ConfigurationModel config) {
        this.shared = shared;
        this.config = config;
    }

    public void save() {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("mode", config.getMode());
        editor.putInt("responseTime", config.getResponseTime());
        editor.putString("hintType", config.getHintType());
        editor.putInt("displayCount", config.getDisplayCount());
        editor.putString("level", config.getLevel());
        editor.putString("proportions", config.getProportions());

        editor.commit();
    }

    public void read() {
        config.setMode(shared.getString("mode", "auto"));
        config.setHintType(shared.getString("hintType", "fade"));
        config.setDisplayCount(shared.getInt("displayCount", 3));
        config.setResponseTime(shared.getInt("responseTime", 5));
        config.setLevel(shared.getString("level", "poziom1"));
        config.setProportions(shared.getString("proportions", "1:0"));
    }
}