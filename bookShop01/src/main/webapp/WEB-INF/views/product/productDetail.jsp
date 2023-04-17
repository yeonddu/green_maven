<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="product"  value="${productMap.productVO}"  />
<c:set var="optList"  value="${productMap.productOptList }"  />
<c:set var="imageList"  value="${productMap.imageList }"  />
<c:set var="priceImage"  value="${productMap.priceImage }"  />
<c:set var="facilityImage"  value="${productMap.facilityImage }"  />
 <%
     //치환 변수 선언합니다.
      //pageContext.setAttribute("crcn", "\r\n"); //개행문자
      pageContext.setAttribute("crcn" , "\n"); //Ajax로 변경 시 개행 문자 
      pageContext.setAttribute("br", "<br/>"); //br 태그
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>제품 상세페이지</title>
<style>


#layer {
	z-index: 2;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
}

#popup {
	z-index: 3;
	position: fixed;
	text-align: center;
	left: 50%;
	top: 45%;
	width: 300px;
	height: 200px;
	background-color: #ccffff;
	border: 3px solid #87cb42;
}

#close {
	z-index: 4;
	float: right;
}


</style>
<script>
function add_cart(product_id,order_goods_qty) {
    $.ajax({
       type : "post",
       async : false, //false인 경우 동기식으로 처리한다.
       url : "${contextPath}/cart/addGoodsInCart.do",
       data : {
          goods_id:goods_id,
          order_goods_qty:$('#order_goods_qty').val()
          
       },
       success : function(data, textStatus) {
          //alert(data);
       //   $('#message').append(data);
          if(data.trim()=='add_success'){
             imagePopup('open', '.layer01');   
          }else if(data.trim()=='already_existed'){
             alert("이미 카트에 등록된 상품입니다.");   
          }
          
       },
       error : function(data, textStatus) {
          alert("에러가 발생했습니다."+data);
       },
       complete : function(data, textStatus) {
          //alert("작업을완료 했습니다");
       }
    }); //end ajax   
 }	


function imagePopup(type) {
	if (type == 'open') {
		// 팝업창을 연다.
		jQuery('#layer').attr('style', 'visibility:visible');

		// 페이지를 가리기위한 레이어 영역의 높이를 페이지 전체의 높이와 같게 한다.
		jQuery('#layer').height(jQuery(document).height());
	}

	else if (type == 'close') {

		// 팝업창을 닫는다.
		jQuery('#layer').attr('style', 'visibility:hidden');
	}
}

function fn_order_each_goods(goods_id,goods_title,goods_sales_price,fileName){
var _isLogOn=document.getElementById("isLogOn");
var isLogOn=_isLogOn.value;

 if(isLogOn=="false" || isLogOn=='' ){
	alert("로그인 후 주문이 가능합니다!!!");
} 
	var total_price,final_total_price;
	var order_goods_qty=document.getElementById("order_goods_qty");

var formObj=document.createElement("form");
var i_goods_id = document.createElement("input"); 
var i_goods_title = document.createElement("input");
var i_goods_sales_price=document.createElement("input");
var i_fileName=document.createElement("input");
var i_order_goods_qty=document.createElement("input");

i_goods_id.name="goods_id";
i_goods_title.name="goods_title";
i_goods_sales_price.name="goods_sales_price";
i_fileName.name="goods_fileName";
i_order_goods_qty.name="order_goods_qty";

i_goods_id.value=goods_id;
i_order_goods_qty.value=order_goods_qty.value;
i_goods_title.value=goods_title;
i_goods_sales_price.value=goods_sales_price;
i_fileName.value=fileName;

formObj.appendChild(i_goods_id);
formObj.appendChild(i_goods_title);
formObj.appendChild(i_goods_sales_price);
formObj.appendChild(i_fileName);
formObj.appendChild(i_order_goods_qty);

document.body.appendChild(formObj); 
formObj.method="post";
formObj.action="${contextPath}/order/orderEachGoods.do";
formObj.submit();
}	

</script>
</head>
<body>
<div id="productDetail">
	<div class="product_image">
	   <img alt="" src="${contextPath}/thumbnails.do?product_id=${product.product_id}&fileName=${product.product_fileName}">			  
	</div>
<div class="product_description">
  <h1>${product.product_name }</h1>
  <h2>${product.center_name }</h2>
	<div class="product_price">         
		<div class="sales_price"><fmt:formatNumber  value="${product.product_sales_price}" type="number"/>원</div>
	    <div class="price"><fmt:formatNumber  value="${product.product_price}" type="number"/>원</div>
        <div class="discount_rate"><fmt:formatNumber  value="${product.product_sales_price/product.product_price}" type="percent" var="discount_rate" />${discount_rate }</div>
	</div>
	
	<div class="point"><h3>${product.product_point}P(10%적립)</h3></div>
		<div class="option">
		<h1>개월/횟수</h1>
		<select style="width: 200px;padding:5px;" id="order_goods_qty" name="order_goods_qty">
			<option>[필수] 옵션 선택</option>
				<c:forEach var="opt" items="${optList }">
					<option>${opt.product_option_name } (+<fmt:formatNumber  value="${opt.product_option_price }" type="number"/> 원)</option>
				</c:forEach>
 		</select>
	</div>

      <ul>
         <li><a class="buy" href="javascript:fn_order_each_goods('${goods.goods_id }','${goods.goods_title }','${goods.goods_sales_price}','${goods.goods_fileName}');">구매하기 </a></li>
         <li><a class="cart" href="javascript:add_cart('${goods.goods_id}','order_goods_qty')" >장바구니</a></li>
			<li><a class="wish" href="#">찜</a></li>
		</ul>
	</div>

	<!-- 내용 들어 가는 곳 -->
	<div class="product_detail">
		<ul class="tabs">
			<li><a href="#tab1">프로그램 안내</a></li>
			<li><a href="#tab2">이용후기</a></li>
			<li><a href="#tab3">Q&A</a></li>
			<li><a href="#tab4">환불 안내</a></li>
			<li><a href="#tab5">판매자 정보</a></li>
		</ul>
		<div class="tab_container">
			<div class="tab_content" id="tab1">
        <div class="tab_title">
      프로그램 상세정보
          <p>${product.product_program_details}</p>
		<c:forEach var="image" items="${imageList }">
          <img alt="프로그램 상세정보 이미지" src="${contextPath}/download.do?product_id=${product.product_id}&fileName=${image.fileName}">
		</c:forEach>
        </div>

			<div class="tab_title">
        가격 정보     
          <p>${product.product_price_details}</p>
          <c:forEach var="image" items="${priceImage }">
          <img alt="가격 정보 이미지" src="${contextPath}/download.do?product_id=${product.product_id}&fileName=${image.fileName}">
          </c:forEach>
        </div>

        <div class="tab_title">
      시설 정보
                    <p>${product.product_facility_details}</p>
          <c:forEach var="image" items="${facilityImage }">
          <img alt="시설 정보 이미지" src="${contextPath}/download.do?product_id=${product.product_id}&fileName=${image.fileName}">
          </c:forEach>
        </div>

        <div class="tab_title">
        위치 정보
        <p>${product.product_location_details}</p>
<!-- 지도 API -->        
        <div id="map" style="width:600px;height:400px;"></div>
        <!-- 지도 API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=de674c4e967f5ef6143551099c5edf72"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 
</script>

        </div>

			</div>

			<div class="tab_content" id="tab2">
				<div class="tab_title">이용후기</div>
        	<h2 class="total_count">총 ${fn:length(reviewList)}건</h2>
        <table class="review_list">
          <tbody>
            <c:choose>
	   <c:when test="${ empty reviewList  }" >
			<h1>등록된 이용후기가 없습니다.</h1>
	   </c:when>
   <c:otherwise>

            <c:forEach var="review" items="${reviewList }"> 
          <tr class="review_item">
            <td>
              <img alt="이용후기 이미지" src="https://pbs.twimg.com/profile_images/939518831357075456/g5u4AUPT_400x400.jpg">
            </td>
            <td>
              <div class="review_title">${review.review_title}</div>
              <div class="review_option">${review.product_option}</div>    
              <div class="review_content">${review.review_contents}</div>
            </td>
            <td class="review_writer">                          
              <div>${review.member_id}</div>
            </td>
            <td class="review_writeDate">
              <div>${review.review_write_date}</div>
            </td>
          </tr>
 </c:forEach>
</c:otherwise>
</c:choose>
        </tbody>
      </table>

          </div>

			<div class="tab_content" id="tab3">
				<div class="tab_title">Q&A</div>
        <a class="qna_write">문의하기</a>
        	<h2 class="total_count">총 ${fn:length(reviewList)}건</h2>
          <table class="qna_list">
          <tbody>      
 <c:choose>
	   <c:when test="${ empty reviewList  }" >
			<h1>등록된 Q&A가 없습니다.</h1>
	   </c:when>
   <c:otherwise>

            <tr>
              <th style="width:10%">번호</th>
              <th style="width:15%">답변상태</th>
              <th style="width:50%">제목</th>
              <th style="width:20%">작성자</th>
              <th style="width:20%">등록일</th>              
            </tr>

            <c:forEach var="qna" items="${qnaList }"> 
          <tr class="qna_item">
            <td>num</td>
            <td>
              답변상태
            </td>
            <td class="qna_title">                          
              ${qna.qna_title}
            </td>
            <td class="qna_writer">
              ${qna.member_id}
            </td>
            <td>
              ${qna.qna_write_date}
            </td>
          </tr>
              </c:forEach>
     </c:otherwise>
</c:choose>
        </tbody>
      </table>
			</div>
			<div class="tab_content" id="tab4">
				<div class="tab_title">취소 및 환불 규정</div>        
				<h5>취소 및 환불 요청 가능 기간</h5>
				 <p>${fn:replace(product.product_refund_1 ,crcn,br)}</p> 
				<h5>취소 및 환불 불가한 경우</h5>
				 <p>${fn:replace(product.product_refund_2 ,crcn,br)}</p> 
			</div>

			<div class="tab_content" id="tab5">
				<div class="tab_title">판매자 정보</div>        
				<h5>상호명 : ${product.center_name }</h5>
				<h5>대표자 : ${member.member_name }</h5>
				<h5>연락처 : ${member.member_hp }</h5>
				<h5>사업자등록번호 : ${member.owner_eid }</h5>
				<h5>사업장 소재지 : ${member.road_address } ${member.namuji_address}</h5>
				<h5>E-mail : ${member.email1}@${member.email2}</h5>
			</div>
		</div>
	</div>
	

	<div id="layer" style="visibility: hidden">
		<!-- visibility:hidden 으로 설정하여 해당 div안의 모든것들을 가려둔다. -->
		<div id="popup">
			<!-- 팝업창 닫기 버튼 -->
			<a href="javascript:" onClick="javascript:imagePopup('close', '.layer01');"> <img
				src="${contextPath}/resources/image/close.png" id="close" />
			</a> <br /> <font size="12" id="contents">장바구니에 담았습니다.</font><br>
<form   action='${contextPath}/cart/myCartList.do'  >				
		<input  type="submit" value="장바구니 보기">
</form>
    </div>
</body>
</html>