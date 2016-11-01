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
    		
  		</div>
    </div><!--topDiv-->
	<br />
    <div class="navigationDiv">
        <nav class="navbar navbar-default navbar-static-top" role="navigation">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#home"  data-toggle="tab"  aria-expanded="true">Home</a></li>
                <li ><a href="#updateManagerInfoBtnDiv" data-toggle="tab"  aria-expanded="true" >个人信息</a></li>
                <li ><a href="#mycarport" data-toggle="tab"  aria-expanded="true" onclick="changCompanylist()" >企业用户管理</a></li>
             
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                     合同管理 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#Signed" data-toggle="tab"  aria-expanded="true">租户签约</a></li>
                        <li><a href="#Renewal" data-toggle="tab"  aria-expanded="true">租户续约</a></li>
                        <li><a href="#Terminate" data-toggle="tab"  aria-expanded="true">租户解约</a></li>
                        <li class="divider"></li>
                        <li><a href="#Addcarport" data-toggle="tab"  aria-expanded="true">新增外部合约车位</a></li>
                        <li><a href="#EditCarport" data-toggle="tab"  aria-expanded="true">续约外部合约车位</a></li>
                        <li><a href="#DeleteCarport" data-toggle="tab"  aria-expanded="true">解约外部合约车位</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        审批和投诉 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#Audit"  data-toggle="tab"  aria-expanded="true">审批</a></li>
                        <li class="divider"></li>
                        <li><a href="#Complain" onclick="Complainlist()" data-toggle="tab"  aria-expanded="true">处理投诉</a></li>
                    </ul>
                </li>
                <li id="superManager" class="dropdown" style="display:none">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                                           用户管理 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#operatorManager" data-toggle="tab"  aria-expanded="true" onclick="changlist('${manager.managerId}','${manager.userType}')">用户管理</a></li>
                        <li><a href="#operatorAdd" data-toggle="tab"  aria-expanded="true">新增用户</a></li>
                        <li><a href="#operatorEdit" data-toggle="tab"  aria-expanded="true" >修改用户</a></li>
                    </ul>
                </li>
                <div ><!-- session信息 -->
                	<p id="userType" style="display: none">${manager.userType}</p>
                </div>
            </ul>

            <div class=" tab-content header">
                
                
                <br/><br/>
               <div class="tab-pane active " id="home" ><!-- 修改管理员信息-->
                    <div >
                        <h3 style="margin-left: 600px" align="left"> 车位信息管理系统</h3>
                    
                    <img alt="" src="/img/parking.jpg">
                    </div>
                    <br/>
                    
                </div>

                <div class="tab-pane " id="updateManagerInfoBtnDiv"><!-- 修改管理员信息-->
                    <div style="margin-left: 600px">
                        <h3 align="left"> 个人信息管理</h3>
                    </div>
                    <br/>
                    <form class="form-horizontal" role="form" id="Managerupdate" action="" method="post">

                        <div class="form-group">
                            <label class="col-sm-3 control-label">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                            <div class="col-sm-5">
                                <!-- 动态生成-->
                                 <input type="text" class="form-control" name="managerNo"  value="${manager.managerNo}"></input>
                            <input type="text" style="display: none;" name="managerId"  value="${manager.managerId}"></input>
                        
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">真实姓名：</label>
                            <div class="col-sm-5">
                             <!-- 动态生成-->
                                  <input type="text" class="form-control" name="managerName" id="managerPhone" value="${manager.managerName}"></input>
                        
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="managerPhone" id="managerPhone" value="${manager.managerPhone}"></input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：</label>
                               <div>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" name="user" value=""> 用户管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" name="carport" value=""> 车位管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" name="contract" value=""> 合同管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" name="complain" value=""> 投诉管理
                            </label>
                        </div>
                        </div>
                        <button  type="button" onclick="Update()"  class="btn btn-default">修&nbsp;&nbsp;改</button>
                    </form>
                </div>
              
                <div class="tab-pane" id="mycarport"   ><!-- 我的车位-->
                    <div class="myTableDiv" style="height: 290px;">
                        <div class="table-responsive">
                            <h3 align="left"> 企业用户管理</h3>
                            <input type="text" id="ComtableValue" style="display:none;" value="" >
                            <div align="right">
                                <div class="col-sm-4">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="输入企业名称查找">
                                        <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">Go!</button>
                                        </span>
                                    </div><!-- /input-group -->
                                </div>
                                <button id="addCompany" class="btn btn-default btn-default btn-sm">新增企业</button>
                                <button id="delCompany" class="btn btn-default btn-default btn-sm">删除企业</button>
                            </div>
                            <table id="Comtable" class="table table-bordered table-striped table-hover">
                               <thead> 
                                  <tr>
                                    <th>编号</th>
                                    <th>企业名称</th>
                                    <th>企业楼层</th>
                                    <th>企业联系人</th>
                                    <th>联系电话</th>
                                  </tr>
                               </thead>
                               <tbody>
                                
                               </tbody> 
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
                </div><!--parking -->
             

                <div class="tab-pane" id="AddCpmpany"><!--增加企业-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 新增企业</h3>
                    </div>
                    <br/>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业登录名：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="userName" placeholder="企业登录名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业登陆密码：</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="userPassword" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">确认密码：</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业名称：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="companyName" placeholder="企业名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业楼层位置：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="companyAddress" placeholder="企业楼层位置">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业联系人：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control"name="companyResponsible" placeholder="企业联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control"name="companyPhone" placeholder="企业联系电话">
                            </div>
                        </div>
                        <button type="button" id="AddCpmpany_btn" class="btn btn-default">新&nbsp;&nbsp;增</button>
                    </form>
                </div>
          
                <div class="tab-pane" id="Signed"><!--租户签约-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 租户签约</h3>
                    </div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业用户名：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" placeholder="企业用户名">
                            </div>
                            <div class="col-sm-1 ">
                                <input type="button" value="搜索" class="btn btn-default">
                            </div>
                        </div>
                        <div id="" class="" style="width: 720px   ">
                        <table class="table table-bordered table-striped table-hover">
                            <tr>
                                <th>企业名称</th>
                                <th>企业楼层</th>
                                <th>企业联系人</th>
                                <th>联系电话</th>
                            </tr>
                            <tr>
                                <td>sdfsdfsdf</td>
                                <td>sdfsdfsdf</td>
                                <td>sdfsdfsdf</td>
                                <td>sdfsdfsdf</td>
                            </tr><!--动态生成-->
                        </table>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同编号：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="合同编号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同生效日期：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同截至日期：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-5">
                                <input type="button" value="增加车位" class="btn btn-default">
                            </div>
                        </div>
                        <div id="" class="" style="width: 720px   ">
                            <table class="table table-bordered table-striped table-hover">
                                <tr>
                                    <th>序号</th>
                                    <th>车位所在地址</th>
                                    <th>车位编号</th>
                                    <th>操作</th>
                                </tr>
                                <tr>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><!--动态生成-->
                            </table>
                        </div>

                        <button type="submit" class="btn btn-default">合同新增确定</button>
                    </form>
                </div>
          
                <div class="tab-pane"  id="Renewal"><!--确认续约-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 租户续约</h3>
                    </div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同编号：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" placeholder="企业用户名">
                            </div>
                            <div class="col-sm-1 ">
                                <input type="button" value="查询" class="btn btn-default">
                            </div>
                        </div>
                        <div id="" class="" style="width: 720px   ">
                            <table class="table table-bordered table-striped table-hover">
                                <tr>
                                    <th>合同编号</th>
                                    <th>企业名称</th>
                                    <th>对方联系人</th>
                                    <th>对方联系电话</th>
                                    <th>车位所在单位详细地址</th>
                                    <th>车位编号</th>
                                </tr>
                                <tr>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><!--动态生成-->
                            </table>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">新续合同编号：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="新合同编号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">对方联系人：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="对方联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">对方联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="对方联系电话">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同生效日期：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同截至日期：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>

                        <button type="submit" class="btn btn-default">合同新增确定</button>
                    </form>

                </div>
          
                <div class="tab-pane"  id="Terminate"><!--租户解约-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 租户解约</h3>
                    </div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">原合同编号：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control">
                            </div>
                            <div class="col-sm-1 ">
                                <input type="button" value="查询" class="btn btn-default">
                            </div>
                        </div>
                        <div id="" class="" style="width: 720px   ">
                            <table class="table table-bordered table-striped table-hover">
                                <tr>
                                    <th>合同编号</th>
                                    <th>企业名称</th>
                                    <th>对方联系人</th>
                                    <th>对方联系电话</th>
                                    <th>车位所在单位详细地址</th>
                                    <th>车位编号</th>
                                </tr>
                                <tr>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><!--动态生成-->
                            </table>
                        </div>

                        <button type="submit" class="btn btn-default">解&nbsp;&nbsp;约</button>
                    </form>
                </div>
                                   
                <div class="tab-pane"  id="Addcarport"><!--新增外部合约车位-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 租户续约</h3>
                    </div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同编号：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" placeholder="企业用户名">
                            </div>
                            <div class="col-sm-1 ">
                                <input type="file"  class="btn btn-default">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同单位：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="合同单位">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">对方联系人：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="对方联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">对方联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="对方联系电话">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">车位所属单位详细地址：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="车位所属单位详细地址">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同生效日期：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同截至日期：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-5">
                                <input type="button" value="增加车位" class="btn btn-default">
                            </div>
                        </div>
                        <div id="" class="" style="width: 720px   ">
                            <table class="table table-bordered table-striped table-hover">
                                <tr>
                                    <th>序号</th>
                                    <th>车位编号</th>
                                    <th>操作</th>
                                </tr>
                                <tr>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><!--动态生成-->
                            </table>
                        </div>
                        <button type="submit" class="btn btn-default">合同新增确定</button>
                    </form>
                </div>
              
                <div class="tab-pane contract"  id="EditCarport"><!--外部车位续约-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 外部车位续约</h3>
                    </div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同编号：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" placeholder="合同编号">
                            </div>
                            <div class="col-sm-1 ">
                                <input type="button" value="查询"  class="btn btn-default">
                            </div>
                        </div>
                        <div id="" class="" style="width: 720px   ">
                            <table class="table table-bordered table-striped table-hover">
                                <tr>
                                    <th>合同编号</th>
                                    <th>合同单位</th>
                                    <th>对方联系人</th>
                                    <th>对方联系电话</th>
                                    <th>车位所在单位详细地址</th>
                                    <th>车位编号</th>
                                </tr>
                                <tr>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><!--动态生成-->
                            </table>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">新续合同编号：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" placeholder="新续合同编号">
                            </div>
                            <div class="col-sm-1 ">
                                <input type="file"  class="btn btn-default">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同单位：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="合同单位">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">对方联系人：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="对方联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">对方联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="对方联系电话">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同生效日期：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同截至日期：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>

                        <button type="submit" class="btn btn-default">确认续约</button>
                    </form>
                </div>
              
                <div class="tab-pane"  id="DeleteCarport"><!--外部车位解约-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 外部车位解约</h3>
                    </div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">合同编号：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" placeholder="合同编号">
                            </div>
                            <div class="col-sm-1 ">
                                <input type="button" value="查询"  class="btn btn-default">
                            </div>
                        </div>
                        <div id="" class="" style="width: 720px   ">
                            <table class="table table-bordered table-striped table-hover">
                                <tr>
                                    <th>合同编号</th>
                                    <th>合同单位</th>
                                    <th>对方联系人</th>
                                    <th>对方联系电话</th>
                                    <th>车位所在单位详细地址</th>
                                    <th>车位编号</th>
                                </tr>
                                <tr>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><!--动态生成-->
                            </table>
                        </div>

                        <button type="submit" class="btn btn-default">确认解约</button>
                    </form>
                </div><!--外部车位解约-->
                                  
                <div class="tab-pane" id="Audit"><!--新增待审车位-->
                    <div class="myTableDiv">
                        <div class="table-responsive">
                            <h3 align="left"> 新增待审车位</h3>
                            <br />
                            <table class="table table-bordered table-striped table-hover"  >
                              <thead>  <tr>
                                    <th>用户名</th>
                                    <th>真实姓名</th>
                                    <th>身份证号</th>
                                    <th>提交时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr>
                            </tbody>
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
                </div><!--新增待审车位-->
                                
                <div class="tab-pane"  id="Complain"><!--投诉-->
                    <div class="myTableDiv">
                        <div class="table-responsive">
                            <h3 align="left"> 投诉</h3>
                            <br />
                            <input type="text" style="display: none;" id="ComplainData" value="">
                            <table id="Complains" class="table table-bordered table-striped table-hover"  >
                                <tr>
                                    <th>投诉方</th>
                                    <th>被投诉方</th>
                                    <th>投诉时间</th>
                                    <th>操作</th>
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
                </div><!--投诉-->
                                   
                <div class="tab-pane" id="operatorManager"><!-- 用户管理-->
                   
                        <div class="table-responsive">
                            <h3 align="left"> 用户管理</h3>
                            <div align="right">
                                <button id="" class="btn btn-default btn-default btn-sm">新增用户</button>
                                <button id="" class="btn btn-default btn-default btn-sm">修改用户</button>
                                <button id="" class="btn btn-default btn-default btn-sm">删除用户</button>
                            </div>
                              <table id="emtable" class="table table-bordered table-striped table-hover"  >
                             <thead>
                               <tr>
                                    <th>编号</th>
                                    <th>出租车位</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>点击详情</th>
                                </tr>
                                </thead>
                               <tbody>
                               
                                </tbody>
                            </table>
                        </div><!--table-responsive-->
                   

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
                  
                <div class="tab-pane" id="operatorAdd"><!--新增用户-->
                    <div style="margin-left: 450px">
                        <h3 align="left"> 新增用户</h3>
                    </div>
                    <br/>
                    <form  action="/manager/save" class="form-horizontal" role="form">
                        <input type="text"  style="display:none;" name="managerIds" value="${manager.managerId}">  
                        <div class="form-group" >
                            <label class="col-sm-3 control-label">工号：</label>
                            <div class="col-sm-7">
                                <input type="text" name="managerNo" class="form-control" placeholder="工号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                            <div class="col-sm-7">
                                <input type="password" name="password" class="form-control" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">确认密码：</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3  control-label">姓名：</label>
                            <div class="col-sm-7">
                                <input type="text" name="managerName" class="form-control" placeholder="姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" name="managerPhone" class="form-control" placeholder="Phone">
                            </div>
                        </div>
                        <div>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" name="user" value="option1"> 用户管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" name="carport" value="option2"> 车位管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" name="contract" value="option3"> 合同管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" name="complain" value="option3"> 投诉管理
                            </label>
                        </div>
                        <button type="submit" id="adduser" class="btn btn-default">增&nbsp;&nbsp;加</button>
                    </form>
                </div><!--新增用户-->
                 
                <div class="tab-pane" id="operatorEdit">
                    <div style="margin-left: 450px">
                        <h3 align="left"> 修改用户</h3>
                    </div>
                    <br/>
                    <form class="form-horizontal" role="form">

                        <div class="form-group" >
                            <label class="col-sm-3 control-label">工号：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="工号">
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
                            <label class="col-sm-3 control-label">姓名：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="Phone">
                            </div>
                        </div>
                        <div>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" value="option1"> 用户管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" value="option2"> 车位管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" value="option3"> 合同管理
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" id="" value="option3"> 投诉管理
                            </label>
                        </div>
                        <button type="submit" class="btn btn-default">修&nbsp;&nbsp;改</button>
                    </form>
                </div><!--修改用户-->
                                 
            </div><!--personalDiv-->
        </nav>
    </div> <!-- navigationDiv -->


</div><!-- 最外层DIV -->

<script src="<c:url value='/js/jquery.json-2.4.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/bootstrap/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/oursjs/lcmManager.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/oursjs/manager.js'/>" type="text/javascript"></script>
<script >
$(function(){
	
	$('#adduser').on("click",function(){
		
		console.log("添加用户啊啊 啊啊啊啊 啊啊啊");
	
	
	})
	

})

$('#addCompany').on("click",function(){
	
	 $('#mycarport').removeClass("active");
	 $('#AddCpmpany').addClass("active");
	
});


$('#AddCpmpany_btn').on("click",function(){
	

	var  userName   = $("[name='userName']").val() ;//用户名
	var  userPassword= $("[name='userPassword']").val() ;//用户密码
	var  companyName= $("[name='companyName']").val() ;// 企业名称
	var companyAddress= $("[name='companyAddress']").val() ;// 企业地址
	var companyResponsible= $("[name='companyResponsible']").val() ;// 企业责任人
	var companyPhone= $("[name='companyPhone']").val() ;// 企业电话

	var parameter = {
			"userName":userName ,
			"userPassword"	:userPassword ,
			"companyPhone"	:companyPhone ,
			"companyResponsible":companyResponsible ,
			"companyAddress"	:companyAddress ,
			"companyName"	:companyName 
		};
	$.ajax({
		type : "POST",
		async : true,
		data : parameter,
		url : "/company/save",
		success : function(data) {
			
		if (data == "0") {
			alert("修改成功");
			 $('#AddCpmpany').removeClass("active");
			 $('#home').addClass("active");
			 $('#ComtableValue').val("");
		}else{
			alert("修改失败");
		}
		
		}
	});

});




function Update(){
	var managerId = $("[name='managerId']").val() ; // 管理员ID
	var managerName   = $("[name='managerName']").val() ;// 管理员名字
	var managerPhone = $("[name='managerPhone']").val()   ;// 管理员电话
	var managerNo     = $("[name='managerNo']").val()    ; // 管理员编号
	var parameter = {
		"managerId"	:managerId ,
		"managerName":managerName ,
		"managerPhone"	:managerPhone ,
		"managerNo"	:managerNo 
	};
	
	$.ajax({
		type : "POST",
		async : true,
		data : parameter,
		url : "/manager/update",
		success : function(data) {
			
		if (data == "0") {
	
			alert("修改成功");
		}else{
			alert("修改失败");
		}
		
		}
	});
}

function changCompanylist(){
	var $ComtableValue = $('#ComtableValue');
	
	if ( $ComtableValue.val()!=""&& $ComtableValue.val()!=null) {
		
	} else {	
	$.ajax({
		type : "POST",
		async : true,
		url : "/company/list",
		success : function(data) {
		console.log(data);	
        var $table =$('#Comtable');
	    for (var  i= 0; i <5; i++) {
	    	var tr = "<tr><td>"+data[i].companyId+"</td>"
	    	+"<td>"+data[i].companyName+"</td>"
	    	+"<td>"+data[i].companyAddress+"</td>"
	    	+"<td>"+data[i].companyResponsible+"</td>"
	    	+"<td>"+data[i].companyPhone+"</td></tr>";
	    	$ComtableValue.val(data);
			//$("table").append(tr);
			$table.append(tr);

	   }
		}
	});
	}
}


function Complainlist(){
	var $ComplainData = $('#ComplainData');
	if ($ComplainData.val()!="" && $ComplainData.val()!= null) {
		
	} else {
		$.post('/Complain/list',function(orgData){
			console.log(orgData);
	        var data = orgData;
	        var $table =$('#Complains');
		    for (var  i= 0; i <6; i++) {
		    	var tr = "<tr><td>"+orgData[i].complainFrom.personalRealName+"</td>"
		    	+"<td>"+orgData[i].complainTo.personalRealName+"</td>"
		    	+"<td>"+orgData[i].complainTime+"</td>"
		    	+"<td>"+orgData[i].complainTime+"</td></tr>";
		    	$(ComplainData).val(orgData);
				//$("table").append(tr);
				$table.append(tr);

		   }
	        
		});
	}
	
	
	
}



function changlist(name,value)
{
	
	console.log(name) ;
	console.log(value) ;
	var name1 = name;
	var value1 =value;
	$.post('/parkingMsg/list','name='+name+"&value="+value,function(orgData){
		console.log(orgData);
        var data = orgData;
        var $table =$('#emtable');
	    for (var  i= 0; i < 6; i++) {
	    	var tr = "<tr><td>"+orgData[i].parkingMsgId+"</td>"
	    	+"<td>"+orgData[i].parking.parkingAddress+"</td>"
	    	+"<td>"+orgData[i].startTime+"</td>"
	    	+"<td>"+orgData[i].endTime+"</td>"
	    	+"<td>"+orgData[i].parkingMsgId+"</td></tr>";
			//$("table").append(tr);
			$table.append(tr);

	   }
        
	});
	

	
	
}



</script>
</body>
</html>