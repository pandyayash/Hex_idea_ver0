package com.example.yk.hex_idea.tabfragment;

/**
 * Created by Admin on 19-03-2017.
 */

public class Ideadetails_data {
    String Ideaid;
    String IdeaTitle;
    String Description;

    public Ideadetails_data(String ideaid, String ideaTitle, String description,String Category) {
        this.Ideaid = ideaid;
        this.IdeaTitle = ideaTitle;
        this.Description = description;
    }

    public String getIdeaid() {
        return Ideaid;
    }

    public void setIdeaid(String ideaid) {
        Ideaid = ideaid;
    }

    public String getIdeaTitle() {
        return IdeaTitle;
    }

    public void setIdeaTitle(String ideaTitle) {
        IdeaTitle = ideaTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
