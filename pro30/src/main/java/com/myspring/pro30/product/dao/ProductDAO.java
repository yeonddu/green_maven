package com.myspring.pro30.product.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.product.vo.ImageFileVO;
import com.myspring.pro30.product.vo.ProductVO;

public interface ProductDAO {
	/*상품검색 추가*/
	public List<ProductVO> selectProductByProductSort(String productSort) throws DataAccessException;
	
	public List<ProductVO> selectProductList(String productStatus ) throws DataAccessException;
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;
	public ProductVO selectProductDetail(String product_id) throws DataAccessException;
	public List<ImageFileVO> selectProductDetailImage(String product_id) throws DataAccessException;
	public List<ProductVO> selectProductBySearchWord(String searchWord) throws DataAccessException;
}
