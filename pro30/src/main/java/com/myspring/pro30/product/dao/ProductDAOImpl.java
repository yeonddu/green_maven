package com.myspring.pro30.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro30.product.vo.ImageFileVO;
import com.myspring.pro30.product.vo.ProductVO;


@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sqlSession;

	/*상품 검색 추가*/
	public ArrayList selectProductByProductSort(String productSort) throws DataAccessException{
		ArrayList list=(ArrayList)sqlSession.selectList("mapper.product.selectProductByProductSort",productSort);
		 return list;
	}

	
	@Override
	public List<ProductVO> selectProductList(String productStatus ) throws DataAccessException {
		List<ProductVO> productList=(ArrayList)sqlSession.selectList("mapper.product.selectProductList",productStatus);
	   return productList;	
     
	}
	@Override
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
	   List<String> list=(ArrayList)sqlSession.selectList("mapper.product.selectKeywordSearch",keyword);
	   return list;
	}
	
	@Override
	public ArrayList selectProductBySearchWord(String searchWord) throws DataAccessException{
		ArrayList list=(ArrayList)sqlSession.selectList("mapper.product.selectProductBySearchWord",searchWord);
		 return list;
	}
	
	@Override
	public ProductVO selectProductDetail(String product_id) throws DataAccessException{
		ProductVO productVO=(ProductVO)sqlSession.selectOne("mapper.product.selectProductDetail",product_id);
		return productVO;
	}
	
	@Override
	public List<ImageFileVO> selectProductDetailImage(String product_id) throws DataAccessException{
		List<ImageFileVO> imageList=(ArrayList)sqlSession.selectList("mapper.product.selectProductDetailImage",product_id);
		return imageList;
	}
	
}