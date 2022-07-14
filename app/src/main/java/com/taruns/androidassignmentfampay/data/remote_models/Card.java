package com.taruns.androidassignmentfampay.data.remote_models;

import java.net.URI;
import java.util.List;

public class Card {

    private String name, title, description, url, bg_color;
    private BgImage bg_image;
    private List<Cta> cta;
    private Icon icon;
    private FormattedTitle formatted_title;
    private FormattedDescription formatted_description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    private static class Icon {
        private String image_type;
        private String image_url;

        public String getImage_type() {
            return image_type;
        }

        public void setImage_type(String image_type) {
            this.image_type = image_type;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }

    private static class FormattedTitle {
        private String text;
        private String align;
        private List<Entities> entities;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public List<Entities> getEntities() {
            return entities;
        }

        public void setEntities(List<Entities> entities) {
            this.entities = entities;
        }
    }

    private static class FormattedDescription {
        private String text;
        private List<Entities> entities;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<Entities> getEntities() {
            return entities;
        }

        public void setEntities(List<Entities> entities) {
            this.entities = entities;
        }
    }

    private static class Entities {
        private String text;
        private String color;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    private static class BgImage {

        String image_url, image_type;
        Double aspect_ratio;

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImage_type() {
            return image_type;
        }

        public void setImage_type(String image_type) {
            this.image_type = image_type;
        }

        public Double getAspect_ratio() {
            return aspect_ratio;
        }

        public void setAspect_ratio(Double aspect_ratio) {
            this.aspect_ratio = aspect_ratio;
        }
    }

    private static class Cta {
        private String bg_color, text, text_color, url;

        public String getBg_color() {
            return bg_color;
        }

        public void setBg_color(String bg_color) {
            this.bg_color = bg_color;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText_color() {
            return text_color;
        }

        public void setText_color(String text_color) {
            this.text_color = text_color;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
