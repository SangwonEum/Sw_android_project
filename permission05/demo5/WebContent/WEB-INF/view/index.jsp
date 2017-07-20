<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>AMMT</title>
	<link rel="stylesheet" href="./css/webcss.css" />
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 
	<script type="text/javascript" src="./js/jquery-1.11.3.min.js"></script>
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
	<script type="text/javascript" src="./js/web.js" ></script> 
		

</head>
<body>
	<header>
		<div class="wrap">
			<h1><a href="#" title="메인페이지 바로가기" class="logo"><span class="hidden">AMMT 모바일 웹마켓 모니터링 시스템</span></a></h1>

			<!-- 로그인전 -->
			<!--  <div class="top_util">
				<div class="link">
					<a href="#">홈</a><a href="#">사이트맵</a>
				</div>
				<div class="sign_up">
					<form action="" method="post">
						<fieldset>
							<legend class="hidden">로그인 하기</legend>
							<label for="userid" class="hidden">아이디</label>
							<input id="userid" type="text" title="아이디" placeholder="아이디">
							<label for="userpw" class="hidden">비밀번호</label>
							<input id="userpw" type="password" title="비밀번호" placeholder="비밀번호">
							<input type="submit" class="topBtn btn_login" value="로그인" title="로그인">
						</fieldset>
					</form>
				</div>
			</div> -->
					
			<!-- 로그인 후 -->
			<div class="top_util">
				<div class="link">
					<span class="welcome"><strong>관리자</strong>님 접속을 환영합니다.</span><a href="#">홈</a><a href="#">사이트맵</a><a href="#">비밀번호 변경하기</a>
				</div><!-- //link -->
				<div class="sign_up">
					<form action="" method="post">
						<fieldset>
							<legend class="hidden">로그인 하기</legend>
							<!-- <input type="button" class="topBtn myPage" title="" value="MY PAGE" name=""/> -->
							<a href="#" class="topBtn logout"><span>로그아웃</span></a>
						</fieldset>
					</form>
				</div> <!-- //sign_up -->
			</div><!-- //top_utill-->

			<nav class="gnb">
				<ul>
					<li><a href="#">AMMT 소개</a></li>
					<li><a href="#">게시판관리</a></li>
					<li><a href="#">앱관리</a></li>
					<li><a href="#">환경관리</a></li>
					<li><a href="#">통계</a></li>
				</ul>
			</nav>

		</div><!-- //wrap -->

			<div class="sub_layer">
				<div class="sub_nav">
					<div>
						<ul class="firstUl">
							<li><a href="#">이용안내</a></li>
							<li><a href="#">위반조항</a></li>
						</ul>

						<ul>
							<li><a href="#">공지사항</a></li>
							<li><a href="#">자료실</a></li>
						</ul>

						<ul>
							<li><a href="#">앱관리</a></li>
							<li><a href="#">앱정보조회</a></li>
							<li><a href="#">메일이력관리</a></li>
						</ul>

						<ul>
							<li><a href="#">사용자관리</a></li>
							<li><a href="#">유형별 메뉴관리</a></li>
							<li><a href="#">코드관리</a></li>
							<li><a href="#">수집정보관리</a></li>
							<li><a href="#">수집시간 및 수동실행관리</a></li>
						</ul>

						<ul>
							<li><a href="#">모니터링통계</a></li>
							<li><a href="#">위반항목통계</a></li>
							<li><a href="#">사용자별 모니터링통계</a></li>
						</ul>
					</div>
				</div> <!-- //sub_nav -->
			</div><!--  //sub_layer-->
		
	</header>
	<section>
		<div class="wrap bordWrap">
				
			<div class="topMenuWrap">
				<div class="topMenu">
					<p>앱관리</p>
					<select name="" title="">
						<option value="" selected="selected">앱관리</option>
						<option value="">앱정보조회</option>
						<option value="">메일이력관리</option>
					</select>
				</div><!-- //topMenu -->
			</div><!-- //topMenuWrap -->

			<div class="bord appWrap">
				<h2>앱정보 등록/수정</h2>

				<div class="app appInfo">
					<p class="title">앱정보</p>
					<table cellpadding="0" cellspacing="0" class="" summary="" >
						<caption class="hidden">앱정보</caption>
						<colgroup>
							<col width="10%"/>
							<col>
							<col width="10%"/>
							<col>
							<col width="10%"/>
							<col>
							<col width="20%"/> 
						</colgroup>
						<tbody>
							<tr>
								<th>앱번호</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
								<th>마켓</th>
								<td>
									<select name="" title="">
										<option value="" selected="selected">플레이스토어</option>
										<option value="">앱스토어</option>
										<option value="">원스토어</option>
									</select>
								</td>
								<th>카테고리</th>
								<td>
									<select name="" title="">
										<option value="" selected="selected">게임</option>
										<option value="">---</option>
										<option value="">---</option>
									</select>
								</td>
								<td colspan="2"><input type="file" class="" title="" value="파일찾기" name=""/></td>
							</tr>
							<tr>
								<th>앱 ID</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
								<th>앱 명</th>
								<td colspan="3"><input type="text" class="appName" title="" value="" name=""/></td>
								<td rowspan="4"><img src=""  alt=""/></td>		
							</tr>
							<tr>
								<th>수집 URL</th>
								<td colspan="5"><input type="text" class="appUrl" title="" value="" name=""/></td>		
							</tr>
							<tr>
								<th>앱 가격</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
								<th>앱 용량</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
								<th>수정일자</th>
								<td><input type="text" class="datetype" title="" value="" name=""/></td>
							</tr>
							<tr>
								<th>이용등급</th>
								<td>
									<select name="" title="">
										<option value="" selected="selected">전체가</option>
										<option value="">---</option>
										<option value="">---</option>
									</select>
								</td>
								<th>결제방법</th>
								<td>
									<select name="" title="">
										<option value="" selected="selected">무료</option>
										<option value="">---</option>
										<option value="">---</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="app devInfo">
					<p class="title">개발사정보</p>
					<table cellpadding="0" cellspacing="0" class="" summary="" >
						<caption></caption>
						<colgroup>
							<col width="10%"/>
							<col>
							<col width="10%"/>
							<col>
							<col width="10%"/>
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>개발사번호</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
								<th>개발사 명</th>
								<td>
									<input type="text" class="devName" title="" value="" name=""/>
									<a href="#"><img src="../img/dev.png"  alt="개발사명으로 찾기" class="devSearch"/></a>
								</td>
								<th>대표자 명</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
								<th>결제방법</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
								<th>홈페이지</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
							</tr>
							<tr>
								<th>주소</th>
								<td colspan="5"><input type="text" class="add" title="" value="" name=""/></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="app moni">
					<p class="title">모니터링 결과</p>
					<table cellpadding="0" cellspacing="0" class="" summary="" >
						<caption></caption>
						<colgroup>
							<col width="10%"/>
							<col>
							<col width="10%"/>
							<col>
							<col width="10%"/>
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>상태</th>
								<td>
									<select name="" title="">
										<option value="" selected="selected">정상</option>
										<option value="">---</option>
									</select>
								</td>
								<th>담당자</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
								<th>결과등록일시</th>
								<td><input type="text" class="" title="" value="" name=""/></td>
							</tr>
							<tr>
								<th>위반조항</th>
								<td colspan="5">
									<input type="checkbox" id="violation1" class="" title="위반조항 1조" value="" name=""/>
									<label for="violation1">위반조항 1조</label>
									<input type="checkbox" id="violation2" class="" title="위반조항 2조" value="" name=""/>
									<label for="violation2">위반조항 2조</label>
									<input type="checkbox" id="violation3" class="" title="위반조항 3조" value="" name=""/>
									<label for="violation3">위반조항 3조</label>
									<input type="checkbox" id="violation4" class="" title="위반조항 4조" value="" name=""/>
									<label for="violation4">위반조항 4조</label>
									<input type="checkbox" id="violation5" class="" title="위반조항 5조" value="" name=""/>
									<label for="violation5">위반조항 5조</label>
									<input type="checkbox" id="violation6" class="" title="위반조항 6조" value="" name=""/>
									<label for="violation6">위반조항 6조</label>
								</td>
							</tr>
							<tr>
								<th class="top">스크린샷</th>
								<td colspan="5">
									<ul class="screen">
										<li>
											<p class="imgs"><a href="#"><img src="./img/temp.jpg"  alt="" width="128" height="86"/></a></p>
											<span class="txt">item1</span>
										</li>
										<li>
											<p class="imgs"><a href="#"><img src=""  alt="" width="128" height="86" id="imgs2"/></a></p>
											<span class="txt">item1</span>
										</li>
										<li>
											<p class="imgs">12</p>
											<span class="txt">item1</span>
										</li>
										<li>
											<p class="imgs">45</p>
											<span class="txt">item1</span>
										</li>
										<li>
											<p class="imgs">45</p>
											<span class="txt">item1</span>
										</li>
									</ul>
								</td>
							</tr>
							<!-- <tr>
								<th>스크린샷 추가</th>
								<td colspan="5"class="screenFile">
									<div class="">
										<input class="uploadName" value="" disabled="disabled">
										<label for="fileFind">파일찾기</label> 
										<input type="file" class="fileFind" id="fileFind" title="" value="" name=""/>
									</div>
								<!--	<div class="">
										<input class="uploadName" value="" disabled="disabled">
										<label for="fileFind">파일찾기</label> 
										<input type="file" class="fileFind" id="fileFind" title="" value="" name=""/>
									</div>
									<div class="">
										<input class="uploadName" value="" disabled="disabled">
										<label for="fileFind">파일찾기</label> 
										<input type="file" class="fileFind" id="fileFind" title="" value="" name=""/>
									</div> 
									<p class="add"><a href="#"><img src="../img/add.gif"  alt="추가"/></a></p>
								</td>
							</tr> -->
						</tbody>
					</table>
					<div class="screenFile">
							<dl class="">
								<dt>스크린샷 추가</dt>
								<dd>
									<input class="uploadName" value="" disabled="disabled">
									<label for="fileFind">파일찾기</label> 
									<input type="file" class="fileFind" id="fileFind" title="" value="" name=""/>
									<input type="button" value="Choose Photo From Android Gallery" onClick="choosePhoto()" />
									<input type="button" value="Upload File" onClick="upload()" />
									<p class="add"><a href="#"><img src="../img/add.gif"  alt="추가"/></a></p>
								</dd>
							</dl>
						
					</div>
				</div>
				<div>
					 <br />
  						  File Uri: <label id="lbluri">no file uri</label>
    						  <br />
  						  File Path: <label id="lblpath">no file path</label>
						  <br/>
					          Save Path : <label id="svpath">no file path</label>
   				          <br />
					
			
			
				</div>

				

			</div><!-- //bord -->

		</div><!-- //wrap -->
	</section>

	<footer>
		<div class="wrap">
			<a href="#"><span class="hidden">메인페이지 바로가기</span></a>
			<div class="addr">
				<p>서울시 강남구 압구정로 36길 18 신구빌딩 4층</p>
				<address>
					<em>/ 안내전화 : 070-8765-8451</em> 
					<em>/ 팩스 : 02-539-8767</em> 
				</address>
				<ul class="">
					<li>사업자번호 120-82-09427 (사)한국무선인터넷산업연합회&nbsp;</li>
					<li>/ 회장 고진</li>
				</ul>
			</div> <!-- //addr -->
			<div class="copy">Copyright 2013 MOIBA ALL RIGHTS RESERVED.</div>
		</div> <!-- //wrap -->
	</footer>

  <script language="javascript" type="text/javascript">
	//<![CDATA[
	$(document).ready(function(){
		var fileTarget = $(".fileFind");
		fileTarget.on("change",function(){
			if(window.FileReader){
				var filename = $(this)[0].files[0].name;
			}
			else{
				var filename = $(this).var().splite("/").pop().split("\\").pop();
			}
			$(this).siblings(".uploadName").val(filename);
		});
	});
	//]]>
	function showAndroidToast(toast) {
            Android.showToast(toast);
        }
        function setFilePath(file) {
            document.getElementById('lblpath').innerHTML = file;
            Android.showToast(file);
        }
        function setFileUri(uri) {
            document.getElementById('lbluri').innerHTML = uri;
            Android.showToast(uri);
        }
	function setRealPath(uri){
		
	    document.getElementById('svpath').innerHTML = uri;
	    Android.showToast(uri);
	}
        function choosePhoto() {
            var file = Android.choosePhoto();
            
        }
	 function setImage(src) {
           document.getElementById('imgs2').src = src;
	   
           
        }
	  function upload() {
          Android.uploadtoServer();
	   
           
        }
      
	</script>


</body>
</html>