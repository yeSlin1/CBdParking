<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="com.pms.bean.Parking"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap/bootstrap.min.css'/>"/>
    <!-- 控制页面布局的CSS文件-->
	<link rel="stylesheet" href="<c:url value='/css/ours/comment.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/particleground/style.css'/>"/>
	
	<script src="<c:url value='/js/jquery-1.7.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/js/particleground/jquery.particleground.min.js'/>" type="text/javascript"></script>
  	<script src="<c:url value='/js/particleground/demo.js'/>" type="text/javascript"></script>
  	<script src="<c:url value='/js/oursjs/personal.js'/>" type="text/javascript"></script>
</head>
<body>
<div align="center">

    <div id="particles">
        <div class="intro">
    		<h1>Particleground</h1>
    		<p>A jQuery plugin for snazzy background particle systems</p>
  		</div>
    </div><!--topDiv-->
	<br />

    <div class="navigationDiv">
        <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#"><strong>Home</strong></a></li>
            <li><a href="#">个人信息</a></li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    出租信息 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#" onclick="fenyeparking()">我的车位</a></li>
                    <li><a href="#">发布租车信息</a></li>
                    <li class="divider"></li>
                    <li><a href="#">查看预约</a></li>
                    <li><a href="#"  onclick="fenyeJilu()">查看历史纪录</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    求租信息 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#" onclick="qiuzufun()">抢车位</li>
                    <li class="divider"></li>
                    <li><a href="#">查看抢租纪录</a></li>
                </ul>
            </li>
        </ul>
        
		<div style="display:none">
			<p id="personalId" >${personal.personalId}</p>
			<p id="personalName">${personal.personalName}</p>
		</div>
		
            <div class="personalDiv">
                <br /><br />
                <div class="personal"><!-- 个人信息-->
                </div>

                <div class="modifyPersonal"><!-- 修改个人信息-->

                </div>

                <div class="parking"><!-- 我的车位-->
                    <div class="myTableDiv" style="height: 290px;">
                        <div class="table-responsive">
                            <h3 align="left"> 我的车位</h3>
                            <div align="right">
                                <button id="addParking" class="btn btn-default btn-default btn-sm">添加新车位</button>
                            </div>
                            <table class="table table-bordered table-striped table-hover" id="myParkingTable" >
                                <tr>
                                    <th>车位ID号</th>
                                    <th>车位所在小区</th>
                                    <th>车位编号</th>
                                    <th>车位产权证编号</th>
                                    <th>删除</th>
                                </tr>                          
                            </table>
                            <div id="fenyebutton"></div>
                        </div><!--table-responsive-->
                    </div><!-- myTableDiv-->
                                      

                    <div align="center" class="pageDiv">
                        <ul id="zuoyouyema" class="pagination pagination-sm">
                        </ul>
                    </div><!--分页-->
                </div><!--parking -->
        =======================================================================================================

                <div class="addParking"><!--增加车位-->
                </div>

                <div class="addParkingMes"><!--发布租车信息-->
                </div>

                <div class="parkingMes"><!--当前有效待租信息-->
                    <div class="myTableDiv">
                        <div class="table-responsive">
                            <h3 align="left"> 当前有效待租信息</h3>
                            <div align="right">
                                <button id="addParkingMsg" class="btn btn-default btn-default btn-sm">发布租车信息</button>
                            </div>
                            <table class="table table-bordered table-striped table-hover"  >
                                <tr>
                                    <th>编号</th>
                                    <th>出租车位</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>点击详情</th>
                                </tr>
                                <tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><tr>
                                    <td>sdfsdf</td>
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
        ======================================================================================================
                <div class="rentLog"><!--出租车为意向详情-->
                    <div class="myTableDiv">
                        <div class="table-responsive">
                            <h3 align="left"> 出租车位意向详情</h3>
                            <div align="left" style="margin-left: 120px">
                                <h4>成都天府街2号不拉不拉</h4><!-- 根据选择的parkingMessage动态修改显示信息-->
                                <h5>2015年11月12日4点   至   2015年12月23日4点</h5><!-- 根据选择的parkingMessage动态修改显示信息-->
                            </div>
                            <table class="table table-bordered table-striped table-hover"  >
                                <tr>
                                    <th>编号</th>
                                    <th>租客</th>
                                    <th>职业</th>
                                    <th>联系电话</th>
                                    <th>信誉度</th>
                                    <th>留言</th>
                                    <th>操作</th>
                                </tr>
                                <tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr><tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
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
        ===================================================================================================
                <div class="historyMes"><!--历史纪录-->
                    <div class="myTableDiv">
                        <div class="table-responsive">
                            <h3 align="left"> 历史成交记录</h3>
                            <br />
                            <table  id="Jilutable"  class="table table-bordered table-striped table-hover"  >
                                <tr>
                                    <th>编号</th>
                                    <th>出租车位</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>租客</th>
                                    <th>操作</th>
                                </tr>
                      
                            </table>
                        </div><!--table-responsive-->
                    </div><!-- myTableDiv-->

                    <div align="left" class="pageDiv">
                        <ul  id="tentfenyeul" class="pagination pagination-sm">
                        </ul>
                    </div><!--分页-->
                </div>
        =======================================================================================================
                <div class="contract"><!--投诉页面-->
                    <div class="myTableDiv" style="height: 170px;">
                        <div class="table-responsive">
                            <h3 align="left"> 我要投诉</h3>
                            <br />
                            <table class="table table-bordered table-striped table-hover"  >
                                <tr>
                                    <th>出租车位</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>租客</th>
                                </tr>
                                <tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                    <td>sdfsdfsdf</td>
                                </tr>
                            </table>
                        </div><!--table-responsive-->
                    </div><!-- myTableDiv-->

                    <div align="left" class="pageDiv">
                        <h5>投诉理由:</h5>
                        <textarea class="form-control" rows="5"></textarea>
                        <br/>
                        <button class="btn btn-default"> 投 诉 </button>
                    </div><!--投诉留言 块-->
                </div>
        =================================================================================================
                <div class="findPark"><!--抢车位（搜索车位-->
                    <div class="myTableDiv">
                        <div class="table-responsive">
                            <h3 align="left"> 抢车位</h3>
                            <div>

                            </div>
                            <table class="table table-bordered table-striped table-hover" id="qiangcheweitab" >
                                <tr>
                                    <th>车位ID号</th>
                                    <th>车位地址</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>包租婆</th>
                                    <th>职业</th>
                                    <th>信誉度</th>
                                    <th>价格</th>
                                    <th>操作</th>
                                </tr>                              
                            </table>
                        </div><!--table-responsive-->
                    </div><!-- myTableDiv-->

                    <div align="center" class="pageDiv">
                        <ul class="pagination pagination-sm" id="zuoyouyemaone">                
                        </ul>
                    </div><!--分页-->
                </div>

                ==============================================================================

                <div class="modalWindow" style="width: 600px" align="center"><!-- 个人信息修改-->
                    <div style="margin-left: 250px">
                        <h3 align="left"> 修改个人信息</h3>
                    </div>
                    <br/>
                    <form class="form-horizontal" role="form">

                        <div class="form-group" >
                            <label class="col-sm-3 control-label">真实姓名：</label>
                            <div class="col-sm-5">
                                <p class="form-control-static">张三</p><!-- 动态生成-->
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号：</label>
                            <div class="col-sm-5">
                                <p class="form-control-static">652301199205166036</p><!-- 动态生成-->
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
                            <label class="col-sm-3 control-label">联系电话：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="Phone">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">家庭住址：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="Address">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职业描述：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="Job">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default">修&nbsp;&nbsp;改</button>
                    </form>
                </div><!--个人信息修改-->
                =======================================================================================

                <div class="modalWindow"><!--modelWindow用于弹出层-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 增加车位申请</h3>
                    </div>
                    <br/>
                    <form class="form-horizontal" role="form" >
                        <div class="form-group">
                            <label class="col-sm-3 control-label">产权证编号：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="产权证编号" id="parkingpropertyNo">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">车位所在小区地址：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="Address" id="parkingAddress">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">小区车位编号：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="车位编号" id="parkingNo">
                            </div>
                        </div>
                        <div class="form-group"><!--上传图标   尚未美化-->
                                <input type="file" id="parkingpicture">
                        </div>
                        <button type="submit" class="btn btn-default" id="shengqing">申&nbsp;&nbsp;请</button>
                    </form>
                </div><!--增加车位申请Div-->
===================================================================================================
                <div class="modalWindow" style="width: 900px;"><!--发布车位信息Div-->
                    <div style="margin-left: 45%">
                        <h3 align="left"> 发布租车位信息</h3>
                    </div>
                    <br/>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">选择待租车位：</label>
                            <div class="col-sm-7">
                                <select class="form-control">
                                    <option>1</option><!--动态生成-->
                                    <option>2</option><!--动态生成-->
                                    <option>3</option><!--动态生成-->
                                    <option>4</option><!--动态生成-->
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租借开始时间：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租借结束时间：</label>
                            <div class="col-sm-7">
                                //日历插件
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出租价格：</label>
                            <div class="col-sm-7 ">
                                <input type="text" class="form-control" placeholder="出租价格">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default">发&nbsp;&nbsp;布</button>
                    </form>
                </div><!--发布车位信息Div-->
        ====================================================================================================
                <div><!--预定车位Div-->
                    <div class="myTableDiv" style="height: 170px;">
                        <div class="table-responsive">
                            <h3 align="left"> 预定</h3>
                            <br />
                            <table class="table table-bordered table-striped table-hover"  >
                                <tr>
                                    <th>车位ID</th>
                                    <th>车位地址</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>包租婆</th>
                                    <th>职业</th>
                                    <th>信誉度</th>
                                    <th>价格</th>
                                </tr>
                                <tr>
                                    <td>sdfsdf</td>
                                    <td>sdfsdfsdf</td>
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
                        <h5>给对方留言:</h5>
                        <textarea class="form-control" rows="5"></textarea>
                        <br/>
                        <button class="btn btn-default"> 预 定 </button>
                    </div><!--投诉留言 块-->
                </div><!--预定车位Div-->
            </div><!--personalDiv-->
        </nav>
    </div> <!-- navigationDiv -->



</div><!-- 最外层DIV -->

<script src="<c:url value='/js/jquery.json-2.4.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/bootstrap/bootstrap.min.js'/>" type="text/javascript"></script>

</body>
</html>