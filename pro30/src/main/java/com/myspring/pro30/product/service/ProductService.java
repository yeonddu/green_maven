package com.myspring.pro30.product.service;

import java.util.List;
import java.util.Map;

import com.myspring.pro30.product.vo.ProductVO;

public interface ProductService {
	/*상품검색 추가*/
	public List<ProductVO> sortByProduct(String productSort) throws Exception;
	public Map<String,List<ProductVO>> listProduct() throws Exception;
	public Map productDetail(String _product_id) throws Exception;
	
	public List<String> keywordSearch(String keyword) throws Exception;
	public List<ProductVO> searchProduct(String searchWord) throws Exception;

}
