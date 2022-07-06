import src.main.java.controller.DvdLibraryController;
import src.main.dao.DvdLibraryDao;
import src.main.dao.DvdLibraryDaoException;
import src.main.dao.DvdLibraryDaoFileImpl;
import src.main.ui.DvdLibraryView;
import src.main.ui.UserIO;
import src.main.ui.UserIOConsoleImpl;


public class App {
    public static void main(String[] args) throws DvdLibraryDaoException {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);

        controller.run();
    }
}
