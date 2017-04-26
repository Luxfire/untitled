
import org.w3c.dom.Attr;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.xml.sax.Attributes;

import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;



import javax.swing.*;

import javax.swing.filechooser.FileNameExtensionFilter;

import javax.xml.parsers.*;

import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;

import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;

import javax.xml.transform.stream.StreamResult;

import java.io.File;

import java.util.ArrayList;

import java.util.List;



/**

 * Created by alex on 16.3.17.

 */

public class FileWorker {



    private final String LAST_NAME = "last_name";

    private final String FIRST_NAME = "first_name";

    private final String SUR_NAME = "sur_name";

    private final String GROUP = "group";

    private final String SOCAIL_WORK = "social_work";

    private final String STUDENT = "student";

    private final String STUDENTS = "students";

    private final String EXTENSION = "xml";



    private StudentList model;



    public FileWorker(StudentList model) {

        this.model = model;

    }



    public void openFile() {

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileFilter(new FileNameExtensionFilter("xml", EXTENSION));



        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            try {

                SAXParserFactory factory = SAXParserFactory.newInstance();

                SAXParser saxParser = factory.newSAXParser();

                model.studentList.clear();

                DefaultHandler handler = new DefaultHandler() {

                    private String lastName = "";

                    private String firstName = "";

                    private String surName = "";

                    private String group = "";

                    private List<SocialWork> socialWork = new ArrayList<SocialWork>();



                    boolean isSocialWork = false;



                    @Override

                    public void startElement(String uri,

                                             String localName, String qName, Attributes attributes)

                            throws SAXException {

                        if (qName.equalsIgnoreCase(STUDENT)) {

                            lastName=attributes.getValue(LAST_NAME);

                            firstName=attributes.getValue(FIRST_NAME);

                            surName=attributes.getValue(SUR_NAME);

                            group=attributes.getValue(GROUP);

                        } else if (qName.equalsIgnoreCase(SOCAIL_WORK)) {

                            isSocialWork = true;

                        }

                    }



                    @Override

                    public void endElement(String uri,

                                           String localName, String qName) throws SAXException {

                        if(socialWork.size()==model.getSemestrNumber()){

                            model.studentList.add(new Student(lastName, firstName, surName, group, new ArrayList<SocialWork>(socialWork) ));

                            socialWork.clear();

                        }

                    }



                    @Override

                    public void characters(char ch[],

                                           int start, int length) throws SAXException {

                        if (isSocialWork) {

                            socialWork.add(new SocialWork(new String(ch, start, length)));

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



    public void saveFile() {

        try {

            JFileChooser fc = new JFileChooser();

            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();



                Document doc = docBuilder.newDocument();

                Element rootElement = doc.createElement(STUDENTS);

                doc.appendChild(rootElement);



                for (Student student : model.studentList) {

                    Element studentEl = doc.createElement(STUDENT);

                    rootElement.appendChild(studentEl);



                    Attr attr = doc.createAttribute(FIRST_NAME);

                    attr.setValue(student.firstName);

                    studentEl.setAttributeNode(attr);



                    attr = doc.createAttribute(LAST_NAME);

                    attr.setValue(student.lastName);

                    studentEl.setAttributeNode(attr);



                    attr = doc.createAttribute(SUR_NAME);

                    attr.setValue(student.surName);

                    studentEl.setAttributeNode(attr);



                    attr = doc.createAttribute(GROUP);

                    attr.setValue(Integer.toString(student.group));

                    studentEl.setAttributeNode(attr);





                    for (SocialWork socialWork : student.getSocialWork()) {

                        Element firstname = doc.createElement(SOCAIL_WORK);

                        firstname.appendChild(doc.createTextNode(socialWork.getWork()));

                        studentEl.appendChild(firstname);

                    }



                    TransformerFactory transformerFactory = TransformerFactory.newInstance();

                    Transformer transformer = transformerFactory.newTransformer();

                    DOMSource source = new DOMSource(doc);

                    StreamResult result = new StreamResult(new File(fc.getSelectedFile() + "." + EXTENSION));

                    transformer.transform(source, result);



                }

            }

        } catch (ParserConfigurationException pce) {

            JOptionPane.showMessageDialog(null, "Не удалось сохранить файл", "Ошибка", JOptionPane.ERROR_MESSAGE | JOptionPane.OK_OPTION);

        } catch (TransformerException tfe) {

            JOptionPane.showMessageDialog(null, "Не удалось сохранить файл", "Ошибка", JOptionPane.ERROR_MESSAGE | JOptionPane.OK_OPTION);

        }

    }



}