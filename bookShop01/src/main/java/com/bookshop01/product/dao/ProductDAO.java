package com.bookshop01.product.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookshop01.product.vo.ProductImageVO;
import com.bookshop01.product.vo.ProductOptVO;
import com.bookshop01.product.vo.ProductVO;

public interface ProductDAO {
	/*상품검색 추가*/
	public List<ProductVO> selectProductList(String productSort) throws DataAccessException;
	public ProductVO selectProductDetail(String product_id) throws DataAccessException;
	
	public List<ProductOptVO> selectProductOption(String product_id) throws DataAccessException;
	
	public List<ProductImageVO> selectProductDetailImage(String product_id) throws DataAccessException;
	public List<ProductImageVO> selectProductPriceImage(String product_id) throws DataAccessException;
	public List<ProductImageVO> selectProductFacilityImage(String product_id) throws DataAccessException;
	
	public List<ProductVO> selectSortedProduct(String productSort, String sortBy) throws DataAccessException;
	
	

	/*
	public List<ProductVO> selectProductList(String productStatus ) throws DataAccessException;
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;
	public List<ProductVO> selectProductBySearchWord(String searchWord) throws DataAccessException;
	*/
}
