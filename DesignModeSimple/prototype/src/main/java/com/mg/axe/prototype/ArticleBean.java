package com.mg.axe.prototype;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Axe on 2017/9/27.
 * 保证这个文章是不能被其他包下的
 */

public class ArticleBean implements Cloneable {

    /**
     * 文章的内容
     */
    private String text;

    /**
     * 文章的标题
     */
    private String title;

    /**
     * 文章的图片附件
     */
    private ArrayList<String> images = new ArrayList<>();

    @Override
    public ArticleBean clone() {
        try {
            ArticleBean articleBean = (ArticleBean) super.clone();
            articleBean.text = this.text;
            articleBean.title = this.title;
            articleBean.images = (ArrayList<String>) this.images.clone();
            return articleBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return title + "   " + text + "   " + images.toString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
