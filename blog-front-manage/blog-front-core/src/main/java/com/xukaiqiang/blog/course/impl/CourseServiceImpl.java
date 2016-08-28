package com.xukaiqiang.blog.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.course.ICourseService;
import com.xukaiqiang.blog.course.mapper.CourseMapper;
import com.xukaiqiang.blog.model.course.Course;


/**
 * Service Implementation:Course
 * @author xukaiqiang
 * @date 2016-8-28
 */
@Service
@Transactional
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	/**
	 * 
	* @Title: saveCourse
	* @Description: 新增Course
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by xukaiqiang
	 */
	@Override
	public void insert(Course entity){
		courseMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveCourse 
	* @Description: 批量新增Course
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by xukaiqiang
	 */
	@Override
	public void batchInsert(List<Course> entity){
		courseMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateCourse 
	* @Description: 编辑Course
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by xukaiqiang
	 */
	@Override
	public void update(Course entity){
		courseMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteCourseById 
	* @Description: 根据id删除Course
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by xukaiqiang
	 */
	 @Override
	public void deleteCourseById(Integer id){
		courseMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteCourseByIds 
	* @Description: 根据id批量删除Course
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by xukaiqiang
	 */
	@Override
	public void deleteCourseByIds(Integer[] ids){
		courseMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findCourseById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by xukaiqiang
	 */
	@Override
	public Course findCourseById(Integer id){
		return courseMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findCourseByPage 
	* @Description: 分页查询
	* @return
	* @return List<Course>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by xukaiqiang
	 */
	@Override
	public List<Course> findCourseByPage(Course search){
		return courseMapper.page(search);
	};
}
