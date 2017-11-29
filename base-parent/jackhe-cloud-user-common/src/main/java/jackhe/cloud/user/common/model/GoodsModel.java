package jackhe.cloud.user.common.model;

import java.io.Serializable;

public class GoodsModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String goodsId;
	private String gooodsName;
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGooodsName() {
		return gooodsName;
	}
	public void setGooodsName(String gooodsName) {
		this.gooodsName = gooodsName;
	}
	
	
}
