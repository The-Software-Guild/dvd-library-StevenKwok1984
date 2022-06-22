package dao;

import dto.Dvd;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DvdLibraryDao {
    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    Dvd removeDvd(String title) throws DvdLibraryDaoException;

    Dvd changeReleaseDate(String title, Date releaseDate) throws DvdLibraryDaoException;

    Dvd changeMpaaRating(String title, String mpaaRating) throws DvdLibraryDaoException;

    Dvd changeDirectorName(String title, String directorName) throws DvdLibraryDaoException;

    Dvd changeStudioName(String title, String studioName) throws DvdLibraryDaoException;

    List <Dvd> getAllDvds () throws DvdLibraryDaoException;

    Dvd getDvd(String title) throws DvdLibraryDaoException;

    Map<String, Dvd> getDvdsLastYears(int years) throws DvdLibraryDaoException;

    Map<String, Dvd> getDvdsByMpaaRating(String mpaaRating) throws DvdLibraryDaoException;

    Map<String, Dvd> getDvdsByDirector(String directorName) throws DvdLibraryDaoException;

    Map<String, Dvd> getDvdsByStudio(String studioName) throws DvdLibraryDaoException;
}
