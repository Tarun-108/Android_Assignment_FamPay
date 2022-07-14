package com.taruns.androidassignmentfampay.data.remote_models;

import java.net.URL;

public class Card {

    private String name, title, description;
    private URL url;
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

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
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

    private class Icon {
        private String image_type;
        private URL image_url;

        public String getImage_type() {
            return image_type;
        }

        public void setImage_type(String image_type) {
            this.image_type = image_type;
        }

        public URL getImage_url() {
            return image_url;
        }

        public void setImage_url(URL image_url) {
            this.image_url = image_url;
        }
    }

    private class FormattedTitle {
        private String text;
        private Entities entities;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Entities getEntities() {
            return entities;
        }

        public void setEntities(Entities entities) {
            this.entities = entities;
        }

    }

    private class FormattedDescription {
        private String text;
        private Entities entities;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Entities getEntities() {
            return entities;
        }

        public void setEntities(Entities entities) {
            this.entities = entities;
        }
    }

    private class Entities {
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
}
