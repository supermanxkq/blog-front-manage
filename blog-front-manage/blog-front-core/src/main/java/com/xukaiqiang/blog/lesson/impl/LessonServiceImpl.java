package com.xukaiqiang.blog.lesson.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.lesson.ILessonService;
import com.xukaiqiang.blog.lesson.mapper.LessonMapper;
import com.xukaiqiang.blog.model.lesson.Lesson;


/**
 * Service Implementation:Lesson
 * @author xukaiqiang
 * @date 2016-8-28
 */
@Service
@Transactional
public class LessonServiceImpl implements ILessonService {

	@Autowired
	private LessonMapper lessonMapper;
	
	/**
	 * 
	* @Title: saveLesson
	* @Description: 新增Lesson
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by chopin
	 */
	@Override
	public void insert(Lesson entity){
		lessonMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveLesson 
	* @Description: 批量新增Lesson
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by chopin
	 */
	@Override
	public void batchInsert(List<Lesson> entity){
		lessonMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateLesson 
	* @Description: 编辑Lesson
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by chopin
	 */
	@Override
	public void update(Lesson entity){
		lessonMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteLessonById 
	* @Description: 根据id删除Lesson
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by chopin
	 */
	 @Override
	public void deleteLessonById(Integer id){
		lessonMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteLessonByIds 
	* @Description: 根据id批量删除Lesson
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by chopin
	 */
	@Override
	public void deleteLessonByIds(Integer[] ids){
		lessonMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findLessonById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by chopin
	 */
	@Override
	public Lesson findLessonById(Integer id){
		return lessonMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findLessonByPage 
	* @Description: 分页查询
	* @return
	* @return List<Lesson>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-8-28
	* @user by chopin
	 */
	@Override
	public List<Lesson> findLessonByPage(Lesson search){
		return lessonMapper.page(search);
	};
}
