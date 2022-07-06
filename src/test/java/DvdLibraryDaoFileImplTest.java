package src.test.java;

import org.junit.jupiter.api.*;
import src.main.com.sg.dvdlibrary.dao.DvdLibraryDao;
import src.main.com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import src.main.com.sg.dvdlibrary.dto.Dvd;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

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

    @Test
    public void testAddGetAllDvds() throws Exception {
        // ASSERT
        // Create our first dvd
        Dvd firstDvd = new Dvd("Mean Girls");
        firstDvd.setReleaseDate(LocalDate.parse("2004-05-19"));
        firstDvd.setMpaaRating("12A");
        firstDvd.setDirectorName("Mark Waters");
        firstDvd.setUserRating("10");
        firstDvd.setStudio("name");
        // Create second dvd
        Dvd secondDvd = new Dvd("Greenland");
        secondDvd.setReleaseDate(LocalDate.parse("2021-02-05"));
        secondDvd.setMpaaRating("15");
        secondDvd.setDirectorName("Ric Roman Waugh");
        secondDvd.setUserRating("6.4");
        secondDvd.setStudio("Thunder Road Pictures");

        // ACT
        // Add both our students to the DAO
        testDao.addDvd(firstDvd.getTitle(), firstDvd);
        testDao.addDvd(secondDvd.getTitle(), secondDvd);

        // Retrieve the list of all students within the DAO
        List<Dvd> allDvds = testDao.getAllDvds();

        // ASSERT
        // First check the general contents of the list
        assertNotNull(allDvds, "The list of dvds must not null");
        assertEquals(2, allDvds.size(),"List of dvds should have 2 dvds.");

        // Then the specifics
        assertTrue(testDao.getAllDvds().contains(firstDvd),
                "The list of students should include Mean Girls.");
        assertTrue(testDao.getAllDvds().contains(secondDvd),
                "The list of students should include Greenland.");
    }

    @Test
    public void testRemoveDvd() throws Exception {
        // ASSERT
        // Create our first dvd
        Dvd firstDvd = new Dvd("Mean Girls");
        firstDvd.setReleaseDate(LocalDate.parse("2004-05-19"));
        firstDvd.setMpaaRating("12A");
        firstDvd.setDirectorName("Mark Waters");
        firstDvd.setUserRating("10");
        firstDvd.setStudio("name");
        // Create second dvd
        Dvd secondDvd = new Dvd("Greenland");
        secondDvd.setReleaseDate(LocalDate.parse("2021-02-05"));
        secondDvd.setMpaaRating("15");
        secondDvd.setDirectorName("Ric Roman Waugh");
        secondDvd.setUserRating("6.4");
        secondDvd.setStudio("Thunder Road Pictures");

        // ACT
        // Add both our students to the DAO
        testDao.addDvd(firstDvd.getTitle(), firstDvd);
        testDao.addDvd(secondDvd.getTitle(), secondDvd);
        // remove the first student - Ada
        Dvd removedDvd = testDao.removeDvd(firstDvd.getTitle());
        // Get all the students
        List<Dvd> allDvds = testDao.getAllDvds();

        // ASSERT

        // Check that the correct object was removed.
        assertEquals(removedDvd, firstDvd, "The removed dvd should be Mean Girls.");

        // First check the general contents of the list
        assertNotNull( allDvds, "All dvds list should be not null.");
        assertEquals( 1, allDvds.size(), "All dvds should only have 1 dvd.");

        // Then the specifics
        assertFalse( allDvds.contains(firstDvd), "All dvds should NOT include Mean Girls.");
        assertTrue( allDvds.contains(secondDvd), "All students should NOT include Greenland.");
    }

    @Test
    public void testChangeDvd() throws Exception {
        // ASSERT
        // Create our first dvd
        Dvd dvd = new Dvd("Mean Girls");
        dvd.setReleaseDate(LocalDate.parse("2004-05-19"));
        dvd.setMpaaRating("12A");
        dvd.setDirectorName("Mark Waters");
        dvd.setUserRating("10");
        dvd.setStudio("name");
        // create a copy
        Dvd dvdCopy = dvd;

        // ACT
        // Add both our students to the DAO
        testDao.addDvd(dvd.getTitle(), dvd);
        // change the LocalDate
        testDao.changeReleaseDate(dvd.getTitle(), LocalDate.parse("2012-10-16"));
        // change the mpaa rating
        testDao.changeMpaaRating(dvd.getTitle(), "12B");
        // change director name
        testDao.changeDirectorName(dvd.getTitle(), "Boris Johnson");
        // change user rating
        testDao.changeUserRating(dvd.getTitle(), "8");
        // change studio name
        testDao.changeStudioName(dvd.getTitle(), "Royal Mail");

        // ASSERT
        // Check that is the date changed
        assertEquals(LocalDate.parse("2012-10-16"), testDao.getDvd(dvd.getTitle()).getReleaseDate(),
                "The date should be 2012-10-16.");
        assertNotEquals(dvdCopy.getReleaseDate(), testDao.getDvd(dvd.getTitle()).getReleaseDate(),
                "the date should not be 2004-05-19");

        // check if the mpaa rating changed
        assertEquals("12B", testDao.getDvd(dvd.getTitle()).getMpaaRating(),
                "The date should be 12B");
        assertNotEquals(dvdCopy.getMpaaRating(), testDao.getDvd(dvd.getTitle()).getMpaaRating(),
                "the date should not be 12A");

        // Check is the director name change
        assertEquals("Boris Johnson", testDao.getDvd(dvd.getTitle()).getDirectorName(),
                "The director name should be Boris Johnson");
        assertNotEquals(dvdCopy.getDirectorName(), testDao.getDvd(dvd.getTitle()).getDirectorName(),
                "the date should not be Mark Waters");

        // Check is the user rating changed
        assertEquals("8", testDao.getDvd(dvd.getTitle()).getUserRating(),
                "The user rating should be 8");
        assertNotEquals(dvdCopy.getUserRating(), testDao.getDvd(dvd.getTitle()).getUserRating(),
                "the date should not be 10");

        // Check is the studio name changed
        assertEquals("Royal Mail", testDao.getDvd(dvd.getTitle()).getStudio(),
                "The studio name should be Royal Mail");
        assertNotEquals(dvdCopy.getStudio(), testDao.getDvd(dvd.getTitle()).getStudio(),
                "the date should not be name");

    }

}