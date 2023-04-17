package com.myspring.pro30.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro30.product.dao.ProductDAO;
import com.myspring.pro30.product.vo.ImageFileVO;
import com.myspring.pro30.product.vo.ProductVO;

@Service("productService")
@Transactional(propagation=Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	/*상품검색 추가*/
	public List<ProductVO> sortByProduct(String productSort) throws Exception{
		List productList=productDAO.selectProductByProductSort(productSort);
		return productList;
	}
	
	
	public Map<String,List<ProductVO>> listProduct() throws Exception {
		Map<String,List<ProductVO>> productMap=new HashMap<String,List<ProductVO>>();
		List<ProductVO> productList=productDAO.selectProductList("bestseller");
		productMap.put("bestseller",productList);
		
		productList=productDAO.selectProductList("newbook");
		productMap.put("newbook",productList);
		
		productList=productDAO.selectProductList("steadyseller");
		productMap.put("steadyseller",productList);
		return productMap;
	}
	
	public Map productDetail(String _product_id) throws Exception {
		Map productMap=new HashMap();
		ProductVO productVO = productDAO.selectProductDetail(_product_id);
		productMap.put("productVO", productVO);
		List<ImageFileVO> imageList =productDAO.selectProductDetailImage(_product_id);
		productMap.put("imageList", imageList);
		return productMap;
	}
	
	public List<String> keywordSearch(String keyword) throws Exception {
		List<String> list=productDAO.selectKeywordSearch(keyword);
		return list;
	}
	
	public List<ProductVO> searchProduct(String searchWord) throws Exception{
		List productList=productDAO.selectProductBySearchWord(searchWord);
		return productList;
	}
}