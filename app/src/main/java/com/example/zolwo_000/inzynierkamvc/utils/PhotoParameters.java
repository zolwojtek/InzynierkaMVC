package com.example.zolwo_000.inzynierkamvc.utils;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class PhotoParameters {
    private int photoWidth;
    private int photoHeight;
    private int rowMargin;
    private int columnMargin;

    public PhotoParameters() {

    }

    public PhotoParameters(int photoWidth, int photoHeigh, int rowMargin, int columnMargin) {
        this.photoWidth = photoWidth;
        this.columnMargin = columnMargin;
        this.rowMargin = rowMargin;
        this.photoHeight = photoHeigh;
    }

    public int getPhotoWidth() {
        return photoWidth;
    }

    public void setPhotoWidth(int photoWidth) {
        this.photoWidth = photoWidth;
    }

    public int getPhotoHeight() {
        return photoHeight;
    }

    public void setPhotoHeight(int photoHeight) {
        this.photoHeight = photoHeight;
    }

    public int getRowMargin() {
        return rowMargin;
    }

    public void setRowMargin(int rowMargin) {
        this.rowMargin = rowMargin;
    }

    public int getColumnMargin() {
        return columnMargin;
    }

    public void setColumnMargin(int columnMargin) {
        this.columnMargin = columnMargin;
    }
}
