package com.xukaiqiang.blog.userdetail.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.userdetail.IUserDetailService;
import com.xukaiqiang.blog.model.userDetail.UserDetail;
import com.xukaiqiang.blog.userdetail.mapper.UserDetailMapper;


/**
 * Service Implementation:UserDetail
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Service
@Transactional
public class UserDetailServiceImpl implements IUserDetailService {

	@Autowired
	private UserDetailMapper userDetailMapper;
	
	/**
	 * 
	* @Title: saveUserDetail
	* @Description: 新增UserDetail
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void insert(UserDetail entity){
		userDetailMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveUserDetail 
	* @Description: 批量新增UserDetail
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void batchInsert(List<UserDetail> entity){
		userDetailMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateUserDetail 
	* @Description: 编辑UserDetail
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void update(UserDetail entity){
		userDetailMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteUserDetailById 
	* @Description: 根据id删除UserDetail
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	 @Override
	public void deleteUserDetailById(Integer id){
		userDetailMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteUserDetailByIds 
	* @Description: 根据id批量删除UserDetail
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void deleteUserDetailByIds(Integer[] ids){
		userDetailMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findUserDetailById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public UserDetail findUserDetailById(Integer id){
		return userDetailMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findUserDetailByPage 
	* @Description: 分页查询
	* @return
	* @return List<UserDetail>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public List<UserDetail> findUserDetailByPage(UserDetail search){
		return userDetailMapper.page(search);
	};
}
