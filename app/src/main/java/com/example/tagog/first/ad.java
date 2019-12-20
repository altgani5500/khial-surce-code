package com.example.tagog.first;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import java.util.List;
import java.util.Map;

@TargetApi(Build.VERSION_CODES.M)
public class ad extends b implements Filterable, ThemedSpinnerAdapter {
    public ad(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        throw new RuntimeException("Stub!");
    }

    public int getCount() {
        throw new RuntimeException("Stub!");
    }

    public Object getItem(int position) {
        throw new RuntimeException("Stub!");
    }

    public long getItemId(int position) {
        throw new RuntimeException("Stub!");
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    public void setDropDownViewResource(int resource) {
        throw new RuntimeException("Stub!");
    }

    public void setDropDownViewTheme(Resources.Theme theme) {
        throw new RuntimeException("Stub!");
    }

    public Resources.Theme getDropDownViewTheme() {
        throw new RuntimeException("Stub!");
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    public android.widget.SimpleAdapter.ViewBinder getViewBinder() {
        throw new RuntimeException("Stub!");
    }

    public void setViewBinder(android.widget.SimpleAdapter.ViewBinder viewBinder) {
        throw new RuntimeException("Stub!");
    }

    public void setViewImage(ImageView v, int value) {
        throw new RuntimeException("Stub!");
    }

    public void setViewImage(ImageView v, String value) {
        throw new RuntimeException("Stub!");
    }

    public void setViewText(TextView v, String text) {
        throw new RuntimeException("Stub!");
    }

    public Filter getFilter() {
        throw new RuntimeException("Stub!");
    }

    public interface ViewBinder {
        boolean setViewValue(View var1, Object var2, String var3);
    }
}
