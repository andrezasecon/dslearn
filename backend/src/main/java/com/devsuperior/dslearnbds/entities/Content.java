package com.devsuperior.dslearnbds.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_content")
public class Content extends Lesson{
    private static final long SerialVersionUID = 1L;

    private String textConten;
    private String videoUri;


    public Content() {
    }

    public Content(Long id, String title, Integer position, Section section, String textConten, String videoUri) {
        super(id, title, position, section);
        this.textConten = textConten;
        this.videoUri = videoUri;
    }

    public String getTextConten() {
        return textConten;
    }

    public void setTextConten(String textConten) {
        this.textConten = textConten;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }
}
