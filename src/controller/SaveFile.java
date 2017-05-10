package controller;

import model.Student;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by user on 10.05.2017.
 */
public class SaveFile {
    private  FileWorker fileWorker;

    public SaveFile(FileWorker fileWorker)
    {
        this.fileWorker = fileWorker;
    }

    public void saveFile() {

        try {

            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement(fileWorker.STUDENTS);
                doc.appendChild(rootElement);

                for (Student student : fileWorker.model.getStudentList()) {
                    Element studentEl = doc.createElement(fileWorker.STUDENT);
                    rootElement.appendChild(studentEl);

                    Attr attr = doc.createAttribute(fileWorker.FIRST_NAME);
                    attr.setValue(student.getFirstName());
                    studentEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.LAST_NAME);
                    attr.setValue(student.getLastName());
                    studentEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.SUR_NAME);
                    attr.setValue(student.getSurName());
                    studentEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.GROUP);
                    attr.setValue(Integer.toString(student.getGroup()));
                    studentEl.setAttributeNode(attr);

                    for (String socialWork : student.getSemNumber()) {
                        Element firstname = doc.createElement(fileWorker.SOCIAL_WORK);
                        firstname.appendChild(doc.createTextNode(socialWork));
                        studentEl.appendChild(firstname);
                    }

                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(fc.getSelectedFile() + "." + fileWorker.EXTENSION));
                    transformer.transform(source, result);
                }
            }

        } catch (ParserConfigurationException pce) {

            JOptionPane.showMessageDialog(null, "Не удалось сохранить файл", "Ошибка", JOptionPane.ERROR_MESSAGE | JOptionPane.OK_OPTION);

        }catch (TransformerException tfe) {

            JOptionPane.showMessageDialog(null, "Не удалось сохранить файл", "Ошибка", JOptionPane.ERROR_MESSAGE | JOptionPane.OK_OPTION);

        }

    }

}
