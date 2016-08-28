package com.xukaiqiang.blog.api.lesson;

import java.util.List;

import com.xukaiqiang.blog.model.lesson.Lesson;
/**
 * Service Interface:Lesson
 * @author xukaiqiang
 * @date 2016-8-28
 */
public interface ILessonService  {
	/**
	 * 
	* @Title: saveLesson
	* @Description: 新增Lesson
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void insert(Lesson entity);
	
	/**
	 * 
	* @Title: batchSaveLesson 
	* @Description: 批量新增Lesson
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void batchInsert(List<Lesson> list);
	
	/**
	 * 
	* @Title: updateLesson 
	* @Description: 编辑Lesson
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void update(Lesson entity);
	
	/**
	 * 
	* @Title: deleteLessonById 
	* @Description: 根据id删除Lesson
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void deleteLessonById(Integer id);
	
	/**
	 * 
	* @Title: deleteLessonByIds 
	* @Description: 根据id批量删除Lesson
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	void deleteLessonByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findLessonById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	Lesson findLessonById(Integer id);
	
	/**
	 * 
	* @Title: findLessonByPage 
	* @Description: 分页查询
	* @return
	* @return List<Lesson>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by wangzx
	 */
	List<Lesson> findLessonByPage(Lesson search);
}