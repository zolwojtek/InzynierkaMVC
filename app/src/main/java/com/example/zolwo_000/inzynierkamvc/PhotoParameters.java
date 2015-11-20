package com.example.zolwo_000.inzynierkamvc;

/**
 * Created by zolwo_000 on 18.11.2015.
 */
public class PhotoParameters {
    private int photoWidth;
    private int photoHeigh;
    private int rowMargin;
    private int columnMargin;

    public PhotoParameters() {

    }

    public PhotoParameters(int photoWidth, int photoHeigh, int rowMargin, int columnMargin) {
        this.photoWidth = photoWidth;
        this.columnMargin = columnMargin;
        this.rowMargin = rowMargin;
        this.photoHeigh = photoHeigh;
    }

    public int getPhotoWidth() {
        return photoWidth;
    }

    public void setPhotoWidth(int photoWidth) {
        this.photoWidth = photoWidth;
    }

    public int getPhotoHeigh() {
        return photoHeigh;
    }

    public void setPhotoHeigh(int photoHeigh) {
        this.photoHeigh = photoHeigh;
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
