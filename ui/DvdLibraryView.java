package ui;

import dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DvdLibraryView {
    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndStart() {
        io.print("Main Menu");
        io.print("1. Add new DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List all DVDS ");
        io.print("5. Display DVD information");
        io.print("6. Find DVDs");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1,7);
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Enter the DVD title");
        LocalDate releaseDate = io.readDate("Enter the DVD release date");
        String mpaaRating = io.readString("Enter the MPAA rating");
        String directorName = io.readString("Enter the director's name");
        String userRating = io.readString("Enter your rating of the DVD");
        String studio = io.readString("Enter the DVD studio");

        //Instantiating a new DVD object using the title to satisfy the constructors requirements
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setUserRating(userRating);
        currentDvd.setStudio(studio);
        // return DVD for further action
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created. Hit enter to continue");
    }

    public void displayDvdList(List <Dvd> dvdList) {
        String dvdHeadings = String.format("%25s | %12s | %4s | %17s | %7s | %25s",
                "Title",
                "Release Date",
                "MPAA",
                "Director Name",
                "Rating",
                "Studio");
        io.print(dvdHeadings);
        io.print("-----------------------------------------------------------------------------------------------------------------");

        for (Dvd currentDvd: dvdList){
            String dvdInfo = String.format("%25s | %12s | %4s | %17s | %7s | %25s",
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getDirectorName(),
                    currentDvd.getUserRating(),
                    currentDvd.getStudio());
            io.print(dvdInfo);
        }
        io.readString("Press enter to continue");
    }















}
