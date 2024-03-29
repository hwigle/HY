<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="../resources/css/admin/main.css">
 
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
</head>
<body>
 
    <div class="wrapper">
        <div class="wrap">
            <!-- gnv_area -->    
            <div class="top_gnb_area">
                <ul class="list">    
                    <li><a href="/main">메인 페이지</a></li>
                    <li><a href="/member/logout.do">로그아웃</a></li>
                    <li>고객센터</li>            
                </ul>
            </div>
            <!-- top_subject_area -->
            <div class="admin_top_wrap">
                <span>관리자 페이지</span>
                
            </div>
            <!-- contents-area -->
            <div class="admin_wrap">
                <!-- 네비영역 -->
                <div class="admin_navi_wrap">
	              <ul>
	                  <li >
	                      <a class="admin_list_01" href="/admin/goodsEnroll">상품 등록</a>
	                  </li>
	                  <li>
	                      <a class="admin_list_02" href="/admin/goodsManage">상품 관리</a>
	                  </li>
	                  <lI>
	                      <a class="admin_list_03" href="/admin/authorEnroll">작가 등록</a>                            
	                  </lI>
	                  <lI>
	                      <a class="admin_list_04" href="/admin/authorManage">작가 관리</a>                            
	                  </lI>
	                  <lI>
	                      <a class="admin_list_05">회원 관리</a>                            
	                  </lI>                                                                                             
	              </ul>
<!-- 
                    <div class="admin_list_01">
                        <a>상품 관리</a>
                    </div>
                     -->
                </div>
                <div class="admin_content_wrap">
                    <div>관리자 페이지 입니다.</div>
                </div>
                <div class="clearfix"></div>
            </div>
            <!-- Footer 영역 -->
        <div class="footer_nav">
            <div class="footer_nav_container">
                <ul>
                    <li>회사소개</li>
                    <span class="line">|</span>
                    <li>이용약관</li>
                    <span class="line">|</span>
                    <li>고객센터</li>
                    <span class="line">|</span>
                    <li>광고문의</li>
                    <span class="line">|</span>
                    <li>채용정보</li>
                    <span class="line">|</span>
                </ul>
            </div>
        </div> <!-- class="footer_nav" -->
        
        <div class="footer">
            <div class="footer_container">
                
                <div class="footer_left">
                    <img src="/resources/img/logo.png">
                </div>
                <div class="footer_right">
                    (주) HYBook    대표이사 : 진휘용
                    <br>
                    사업자등록번호 : 143-25-55643
                    <br>
                    대표전화 : 1588-0045
                    <br>
                    <br>
                    COPYRIGHT(C) <strong>https://github.com/hwigle/HY.git</strong>  ALL RIGHTS RESERVED.
                </div>
                <div class="clearfix"></div>
            </div>
        </div> <!-- class="footer" -->   
	</div>
</div>
</body>
</html>
