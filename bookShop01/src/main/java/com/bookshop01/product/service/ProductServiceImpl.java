package com.bookshop01.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop01.product.dao.ProductDAO;
import com.bookshop01.product.vo.ProductImageVO;
import com.bookshop01.product.vo.ProductOptVO;
import com.bookshop01.product.vo.ProductVO;

@Service("productService")
@Transactional(propagation=Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

	private static final String String = null;
	@Autowired
	private ProductDAO productDAO;
	
	/*상품검색 추가*/
	public List<ProductVO> productList(String product_sort) throws Exception{
		List productList=productDAO.selectProductList(product_sort);
		return productList;
	}
	
	public Map productDetail(String _product_id) throws Exception {
		Map productMap=new HashMap();
		ProductVO productVO = productDAO.selectProductDetail(_product_id);
		productMap.put("productVO", productVO);
		
		/* 옵션 */
		List<ProductOptVO> productOptList = productDAO.selectProductOption(_product_id);
		productMap.put("productOptList", productOptList);

		/* 프로그램 상세정보 이미지 */
		List<ProductImageVO> imageList =productDAO.selectProductDetailImage(_product_id);
		productMap.put("imageList", imageList);
		
		/* 가격 정보 이미지 */
		List<ProductImageVO> priceImage =productDAO.selectProductPriceImage(_product_id);
		productMap.put("priceImage", priceImage);
		
		/* 시설 정보 이미지 */
		List<ProductImageVO> facilityImage =productDAO.selectProductFacilityImage(_product_id);
		productMap.put("facilityImage", facilityImage);

		return productMap;
	}

	public List<ProductVO> productSorting(String product_sort, String sortBy) throws Exception{
		List productList= productDAO.selectSortedProduct(product_sort, sortBy);
		return productList;
	}
	/*
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
	
	
	public List<String> keywordSearch(String keyword) throws Exception {
		List<String> list=productDAO.selectKeywordSearch(keyword);
		return list;
	}
	
	public List<ProductVO> searchProduct(String searchWord) throws Exception{
		List productList=productDAO.selectProductBySearchWord(searchWord);
		return productList;
	}
	*/
}