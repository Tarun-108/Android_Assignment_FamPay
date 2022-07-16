package com.taruns.androidassignmentfampay.data.remote_models;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

public class Card {

    private String name, title, description, url, bg_color;
    private BgImage bg_image;
    private List<Cta> cta;
    private Gradient bg_gradient;
    private Icon icon;
    private FormattedTitle formatted_title;
    private FormattedDescription formatted_description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBg_color() {
        return bg_color;
    }


    public Gradient getBg_gradient() {
        return bg_gradient;
    }

    public void setBg_gradient(Gradient bg_gradient) {
        this.bg_gradient = bg_gradient;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public BgImage getBg_image() {
        return bg_image;
    }

    public void setBg_image(BgImage bg_image) {
        this.bg_image = bg_image;
    }

    public List<Cta> getCta() {
        return cta;
    }

    public void setCta(List<Cta> cta) {
        this.cta = cta;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public FormattedTitle getFormatted_title() {
        return formatted_title;
    }

    public void setFormatted_title(FormattedTitle formatted_title) {
        this.formatted_title = formatted_title;
    }

    public FormattedDescription getFormatted_description() {
        return formatted_description;
    }

    public void setFormatted_description(FormattedDescription formatted_description) {
        this.formatted_description = formatted_description;
    }

    @BindingAdapter("imageURL")
    public static void loadImage(ImageView view, String url){
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter("backgroundColor")
    public static void changeBackgroundColor(CardView view, String bg_color){
        if(bg_color == null){
            bg_color = "#FBAF03";
        }
        view.setCardBackgroundColor(Color.parseColor(bg_color));
    }

    @BindingAdapter("onClick")
    public static void clickRedirect(CardView view, String url){

    }

    @BindingAdapter("layout_height")
    public static void setLayoutHeight(View view, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }





}
