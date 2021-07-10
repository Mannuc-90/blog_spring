package com.tech2Dev.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tech2Dev.blog.data.Course;

@Repository
public class CourseDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Course> getAllCourses(){
		String sql = "SELECT * FROM COURSE";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
	}
	
	public Course getCourseById(int id) {
		String sql = "SELECT * FROM COURSE WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class), new Object[] {id});
	}
	
	
	public int createCourse(Course course) {
		String sql = "INSERT INTO COURSE (ID, Name, Description, Author, creation_date, last_modified_date) "
				+ "VALUES(?,?,?,?,?,?)"; 
		return jdbcTemplate.update(sql, new Object[] {
				course.getId(), course.getName(), course.getDescription(), course.getAuthor(),
					new Timestamp(course.getCreationDate().getTime()), new Timestamp(course.getLastModifiedDate().getTime())
		});
	}
	
	public int updateCourse(Course course) {
		String sql = "UPDATE COURSE SET Name = ?, Description= ?, Author = ?, creation_date = ?, last_modified_date = ? "
				+ "WHERE ID = ?";
		
		return jdbcTemplate.update(sql, new Object[] {
				course.getName(), course.getDescription(), course.getAuthor(), 
				new Timestamp(course.getCreationDate().getTime()), new Timestamp(course.getLastModifiedDate().getTime()), course.getId()
		});
	}
	
	public int deleteCourseById(int id) {
		String sql = "DELETE FROM COURSE WHERE ID = ?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}
	
	public List<Course> getCoursesByAuthor(String author) {
		String sql = "SELECT * FROM COURSE WHERE AUTHOR = ?";
		return jdbcTemplate.query(sql, new CourseMapper(), new Object[] {author});
	}
	
	/*
	public int deleteAllCourses() {
		String sql = "DELETE FROM COURSE";
		return jdbcTemplate.update(sql);
	}
	*/
	
	public static final class CourseMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course course = new Course();
			course.setId(rs.getInt("ID"));
			course.setName(rs.getString("Name"));
			course.setDescription(rs.getString("Description"));
			course.setAuthor(rs.getString("Author"));
			course.setCreationDate(rs.getDate("creation_date"));
			course.setLastModifiedDate(rs.getDate("last_modified_date"));
			return course;
		}
		
	}

}
