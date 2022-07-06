package src.test.java;

import org.junit.jupiter.api.*;
import src.main.dao.DvdLibraryDao;
import src.main.dao.DvdLibraryDaoFileImpl;
import src.main.dto.Dvd;

import java.io.FileWriter;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DvdLibraryDaoFileImplTest {

    DvdLibraryDao testDao;
    public DvdLibraryDaoFileImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "DvdLibraryTestFile.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new DvdLibraryDaoFileImpl(testFile);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetDvd() throws Exception {
        // Create our method test inputs
        String title = "Mean Girls";
        Dvd dvd = new Dvd(title);
        dvd.setReleaseDate(LocalDate.parse("2004-05-19"));
        dvd.setMpaaRating("12A");
        dvd.setDirectorName("Mark Waters");
        dvd.setUserRating("10");
        dvd.setStudio("name");

        //  Add the student to the DAO
        testDao.addDvd(dvd.getTitle(), dvd);
        // Get the student from the DAO
        Dvd retrievedDvd = testDao.getDvd(title);

        // Check the data is equal
        assertEquals(dvd.getTitle(),
                retrievedDvd.getTitle(),
                "Error: the title should be Mean Girls.");
        assertEquals(dvd.getReleaseDate(),
                retrievedDvd.getReleaseDate(),
                "Error: the release date should be 2004-05-19.");
        assertEquals(dvd.getMpaaRating(),
                retrievedDvd.getMpaaRating(),
                "Error: the mpaa rating should be 12A.");
        assertEquals(dvd.getDirectorName(),
                retrievedDvd.getDirectorName(),
                "Error: the director name should be Mark Waters.");
        assertEquals(dvd.getUserRating(),
                retrievedDvd.getUserRating(),
                "Error: the user rating should be 10.");
        assertEquals(dvd.getStudio(),
                retrievedDvd.getStudio(),
                "Error: the studio should be name.");
    }
}