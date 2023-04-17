package com.bookshop01.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.cart.vo.CartVO;
import com.bookshop01.goods.vo.GoodsVO;

public interface CartService {
	
	public Map<String ,List> myCartList(CartVO cartVO) throws Exception;
	public boolean findCartGoods(CartVO cartVO) throws Exception;
	public void addGoodsInCart(CartVO cartVO) throws Exception;
	public boolean modifyCartQty(CartVO cartVO) throws Exception;
	public void removeCartGoods(int cart_id) throws Exception;
}
