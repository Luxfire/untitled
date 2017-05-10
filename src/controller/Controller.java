package controller;
import controller.listeners.fileListeners.OpenFileListener;
import controller.listeners.fileListeners.SaveFileListener;
import controller.listeners.tableListeners.*;
import controller.listeners.studentListeners.AddStudentListener;
import controller.listeners.studentListeners.DelListener;
import controller.listeners.studentListeners.SearchListener;
import model.*;
import view.*;

/**
 * Created by user on 11.04.2017.
 */
public class Controller {
    private MainWindow mainWindow;
    private StudentList studentList;
    private StudentList studentSearchList;
    private UpdateWindow updateMainWindow;
    private UpdateWindow updateSearchWindow;
    private FileWorker fileWorker;

    public Controller() {
        studentSearchList = new StudentList();
        studentList = new StudentList();

        mainWindow = new MainWindow(studentList.getMaxNumberOfSemestre());

        updateMainWindow = new UpdateWindow(mainWindow.getFrame(),mainWindow.getTableModel(),studentList);
        updateSearchWindow = new UpdateWindow(mainWindow.getFrameSearch().getFrameSearch(),mainWindow.getFrameSearch().getTableSearchModel(),studentSearchList);

        fileWorker = new FileWorker(studentList);

        createStudentListeners();
        createMainWindowListeners();
        createSearchFrameListeners();
        createFileListeners();

    }
             void  createStudentListeners()
             {
                 AddStudentListener addStudentAction = new AddStudentListener(mainWindow,studentList,updateMainWindow);
                 mainWindow.getFrameAddStudent().getButtonAdd().addActionListener(addStudentAction);

                 SearchListener searchListener = new SearchListener(studentList,studentSearchList,mainWindow,studentList.getMaxNumberOfSemestre(),updateSearchWindow);
                 mainWindow.getFrameSearch().getFrameSearchDel().getButton1().addActionListener(searchListener);

                 DelListener delListener = new DelListener(studentList,mainWindow,updateMainWindow);
                 mainWindow.getFrameDel().getFrameSearchDel().getButton1().addActionListener(delListener);
             }

             void createMainWindowListeners()
             {
                FirstPageListener firstPageListenerMain = new FirstPageListener(mainWindow.getFrame(),mainWindow.getTableModel(),studentList,updateMainWindow);
                mainWindow.getTableModel().getButtonFirstPage().addActionListener(firstPageListenerMain);

                NextPageListener nextPageListenerMain = new NextPageListener(mainWindow.getFrame(),mainWindow.getTableModel(),studentList,updateMainWindow);
                mainWindow.getTableModel().getButtonNextPage().addActionListener(nextPageListenerMain);

                PrevPageListener prevPageListenerMain = new PrevPageListener(mainWindow.getFrame(),mainWindow.getTableModel(),studentList,updateMainWindow);
                mainWindow.getTableModel().getButtonPrevPage().addActionListener(prevPageListenerMain);

                LastPageListener lastPageListenerMain = new LastPageListener(mainWindow.getFrame(),mainWindow.getTableModel(),studentList,updateMainWindow);
                mainWindow.getTableModel().getButtonLastPage().addActionListener(lastPageListenerMain);

                ChangeStudentOnPageListener changeStudentOnPageListenerMain = new ChangeStudentOnPageListener(mainWindow.getFrame(),mainWindow.getTableModel(),studentList,updateMainWindow);
                mainWindow.getTableModel().getChangeNumStudentOnPage().addActionListener(changeStudentOnPageListenerMain);

            }

             void createSearchFrameListeners()
             {
                 FirstPageListener firstPageListenerSearch = new FirstPageListener(mainWindow.getFrameSearch().getFrameSearch(),mainWindow.getFrameSearch().getTableSearchModel(),studentSearchList,updateSearchWindow);
                 mainWindow.getFrameSearch().getTableSearchModel().getButtonFirstPage().addActionListener(firstPageListenerSearch);

                 NextPageListener nextPageListenerSearch = new NextPageListener(mainWindow.getFrameSearch().getFrameSearch(),mainWindow.getFrameSearch().getTableSearchModel(),studentSearchList,updateSearchWindow);
                 mainWindow.getFrameSearch().getTableSearchModel().getButtonNextPage().addActionListener(nextPageListenerSearch);

                 PrevPageListener prevPageListenerSearch = new PrevPageListener(mainWindow.getFrameSearch().getFrameSearch(),mainWindow.getFrameSearch().getTableSearchModel(),studentSearchList,updateSearchWindow);
                 mainWindow.getFrameSearch().getTableSearchModel().getButtonPrevPage().addActionListener(prevPageListenerSearch);

                 LastPageListener lastPageListenerSearch = new LastPageListener(mainWindow.getFrameSearch().getFrameSearch(),mainWindow.getFrameSearch().getTableSearchModel(),studentSearchList,updateSearchWindow);
                 mainWindow.getFrameSearch().getTableSearchModel().getButtonLastPage().addActionListener(lastPageListenerSearch);

                 ChangeStudentOnPageListener changeStudentOnPageListenerSearch = new ChangeStudentOnPageListener(mainWindow.getFrameSearch().getFrameSearch(),mainWindow.getFrameSearch().getTableSearchModel(),studentSearchList,updateSearchWindow);
                 mainWindow.getFrameSearch().getTableSearchModel().getChangeNumStudentOnPage().addActionListener(changeStudentOnPageListenerSearch);

             }

             void createFileListeners()
             {
                 OpenFileListener openFileListener = new OpenFileListener(updateMainWindow,fileWorker);
                 mainWindow.getOpenFile().addActionListener(openFileListener);

                 SaveFileListener saveFileListener = new SaveFileListener(fileWorker);
                 mainWindow.getSaveFile().addActionListener(saveFileListener);
             }

}