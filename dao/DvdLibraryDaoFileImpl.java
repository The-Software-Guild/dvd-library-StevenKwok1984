package dao;
import dto.Dvd;

import dto.Dvd;
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
    }


    private void loadLib() throws DvdLibraryDaoException {
        Scanner sc;

        try {
            // Create scanner
            sc = new Scanner(
                    new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
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

    private Dvd unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];
        String releaseDate = dvdTokens[1];
        String mpaaRating = dvdTokens[2];
        String directorName = dvdTokens[3];
        String userRating = dvdTokens[4];
        String studio = dvdTokens[5];

        Dvd dvdFromFile = new Dvd(title);

    }

}
