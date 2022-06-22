package dao;
import dto.Dvd;

import java.time.LocalDate;
import java.util.*;
import java.io.*;


public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    private Map<String, Dvd> dvds = new HashMap<>();

    private final String LIBRARY_FILE;

    private final String DELIMITER = "::";

    public DvdLibraryDaoFileImpl() {
        LIBRARY_FILE = "DvdLibrary.txt";
    }

    // For testing
    public DvdLibraryDaoFileImpl(String libraryTextFile) {
        LIBRARY_FILE = libraryTextFile;
    }

    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        // load library
        loadLib();
        // add new DVD to HashMap
        Dvd newDvd = dvds.put(title, dvd);
        // writes all the DVDs in the DVD library out to a LIBRARY_FILE.
        writeLibrary();
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        loadLib();
        Dvd removedDvd = dvds.remove(title);
        writeLibrary();
        return removedDvd;
    }

    // show dvds
    @Override
    public  List<Dvd> getAllDvds() throws DvdLibraryDaoException{
        loadLib();
        return new ArrayList(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        loadLib();
        return dvds.get(title);
    }

    @Override
    public Dvd changeReleaseDate(String title, LocalDate releaseDate)throws DvdLibraryDaoException {
        loadLib();
        return dvds.get(title);
    }

    @Override
    public  Dvd changeMpaaRating(String title, String mappRating) throws DvdLibraryDaoException {
        loadLib();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setMpaaRating(mappRating);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd changeDirectorName(String title, String directorName) throws DvdLibraryDaoException {
        loadLib();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setDirectorName(directorName);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd changeUserRating(String title, String userRating) throws DvdLibraryDaoException {
        loadLib();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setUserRating(userRating);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd changeStudioName(String title, String studioName) throws DvdLibraryDaoException {
        loadLib();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setStudio(studioName);
        writeLibrary();
        return dvdToEdit;
    }






    /*
      Load and Write Lib session
     */
    private void loadLib() throws DvdLibraryDaoException {
        Scanner sc;

        try {
            // Create scanner
            sc = new Scanner(
                    new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException("-_- Could not load roster data into memory.", e);
        }

        String currentLine;
        Dvd currentDvd;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentDvd = unmarshallDvd(currentLine);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }

        sc.close();
    }

    private void writeLibrary() throws  DvdLibraryDaoException {
        PrintWriter output;

        try {
            output = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save DVD data",e);
        }
        // create properties required
        String dvdAsText;
        List <Dvd> dvdList = this.getAllDvds();

        for(Dvd currentDvd : dvdList) {
            // turn a Dvd into a String
            dvdAsText = marshallDvd(currentDvd);
            // write the DVD object to the file
            output.println(dvdAsText);
            output.flush();
        }
        // clean up
        output.close();

    }

    /**
     * marshalling & Marshalling
     */
    private String marshallDvd(Dvd aDvd) {
        String dvdAsText = aDvd.getTitle() + DELIMITER;
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;
        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        dvdAsText += aDvd.getUserRating() + DELIMITER;
        dvdAsText += aDvd.getStudio();
        // return for writing into text file
        return dvdAsText;
    }

    private Dvd unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];
        String releaseDate = dvdTokens[1];
        String mpaaRating = dvdTokens[2];
        String directorName = dvdTokens[3];
        String userRating = dvdTokens[4];
        String studio = dvdTokens[5];

        Dvd dvdFromFile = new Dvd(title);

        dvdFromFile.setReleaseDate(LocalDate.parse(releaseDate));
        dvdFromFile.setMpaaRating(mpaaRating);
        dvdFromFile.setDirectorName(directorName);
        dvdFromFile.setUserRating(userRating);
        dvdFromFile.setStudio(studio);
        // return the file for saving
        return dvdFromFile;
    }

}
