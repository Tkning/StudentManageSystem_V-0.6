package com.hxz.stu.dao;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.hxz.stu.bean.Student;

public class StudentDao {
	
	String xmlFileName = StudentDao.class.getResource("/student.xml").getPath();
	
	/**
	 * 列出所有学生信息
	 * @return
	 * @throws Exception
	 */
	public List<Student> list() throws Exception{
		List<Student> stus = new ArrayList<Student>();
		
		//1、解析students.xml -> doc
		SAXReader reader = new SAXReader();
        Document doc = reader.read(xmlFileName);

        Element root = doc.getRootElement();
        Iterator<Element> it = root.elementIterator();
        while(it.hasNext()) {
        	Element stu = it.next();
        	Integer id = Integer.parseInt(stu.element("id").getText());
        	String name = stu.element("name").getText();
        	String gender = stu.element("gender").getText();
        	Integer age = Integer.parseInt(stu.element("age").getText());
        	Integer score =  Integer.parseInt(stu.element("score").getText());
        	Student s = new Student(id, name, gender, age, score);
        	stus.add(s);
        }
		return stus;
	}

	/**
	 * 根据指定ID删除学生信息
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		SAXReader reader = new SAXReader();
        Document doc = reader.read(xmlFileName);
        
        Element root = doc.getRootElement();
        Iterator<Element> it = root.elementIterator();
        while(it.hasNext()) {
        	Element stu = it.next();
        	String xmlid = stu.element("id").getText();
        	if(xmlid != null && xmlid.equals(id)) {
        		root.remove(stu);
        		FileWriter fileWriter = new FileWriter(xmlFileName);
        		OutputFormat f = OutputFormat.createPrettyPrint();
        		f.setEncoding("UTF-8");
                XMLWriter writer = new XMLWriter(fileWriter, f);
                writer.write(doc);
                writer.close();
        		return;
        	}
        }
	}

	/**
	 * 添加学生
	 * @param s
	 * @throws Exception
	 */
	public void save(Student s) throws Exception {
		SAXReader reader = new SAXReader();
        Document doc = reader.read(xmlFileName);

        Element root = doc.getRootElement();
        Element student = root.addElement("student");
        student.addElement("id").setText(s.getId()+"");
        student.addElement("name").setText(s.getName());
        student.addElement("gender").setText(s.getGender());
        student.addElement("age").setText(s.getAge()+"");
        student.addElement("score").setText(s.getScore()+"");

		FileWriter fileWriter = new FileWriter(xmlFileName);
		OutputFormat f = OutputFormat.createPrettyPrint();
		f.setEncoding("UTF-8");
	    XMLWriter writer = new XMLWriter(fileWriter, f);
	    writer.write(doc);
	    writer.close();
	}

	/**
	 * 根据指定ID查找学生信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Student findById(String id)  throws Exception {
		SAXReader reader = new SAXReader();
        Document doc = reader.read(xmlFileName);

        Element root = doc.getRootElement();
        Iterator<Element> it = root.elementIterator();
        while(it.hasNext()) {
        	Element e = it.next();
        	String xmlid = e.element("id").getText();
        	if(xmlid != null && xmlid.equals(id)) {
        		Integer sid = Integer.parseInt(xmlid);
        		String name = e.element("name").getText();
        		String gender = e.element("gender").getText();
        		Integer age = Integer.parseInt(e.element("age").getText());
        		Integer score = Integer.parseInt(e.element("score").getText());
        		Student s = new Student(sid, name, gender, age, score);
        		return s;
        	}
        }
        
        return null;
	}

	/**
	 * 修改学生信息
	 * @param s
	 * @throws Exception
	 */
	public void update(Student s) throws Exception {
		SAXReader reader = new SAXReader();
        Document doc = reader.read(xmlFileName);

        Element root = doc.getRootElement();
        Iterator<Element> it = root.elementIterator();
        while(it.hasNext()) {
        	Element e = it.next();
        	String id = e.element("id").getText();
        	if(id != null && id.equals(s.getId()+"")) {
        		e.element("name").setText(s.getName());
        		e.element("gender").setText(s.getGender());
        		e.element("age").setText(s.getAge() + "");
        		e.element("score").setText(s.getScore() + "");
        		
        		FileWriter fileWriter = new FileWriter(xmlFileName);
        		OutputFormat f = OutputFormat.createPrettyPrint();
        		f.setEncoding("UTF-8");
        	    XMLWriter writer = new XMLWriter(fileWriter, f);
        	    writer.write(doc);
        	    writer.close();
        	    return;
        	}
        }
        
		
	}
	
}
