package com.raja.bijenkorf.image;

public class Image {

    private String imageName;

    /**
     *
     */
    public Image() {
    }

    /**
     * @param image A string containing imageName name with extension
     */
    public Image(String image) {

        super();
        this.imageName = image;
    }

    /**
     * @return imageName variable containing imageName name with extension
     */
    public String getImageName() {

        return imageName;
    }

    /**
     * @param imageName A string containing imageName name with extension
     */
    public void setImageName(String imageName) {

        this.imageName = imageName;
    }
}
