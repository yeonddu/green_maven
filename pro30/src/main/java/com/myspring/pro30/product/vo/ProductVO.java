package com.myspring.pro30.product.vo;

import java.sql.Date;

public class ProductVO {
	private int product_id;
	private String product_sort;
	private String center_name;
	private String product_name;
	private String product_main_image;
	private String product_detail_image;
	private String product_option_name;
	private int product_option_price;
	private int product_price;
	private int product_sales_price;
	private int product_point;
	private Date product_entered_date;
	private String product_intro;
	private String product_refund_1;
	private String product_refund_2;
	private int sale_yn;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_sort() {
		return product_sort;
	}
	public void setProduct_sort(String product_sort) {
		this.product_sort = product_sort;
	}
	public String getCenter_name() {
		return center_name;
	}
	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_main_image() {
		return product_main_image;
	}
	public void setProduct_main_image(String product_main_image) {
		this.product_main_image = product_main_image;
	}
	public String getProduct_detail_image() {
		return product_detail_image;
	}
	public void setProduct_detail_image(String product_detail_image) {
		this.product_detail_image = product_detail_image;
	}
	public String getProduct_option_name() {
		return product_option_name;
	}
	public void setProduct_option_name(String product_option_name) {
		this.product_option_name = product_option_name;
	}
	public int getProduct_option_price() {
		return product_option_price;
	}
	public void setProduct_option_price(int product_option_price) {
		this.product_option_price = product_option_price;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_sales_price() {
		return product_sales_price;
	}
	public void setProduct_sales_price(int product_sales_price) {
		this.product_sales_price = product_sales_price;
	}
	public int getProduct_point() {
		return product_point;
	}
	public void setProduct_point(int product_point) {
		this.product_point = product_point;
	}
	public Date getProduct_entered_date() {
		return product_entered_date;
	}
	public void setProduct_entered_date(Date product_entered_date) {
		this.product_entered_date = product_entered_date;
	}
	
	public String getProduct_intro() {
		return product_intro;
	}
	public void setProduct_intro(String product_intro) {
		this.product_intro = product_intro;
	}
	public String getProduct_refund_1() {
		return product_refund_1;
	}
	public void setProduct_refund_1(String product_refund_1) {
		this.product_refund_1 = product_refund_1;
	}
	public String getProduct_refund_2() {
		return product_refund_2;
	}
	public void setProduct_refund_2(String product_refund_2) {
		this.product_refund_2 = product_refund_2;
	}
	public int getSale_yn() {
		return sale_yn;
	}
	public void setSale_yn(int sale_yn) {
		this.sale_yn = sale_yn;
	}
	
		
}
