package com.myspring.pro30.board.vo;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("articleVO")
public class ArticleVO {

		private int level;
		private int articleNO;
		private int parentNO;
		private String title;
		private String content;
		private String imageFileName;
		private String id;
		private Date WriteDate;
		
		public ArticleVO() {
			System.out.println("ArticleVO 생성자");
		}
		
		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public int getArticleNO() {
			return articleNO;
		}

		public void setArticleNO(int articleNO) {
			this.articleNO = articleNO;
		}

		public int getParentNO() {
			return parentNO;
		}

		public void setParentNO(int parentNO) {
			this.parentNO = parentNO;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getImageFileName() {
			
			try {
				if(imageFileName != null && imageFileName.length() != 0) {
					imageFileName = URLDecoder.decode(imageFileName,"UTF-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return imageFileName;
		}

		public void setImageFileName(String imageFileName) {
			try {
				this.imageFileName = URLEncoder.encode(imageFileName,"UTF-8"); //파일 이름에 특수문자가 있을 경우 인코딩
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			this.imageFileName = imageFileName;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Date getWriteDate() {
			return WriteDate;
		}

		public void setWriteDate(Date writeDate) {
			WriteDate = writeDate;
		}
		
		
	}

