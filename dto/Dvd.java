package dto;

import java.util.Date;

public class Dvd {
    private String title;
    private Date releaseDate;
    private String rating;
    private String directorName;
    private String studio;


    // methods
    // Override the method toString
    @Override
    public String toString() {
        return "Dvd{" + "title=" + title + ", releaseDate=" + releaseDate + ", rating=" + rating + ", directorName=" +
                directorName + ", studio=" + studio + '}';
    }

    // getter and setters


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

}
