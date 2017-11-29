package jackhe.cloud.user.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import jackhe.cloud.user.common.model.GoodsModel;

/**
 * 通过feign的公共传参类
 * @author hechanghzi
 *
 */
public class UserBaseVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String name;
	private Integer age;
	private BigDecimal balance;
	private GoodsModel goodsModel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public GoodsModel getGoodsModel() {
		return goodsModel;
	}
	public void setGoodsModel(GoodsModel goodsModel) {
		this.goodsModel = goodsModel;
	}
	
}
