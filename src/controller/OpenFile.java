package controller;

import model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10.05.2017.
 */
public class OpenFile {
    private FileWorker fileWorker;

    public OpenFile(FileWorker fileWorker)
    {
        this.fileWorker = fileWorker;
    }

   public void openFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("xml", fileWorker.EXTENSION));

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                fileWorker.model.getStudentList().clear();
                DefaultHandler handler = new DefaultHandler() {
                    private String lastName = "";
                    private String firstName = "";
                    private String surName = "";
                    private String group = "";
                    private List<String> socialWork = new ArrayList<String>();
                    boolean isSocialWork = false;

                    @Override

                    public void startElement(String uri, String localName, String qName, Attributes attributes)

                            throws SAXException {

                        if (qName.equalsIgnoreCase(fileWorker.STUDENT)) {
                            lastName=attributes.getValue(fileWorker.LAST_NAME);
                            firstName=attributes.getValue(fileWorker.FIRST_NAME);
                            surName=attributes.getValue(fileWorker.SUR_NAME);
                            group=attributes.getValue(fileWorker.GROUP);
                        } else if (qName.equalsIgnoreCase(fileWorker.SOCIAL_WORK)) {
                            isSocialWork = true;
                        }
                    }

                    @Override
                    public void endElement(String uri, String localName, String qName) throws SAXException {
                        if(socialWork.size()==10){
                            fileWorker.model.getStudentList().add(new Student(lastName, firstName, surName,Integer.parseInt(group),new ArrayList<String>(socialWork )));
                            socialWork.clear();
                        }
                    }

                    @Override

                    public void characters(char ch[], int start, int length) throws SAXException {
                        if (isSocialWork) {
                            socialWork.add(new String(ch, start, length));
                            isSocialWork = false;
                        }
                    }

                };

                saxParser.parse(new File(fileChooser.getSelectedFile().getPath()), handler);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    }
}
