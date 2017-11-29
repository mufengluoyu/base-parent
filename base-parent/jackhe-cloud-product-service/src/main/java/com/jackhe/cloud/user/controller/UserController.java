package com.jackhe.cloud.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jackhe.cloud.user.entity.User;
import com.jackhe.cloud.user.repository.UserRepositoryDao;

import jackhe.cloud.user.common.model.GoodsModel;
import jackhe.cloud.user.common.vo.UserBaseVo;

@RestController
public class UserController {

	@Autowired
	private UserRepositoryDao userRepositoryDao;

	@GetMapping(value="/{id}")
	public User findById(@PathVariable Long id){
		return userRepositoryDao.findOne(id);
	}
	
	@GetMapping(value="/user/{id}")
	public UserBaseVo findByUserId(@PathVariable Long id){
		UserBaseVo vo = new UserBaseVo();
		User user = userRepositoryDao.findOne(id);
		BeanUtils.copyProperties(user, vo);
		GoodsModel goodsModel = new GoodsModel();
		goodsModel.setGoodsId("2");
		goodsModel.setGooodsName("测试商品8011的商品2");
		vo.setGoodsModel(goodsModel);
		return vo;
	}
	
	@GetMapping(value="/testUser")
	public String testUser(){
		return "这是8011的节点请求。";
	}
	/**
	 * get传值
	 * @param user
	 * @return
	 */
	@GetMapping("/user/get")
	public User getUserGet(User user) {
		return user;
	}
	
	/**
	 * post传值
	 * @param userBase
	 * @return
	 */
	@PostMapping(value="/user/post")
	public UserBaseVo getUserPost(UserBaseVo userBase){
		GoodsModel goodsModel = new GoodsModel();
		goodsModel.setGoodsId("1");
		goodsModel.setGooodsName("测试商品8010的商品1");
		userBase.setGoodsModel(goodsModel);
		return userBase;
	}
}
