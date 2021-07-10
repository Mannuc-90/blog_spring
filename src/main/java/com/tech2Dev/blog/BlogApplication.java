package com.tech2Dev.blog;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tech2Dev.blog.dao.CourseDao;
import com.tech2Dev.blog.data.Course;


@SpringBootApplication
public class BlogApplication implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(this.getClass());
		
	@Autowired 
	private CourseDao courseDao;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 log.info("Courses : :{}",courseDao.getAllCourses()); 
		/* log.info("Courses : :{}",courseDao.getCourseById(2)); */
	
		 
		 log.info("Creating new Course : {}", courseDao.createCourse(
				new Course(1,"HTML" , "Basic HTML course to learn website creation", "sonu",new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()))
				));
		 log.info("Courses : :{}",courseDao.getAllCourses()); 
		 log.info("Updating course 1 : {}" , courseDao.updateCourse(new Course(
				 1,"Core java", "Just changing the descr to core java", "sonu", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())
				 )));
		 log.info("Getting Updated course 1 : {}", courseDao.getCourseById(1));
		 log.info("Deleting course 3 : {}", courseDao.deleteCourseById(3));
		 log.info("Get courses by author mannu : {}", courseDao.getCoursesByAuthor("manpchop"));
		
	}

}
