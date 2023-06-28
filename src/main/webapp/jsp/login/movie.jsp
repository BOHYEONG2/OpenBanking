<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#searchResult {
		width: 70%;
		height: 500px;
		border: 1px solid red;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
   $(document).ready(function(){
      $('button').click(function(){
    //	  #('#searchResult').empty()  // remove는 자기자신포함 다 없어지고 empty는 하위애들만 지워진다
         // 2023-06-21 박스오피스 요청
         $.ajax({
            url:'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
            type:'get',
            data:{
               key:'8243bcf45dc91dd0ed3a2d71df1b347a',
               targetDt: '20230621',
               itemPerPage: '5'
            },              
               /* 'key=키값&날짜' */
            success: callback
            , error: function(){
               alert('실패')
            }
         })
      })
   })
   
   function callback(result) {
      $('#searchResult').empty()
      let list = result.boxOfficeResult.dailyBoxOfficeList
      for(let i = 0; i < list.length; i++) {
         let movieInfo = list[i]
         let name = movieInfo.movieNm
         let rank = movieInfo.rank
         let audiCut = movieInfo.audiCnt
         
         $('#searchResult').append('<h4>' + rank + '위</h4>')
         $('#searchResult').append('<strong>' + name +' </strong>(' + audiCut + '명)')
         $('#searchResult').append('<button>상세보기</button>')
         $('#searchResult').append('<hr>')
      }
   }
</script>


</head>
<body>
	<h2>일별 박스오피스 서비스</h2>
	검색일 : <input type="date" id="searchDate"><button>검색</button>
	<h3>검색결과</h3>
	<div id="searchResult"></div>
</body>
</html>