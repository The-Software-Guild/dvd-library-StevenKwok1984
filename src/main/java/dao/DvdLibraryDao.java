package dao;

import src.main.dto.Dvd;

import java.time.LocalDate;
import java.util.List;

public interface DvdLibraryDao {

    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    Dvd removeDvd(String title) throws DvdLibraryDaoException;

    Dvd changeReleaseDate(String title, LocalDate releaseDate)throws DvdLibraryDaoException;

    Dvd changeMpaaRating(String title, String mpaaRating) throws DvdLibraryDaoException;

    Dvd changeDirectorName(String title, String directorName) throws DvdLibraryDaoException;

    Dvd changeStudioName(String title, String studioName) throws DvdLibraryDaoException;

    List <Dvd> getAllDvds () throws DvdLibraryDaoException;

    Dvd getDvd(String title) throws DvdLibraryDaoException;


    Dvd changeUserRating(String title, String newUserRating) throws DvdLibraryDaoException;
}
