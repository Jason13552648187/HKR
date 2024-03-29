<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新增员工信息</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/layui/css/layui.css">
		<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/add.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jsps/common_css/scroll.css">
	</head>
	<body style="height: 100%;">
		<!--表单开始-->
		<div id="layform" class="layui-form  layui-form-pane"  lay-filter="layform">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;padding:15px 30px;">
				<legend>员工基本信息</legend>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-inline">
						<input class="layui-input" placeholder="添加后不允许修改" name="username" id="username" lay-verify="required" type="text" autocomplete="off"/>
					</div>
				</div>

				
				<div class="layui-inline">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-inline">
						<input class="layui-input" placeholder="添加后不允许修改" name="idcard" id="idcard" lay-verify="required" type="text" autocomplete="off" placeholder="" />
					</div>
				</div>
				
				
				
				<!--下拉选项-->
				<div class="layui-inline">
					<label class="layui-form-label">籍贯</label>
					<div  class="layui-input-inline">
						<input class="layui-input" name="rawaddress" id="rawaddress" lay-verify="required" type="text" autocomplete="off" placeholder="居住地址" />
					</div>
				</div>

				<div class="layui-inline">
				    <label class="layui-form-label">民族</label>
				    <div class="layui-input-inline">
                        <select name="nationa"  lay-filter="nationa" lay-verify="required" id="nationa">
                            <option value=""></option>
                            <option value="汉族">汉族</option>
                            <option value="穿青族">穿青族</option>
                            <option value="壮族">壮族</option>
                            <option value="满族">满族</option>
                            <option value="回族">回族</option>
                            <option value="苗族">苗族</option>
                            <option value="维吾尔族">维吾尔族</option>
                            <option value="土家族">土家族</option>
                            <option value="彝族">彝族</option>
                            <option value="蒙古族">蒙古族</option>
                            <option value="藏族">藏族</option>
                            <option value="布依族">布依族</option>
                            <option value="侗族">侗族</option>
                            <option value="瑶族">瑶族</option>
                            <option value="朝鲜族">朝鲜族</option>
                            <option value="白族">白族</option>
                            <option value="哈尼族">哈尼族</option>
                            <option value="哈萨克族">哈萨克族</option>
                            <option value="黎族">黎族</option>
                            <option value="傣族">傣族</option>
                            <option value="畲族">畲族</option>
                            <option value="傈僳族">傈僳族</option>
                            <option value="仡佬族">仡佬族</option>
                            <option value="东乡族">东乡族</option>
                            <option value="高山族">高山族</option>
                            <option value="拉祜族">拉祜族</option>
                            <option value="水族">水族</option>
                            <option value="佤族">佤族</option>
                            <option value="纳西族">纳西族</option>
                            <option value="羌族">羌族</option>
                            <option value="土族">土族</option>
                            <option value="仫佬族">仫佬族</option>
                            <option value="锡伯族">锡伯族</option>
                            <option value="柯尔克孜族">柯尔克孜族</option>
                            <option value="达斡尔族">达斡尔族</option>
                            <option value="景颇族">景颇族</option>
                            <option value="毛南族">毛南族</option>
                            <option value="撒拉族">撒拉族</option>
                            <option value="布朗族">布朗族</option>
                            <option value="塔吉克族">塔吉克族</option>
                            <option value="阿昌族">阿昌族</option>
                            <option value="普米族">普米族</option>
                            <option value="鄂温克族">鄂温克族</option>
                            <option value="怒族">怒族</option>
                            <option value="京族">京族</option>
                            <option value="基诺族">基诺族</option>
                            <option value="德昂族">德昂族</option>
                            <option value="保安族">保安族</option>
                            <option value="俄罗斯族">俄罗斯族</option>
                            <option value="裕固族">裕固族</option>
                            <option value="乌孜别克族">乌孜别克族</option>
                            <option value="门巴族">门巴族</option>
                            <option value="鄂伦春族">鄂伦春族</option>
                            <option value="独龙族">独龙族</option>
                            <option value="塔塔尔族">塔塔尔族</option>
                            <option value="赫哲族">赫哲族</option>
                            <option value="珞巴族">珞巴族</option>

                        </select>
				    </div>
				</div>


				<div class="layui-inline">
					<label class="layui-form-label">联系电话</label>
					<div class="layui-input-inline">
						<input class="layui-input" name="phoneNumber" id="phoneNumber" lay-verify="required|phone" type="text" autocomplete="off"  />
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-inline">
						<input class="layui-input" name="email" id="email" lay-verify="required|email" type="text" autocomplete="off"  />
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">微信号</label>
					<div class="layui-input-inline">
						<input class="layui-input" name="wechat" id="wechat" type="text" autocomplete="off"  />
					</div>
				</div>


                <div class="layui-inline">
                    <label class="layui-form-label">来源</label>
                    <div class="layui-input-inline">

                        <select name="sourcefrom"  lay-filter="sourcefrom" lay-verify="required" id="sourcefrom">
                            <option value=""></option>
                            <option value="总代理">总代理</option>
                            <option value="宏软高科">宏软高科</option>
                        </select>
                    </div>
                </div>
			</div>
			<!--基本信息结束-->

			</fieldset>
			 <!--教育信息-->
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;padding:15px 30px;;">
  			<legend>教育信息</legend>
			 <div class="layui-form-item">
			 	<div class="layui-inline">
				 	<label class="layui-form-label">毕业院校</label>
				 	<div class="layui-input-inline">
				 		<input type="text" name="school" id="school" title="毕业院校" class="layui-input" lay-verify="required"/>
				 	</div>
				</div>
				
				
				<div class="layui-inline">
				 	<label class="layui-form-label">专业</label>
				 	<div class="layui-input-inline">
				 		<input type="text" name="professional" id="professional" title="所学专业" class="layui-input" lay-verify="required"/>
				 	</div>
				</div>
				
				
				
				<div class="layui-inline">
				 	<label class="layui-form-label">毕业时间</label>
					<div class="layui-input-inline">
						<input  type="text" readonly="readonly" id="gradutime" id="gradutime" name="gradutime" class="layui-input" lay-verify="required"/>
					</div>

				</div>
				
				
				
				
				<div class="layui-inline">
				 	<label class="layui-form-label">学历水平</label>
				 	<div class="layui-input-inline">
				 		<select name="edulevel" id="edulevel" lay-filter="edulevel" lay-verify="required">
					        <option value=""></option>
					        <option value="专科">专科</option>
					        <option value="本科">本科</option>
                            <option value="中专">中专</option>
						</select>
				 	</div>
				</div>
				
				
				<div class="layui-inline">
				 	<label class="layui-form-label">毕业证明人</label>
				 	<div class="layui-input-inline"  >
				 		<input type="text" name="educonfirm" id="educonfirm" class="layui-input"  />
				 	</div>
				</div>
				
				<div class="layui-inline">
				 	<label class="layui-form-label">证明人联系方式</label>
				 	<div class="layui-input-inline"  >
				 		<input type="text" name="edutelnumber" id="edutelnumber" class="layui-input"  />
				 	</div>
				</div>
				 	
				 	
			 </div>
			</fieldset>
			<!--历史工作信息-->
			<!--公司名称、职位、工作起始日期、工作结束日期、工作任务简述-->
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px; padding:15px 30px;;">
  			<legend>以往工作信息</legend>
			<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">公司名称</label>
						<div class="layui-input-inline">
							<input  type="text" class="layui-input" name="company" id="company"  />
							 
						</div>
					</div>
					
					
					
					<div class="layui-inline">
						<label class="layui-form-label">所在职位</label>
						<div class="layui-input-inline">
							<input  type="text" class="layui-input" name="job"  id="job" />
						</div>
					</div>
					
					
					
					<div class="layui-inline">
						<label class="layui-form-label">起始日期</label>
						<div class="layui-input-inline">
							<input  type="text" readonly="readonly" class="layui-input" name="starttime"  id="starttime" />
						</div>
					</div>
					
					
					<div class="layui-inline">
						<label class="layui-form-label">结束日期</label>
						<div class="layui-input-inline">
							<input  type="text" readonly="readonly" class="layui-input" name="endtime"  id="endtime" />
						</div>
					</div>

					
			</div>
			<div class="layui-form-item layui-form-text" style="width:90%">
				<label class="layui-form-label">工作任务简述</label>
				<div class="layui-input-block">
					<textarea name="workdetail" id="workdetail" class="layui-textarea"></textarea>
				</div>
			</div>
			</fieldset>



            <!--以往的培训经历-->
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px; padding:15px 30px;;">
                <legend>以往培训记录</legend>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">公司名称</label>
                        <div class="layui-input-inline">
                            <input  type="text" class="layui-input" name="tcompany" id="tcompany"  />

                        </div>
                    </div>



                    <div class="layui-inline">
                        <label class="layui-form-label">起始日期</label>
                        <div class="layui-input-inline">
                            <input  type="text" readonly="readonly" class="layui-input" name="tstarttime"  id="tstarttime" />
                        </div>
                    </div>


                    <div class="layui-inline">
                        <label class="layui-form-label">结束日期</label>
                        <div class="layui-input-inline">
                            <input  type="text" readonly="readonly" class="layui-input" name="tendtime"  id="tendtime" />
                        </div>
                    </div>



                <div class="layui-inline">
                    <label class="layui-form-label">学习科目</label>
                    <div class="layui-input-inline">
                        <input  type="text" class="layui-input" name="learntitle" id="learntitle"  />
                    </div>
                </div>
                </div>
            </fieldset>




			<!--父母联系方式-->
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;padding:15px 30px;;">
  			<legend>父母联系方式</legend>
			<div class="layui-form-item">
                <div>
                    <div class="layui-inline">
                        <label class="layui-form-label">联系人</label>
                        <div class="layui-input-inline">
                            <input name="contact"  class="layui-input" lay-verify="required" id="contact"/>
                        </div>
                    </div>



                    <div class="layui-inline">
                        <label class="layui-form-label">与本人关系</label>
                        <div class="layui-input-inline">
                            <select name="relation" lay-filter="relation" lay-verify="required" id="relation">
                                <option value=""></option>
                                <option value="母亲">母亲</option>
                                <option value="父亲">父亲</option>
                            </select>
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">工作单位</label>
                        <div class="layui-input-inline">
                            <input name="unit"  class="layui-input" id="unit"/>
                        </div>
                    </div>


                    <div class="layui-inline">
                        <label class="layui-form-label">职务</label>
                        <div class="layui-input-inline">
                            <input name="workjob"  class="layui-input" id="workjob"/>
                        </div>
                    </div>


                    <div class="layui-inline">
                        <label class="layui-form-label">联系电话</label>
                        <div class="layui-input-inline">
                            <input name="telphone"  class="layui-input" lay-verify="required" id="telphone"/>
                        </div>
                    </div>
                </div>



			</div>


			</fieldset>

			<%--财务状况：仅限行政人员可修改和添加--%>
			<%
				if(request.getSession().getAttribute("triod").toString().equals("2")){
			%>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;padding:15px 30px;">
				<legend>员工财务状态</legend>
				<div class="layui-form-item">
					<div class="layui-inline" >
						<label class="layui-form-label"  style="width:110px;" >目前财务状况</label>
						<div class="layui-input-block">
							<select name="compactname" lay-filter="compactname" lay-verify="required" id="compactname">
								<option value=""></option>
								<option value="分期">分期</option>
								<option value="已结清">已结清</option>
								<option value="未学完">未学完</option>
								<option value="违约">违约</option>
							</select>
						</div>
					</div>
				</div>
			</fieldset>
			<%
				}
			%>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">保存</button>
				</div>
			</div>
		</div>



<script>


	var form,layer,laydate;
	function getNowFormatDate() {
			var date = new Date();
			var seperator1 = "-";
			var seperator2 = ":";
			var month = date.getMonth() + 1;
			var strDate = date.getDate();
			if (month >= 1 && month <= 9) {
				month = "0" + month;
			}
			if (strDate >= 0 && strDate <= 9) {
				strDate = "0" + strDate;
			}
			var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
					+ " " + date.getHours() + seperator2 + date.getMinutes()
					+ seperator2 + date.getSeconds();
			return currentdate;
	}
	var today = getNowFormatDate();


	$(document).ready(function () {


			/*给表单注册登录事件*/
			layui.use(["form","layer",'laydate'],function(){
				form = layui.form;
				layer = layui.layer;
				laydate = layui.laydate;


				laydate.render({
					elem:"#gradutime",
					type:"date",
					trigger:'click'
				});
				laydate.render({
					elem:"#birthday",
					type:"date",
					max:today,
					trigger:'click'

				});
				laydate.render({
					elem:"#starttime",
					type:"date",
					max:today,
					trigger:'click'
				});
				laydate.render({
					elem:"#endtime",
					type:"date",
					max:today,
					trigger:'click'
				});


                laydate.render({
                    elem:"#tstarttime",
                    type:"date",
                    max:today,
                    trigger:'click'
                });


                laydate.render({
                    elem:"#tendtime",
                    type:"date",
                    max:today,
                    trigger:'click'
                });


				form.on("submit(formDemo)",function(data){
					var da = JSON.stringify(data.field);
					$.ajax({
						url:"/HKR/teacher/addStaff",
						type:"post",
						contentType:"application/json",
						async:false,
						data:da,
						success:function (res) {
							console.log(res);
							if(res.success){
								layer.msg("提交成功!")
								var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
								parent.location.reload();
							}else{
								layer.alert(res.msg,{icon:5,title:"错误"});
								return false;
							}
						},
						error:function () {
							layer.alert("提交失败！")
						}
					});
					return false;
				});

				form.render();

			});
	})


</script>


	</body>
</html>
