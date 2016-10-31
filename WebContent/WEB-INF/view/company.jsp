<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="<c:url value='/css/bootstrap/bootstrap.min.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/css/ours/comment.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/particleground/style.css'/>"/>
	
	<script src="<c:url value='/js/jquery-1.7.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/js/particleground/jquery.particleground.min.js'/>" type="text/javascript"></script>
  	<script src="<c:url value='/js/particleground/demo.js'/>" type="text/javascript"></script>
</head>
<body>
<div align="center">

    <div id="particles">
        <div class="intro">
    		<h1>Particleground</h1>
    		<p>A jQuery plugin for snazzy background particle systems</p>
  		</div>
    </div><!--topDiv-->
	<br/>
    <div class="navigationDiv">
        <nav class="navbar navbar-default navbar-static-top" role="navigation">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#companydetail"><strong>Home</strong></a></li>
                <li><a href="#">企业信息查看</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        车位管理 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li ><a href="#" onclick="show()">现有车位</a></li>
                        <li><a href="#">租用车位</a></li>
                    </ul>
                </li>
            </ul>

			<div style="display:none">
				<p id="companyId">${company.companyId}</p>
				<p id="companyName">${company.companyName}</p>
			</div>
			
            <div class="tab-content"> 
                <br/><br/>
                <div class="tab-pane active" id="companydetail"  align="left"><!-- 企业信息-->
                    <div align="left">
                        <h3 align="left"> 企业信息</h3>
                    </div>
                    <br/>
                    <div style="margin-left: 250px">
                        <div>
                            <label>企业登陆名&nbsp;&nbsp; ：</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>admins</label><!-- 动态生成-->
                        </div>
                        <br/>
                        <div>
                            <label>企 业 名 称 &nbsp;&nbsp;：</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>lovo朗沃</label><!-- 动态生成-->
                        </div>
                        <br/>
                        <div>
                            <label>企业楼层位置：</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>12楼E座</label><!-- 动态生成-->
                        </div>
                        <br/>
                        <div>
                            <label>联&nbsp;&nbsp;&nbsp; 系&nbsp;&nbsp;&nbsp; 人&nbsp;&nbsp;&nbsp;：</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>某某某</label><!-- 动态生成-->
                        </div>
                        <br/>
                        <div>
                            <label>联 系 电 话 &nbsp;&nbsp;&nbsp;：</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>13666666666</label><!-- 动态生成-->
                        </div>
                    </div>
                </div>
                =============================================================================================
                <div class="companyModify"><!-- 修改企业信息-->
                    <div style="margin-left: 400px">
                        <h3 align="left"> 修改企业信息</h3>
                    </div>
                    <br/>
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业登陆名：</label>
                            <div class="col-sm-5">
                                <p class="form-control-static">admins</p><!-- 动态生成-->
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业名称：</label>
                            <div class="col-sm-5">
                                <p class="form-control-static">lovo朗沃</p><!-- 动态生成-->
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业楼层位置：</label>
                            <div class="col-sm-5">
                                <p class="form-control-static">12楼E座</p><!-- 动态生成-->
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">确认密码：</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系人：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="People">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="Phone">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default">修&nbsp;&nbsp;改</button>
                    </form>
                </div>
                ================================================================================================
                <div class="parking"><!-- 现有车位-->
                    <div class="myTableDiv" style="height: 290px;">
                        <div class="table-responsive">
                            <h3 align="left"> 现有车位</h3>
                            <div align="right">
                            <button  class="btn btn-default">现有车位</button>
                            
                            <button  class="btn btn-default" onclick="kongxianCBDParking()">空闲车位</button>
                            <button  class="btn btn-default" onclick="contractCBDParking()">已租出车位</button>
                            </div>
                            <table class="table table-bordered table-striped table-hover" id="chewei">
                                <tr>
                                    <th>编号</th>
                                    <th>位置</th>
                                    <th>车位编号</th>
                                    <th>合同编号</th>
                                    <th>合同开始日期</th>
                                    <th>合同结束日期</th>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                 	 <td></td>
                                </tr>
                               
                            </table>
                        </div><!--table-responsive-->
                         
                    </div><!-- myTableDiv-->

                    <div align="left" class="pageDiv">
                        <ul class="pagination pagination-sm">
                            <li><a href="#">&laquo;</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </ul>
                    </div><!--分页-->
                </div><!--企业现有车位parking -->
                ===================================================================================================

                <div><!--企业租到的车位-->
                    <div class="myTableDiv" style="height: 290px;">
                        <div class="table-responsive">
                            <h3 align="left"> 以租到车位</h3>
                            <br/>
                            <table class="table table-bordered table-striped table-hover">
                                <tr>
                                    <th>编号</th>
                                    <th>位置</th>
                                    <th>车位编号</th>
                                    <th>合同编号</th>
                                    <th>合同开始日期</th>
                                    <th>合同结束日期</th>
                                </tr>
                                <tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr>
                            </table>
                        </div><!--table-responsive-->
                    </div><!-- myTableDiv-->

                    <div align="left" class="pageDiv">
                        <ul class="pagination pagination-sm">
                            <li><a href="#">&laquo;</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </ul>
                    </div><!--分页-->
                </div>


            </div><!--companyDiv-->
        </nav>
    </div> <!-- navigationDiv -->


</div><!-- 最外层DIV -->


<script src="<c:url value='/js/jquery.json-2.4.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/bootstrap/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/oursjs/company.js'/>" type="text/javascript"></script>
</body>
</html>

<!--
<script src="<c:url value='/js/jquery-1.7.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/bootstrap/bootstrap.min.js'/>" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value='/css/bootstrap/bootstrap.min.css'/>"/>
<link rel="stylesheet" href="<c:url value='/css/ours/comment.css'/>">
-->