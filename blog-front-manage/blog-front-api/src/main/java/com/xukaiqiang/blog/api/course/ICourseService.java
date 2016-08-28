package com.xukaiqiang.blog.api.course;

import java.util.List;

import com.xukaiqiang.blog.model.course.Course;
/**
 * Service Interface:Course
 * @author xukaiqiang
 * @date 2016-8-28
 */
public interface ICourseService  {
	/**
	 * 
	* @Title: saveCourse
	* @Description: 新增Course
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void insert(Course entity);
	
	/**
	 * 
	* @Title: batchSaveCourse 
	* @Description: 批量新增Course
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void batchInsert(List<Course> list);
	
	/**
	 * 
	* @Title: updateCourse 
	* @Description: 编辑Course
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void update(Course entity);
	
	/**
	 * 
	* @Title: deleteCourseById 
	* @Description: 根据id删除Course
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void deleteCourseById(Integer id);
	
	/**
	 * 
	* @Title: deleteCourseByIds 
	* @Description: 根据id批量删除Course
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void deleteCourseByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findCourseById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	Course findCourseById(Integer id);
	
	/**
	 * 
	* @Title: findCourseByPage 
	* @Description: 分页查询
	* @return
	* @return List<Course>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	List<Course> findCourseByPage(Course search);
}