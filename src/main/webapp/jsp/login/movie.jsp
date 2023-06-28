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
    //	  #('#searchResult').empty()  // remove�� �ڱ��ڽ����� �� �������� empty�� �����ֵ鸸 ��������
         // 2023-06-21 �ڽ����ǽ� ��û
         $.ajax({
            url:'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
            type:'get',
            data:{
               key:'8243bcf45dc91dd0ed3a2d71df1b347a',
               targetDt: '20230621',
               itemPerPage: '5'
            },              
               /* 'key=Ű��&��¥' */
            success: callback
            , error: function(){
               alert('����')
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
         
         $('#searchResult').append('<h4>' + rank + '��</h4>')
         $('#searchResult').append('<strong>' + name +' </strong>(' + audiCut + '��)')
         $('#searchResult').append('<button>�󼼺���</button>')
         $('#searchResult').append('<hr>')
      }
   }
</script>


</head>
<body>
	<h2>�Ϻ� �ڽ����ǽ� ����</h2>
	�˻��� : <input type="date" id="searchDate"><button>�˻�</button>
	<h3>�˻����</h3>
	<div id="searchResult"></div>
</body>
</html>