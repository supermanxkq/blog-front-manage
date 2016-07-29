package com.xukaiqiang.blog.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.user.IUserService;
import com.xukaiqiang.blog.model.user.User;
import com.xukaiqiang.blog.user.mapper.UserMapper;


/**
 * Service Implementation:User
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 
	* @Title: saveUser
	* @Description: 新增User
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void insert(User entity){
		userMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveUser 
	* @Description: 批量新增User
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void batchInsert(List<User> entity){
		userMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateUser 
	* @Description: 编辑User
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void update(User entity){
		userMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteUserById 
	* @Description: 根据id删除User
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	 @Override
	public void deleteUserById(Integer id){
		userMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteUserByIds 
	* @Description: 根据id批量删除User
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void deleteUserByIds(Integer[] ids){
		userMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findUserById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public User findUserById(Integer id){
		return userMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findUserByPage 
	* @Description: 分页查询
	* @return
	* @return List<User>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public List<User> findUserByPage(User search){
		return userMapper.page(search);
	};
}
