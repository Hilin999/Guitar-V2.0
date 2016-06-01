<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guitar销售系统</title>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
</head>

<body>
      <div id="headerwrap">
       <h1>吉他2.0查询系统</h1>
       <hr>
		<div>
		   <form action="../../searchGuitar" method="post">
	        <label> <span>制造商</span>    
		         <input id="builder" type="text" name="builder" />
			</label><br><br>	
			<label> <span>种&nbsp;&nbsp;&nbsp;类</span>    
		         <input id="type" type="text" name="type" />
			</label><br><br>
			 <label><span>弦&nbsp;&nbsp;&nbsp;数</span>    
		         <input id="numStrings" type="text" name="numStrings" />
			</label><br><br>
			 <label><span>前&nbsp;&nbsp;&nbsp;壳</span>    
		         <input id="topWood" type="text" name="topWood" />
			</label><br><br>
			 <label> <span>后&nbsp;&nbsp;&nbsp;壳</span>    
		         <input id="backWood" type="text" name="backWood" />
			</label><br><br>
			
	      <span>&nbsp;</span>
		       <input id="btnQuery" type="submit" class="btn btn-primary" value="查询" />&nbsp;&nbsp;&nbsp;&nbsp; 	
         </form>		
      </div>
     </div>
</body>
</html>