package src.main.com.sg.dvdlibrary.controller;

import src.main.com.sg.dvdlibrary.dao.DvdLibraryDao;
import src.main.com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import src.main.com.sg.dvdlibrary.dto.Dvd;
import src.main.com.sg.dvdlibrary.ui.DvdLibraryView;
import java.time.LocalDate;
import java.util.List;


public class DvdLibraryController {

    private DvdLibraryView view;
    private DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws DvdLibraryDaoException {
        boolean continueUsing = true;
        int menuSelection = 0;

        try{
            while(continueUsing)  {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        getDvd();
                        break;
                    case 6:
                        continueUsing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            // print exist message
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndStart();
    }

    private void createDvd()throws DvdLibraryDaoException {

        int addingTimes = view.getNumOfTime();
        view.displayCreateDvdBanner();
        for (int i = 0; i < addingTimes; i++) {
            Dvd newDvd = view.getNewDvdInfo();
            dao.addDvd(newDvd.getTitle(), newDvd);
            view.displayCreateSuccessBanner();
        }



    }
    private void listDvds() throws DvdLibraryDaoException {
        view.displayDvdListBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    private void getDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }
    private void removeDvd() throws DvdLibraryDaoException {
        int removeTimes = view.getNumOfTime();
        view.displayRemoveDvdBanner();

        for (int i = 0; i < removeTimes; i++) {
            String title = view.getDvdTitleChoice();
            Dvd removedDvd = dao.removeDvd(title);
            view.displayRemoveResult(removedDvd);
            if ( i < removeTimes-1) {
                view.nextOne();
            }
        }
    }
    private void exitMessage() {
        view.displayExitBanner();
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    /*
    Dvd Edit method
     */
    private void editDvd() throws DvdLibraryDaoException {
        int editingTimes = view.getNumOfTime();

        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvdToEdit = dao.getDvd(title);
        if (dvdToEdit == null) {
            view.displayNullDvd();
        } else {
            view.displayDvd(dvdToEdit);
            for (int i = 0; i < editingTimes; i++) {
                int editMenuSelection = 0;
                boolean continueUsing = true;

                while (continueUsing) {
                    editMenuSelection = view.printEditMenuForSelection();

                    switch (editMenuSelection) {
                        case 1:
                            editReleaseDate(title);
                            break;
                        case 2:
                            editMpaaRating(title);
                        case 3:
                            editDirectorName(title);
                            break;
                        case 4:
                            editUserRating(title);
                            break;
                        case 5:
                            editStudioName(title);
                            break;
                        case 6:
                            continueUsing = false;
                            break;
                        default:
                            unknownCommand();
                    }
                    if (continueUsing == false) {
                        break;
                    }
                }
                if (i < editingTimes - 1) {
                    view.nextOne();
                }
            }
        }
    }

    private void editReleaseDate(String title) throws DvdLibraryDaoException {
        view.displayEditReleaseDateBanner();
        LocalDate newReleaseDate = view.getReleaseDate();
        Dvd editedDvd = dao.changeReleaseDate(title, newReleaseDate);
        view.displayEditResult();
    }

    private void editMpaaRating(String title) throws DvdLibraryDaoException {
        //view.displayEditMpaRatingBanner();
        String newMpaaRating = view.getMpaaRating();
        Dvd editedDvd = dao.changeMpaaRating(title, newMpaaRating);
        view.displayEditResult();
    }

    private void editDirectorName(String title) throws DvdLibraryDaoException {
        //view.displayEditDirectorNameBanner();
        String newDirectorName = view.getDirectorName();
        Dvd editedDvd = dao.changeDirectorName(title, newDirectorName);
        view.displayEditResult();
    }
    private void editUserRating(String title) throws DvdLibraryDaoException {
        String newUserRating = view.getUserRating();
        Dvd editedDvd = dao.changeUserRating(title, newUserRating);
        view.displayEditResult();
    }
    private void editStudioName(String title) throws DvdLibraryDaoException {
        String newStudioName = view.getStudioName();
        Dvd editedDvd = dao.changeStudioName(title, newStudioName);
        view.displayEditResult();
    }





}
