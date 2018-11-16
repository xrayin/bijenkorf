package com.raja.bijenkorf.image;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image {

    /**
     *
     */
    @Id
    private String image;

    /**
     *
     */
    public Image() {
    }

    /**
     *
     * @param image A string containing image name with extension
     */
    public Image(String image) {

        super();
        this.image = image;
    }

    /**
     *
     * @return image variable containing image name with extension
     */
    public String getImage() {

        return image;
    }

    /**
     *
     * @param image A string containing image name with extension
     */
    public void setImage(String image) {

        this.image = image;
    }
}
