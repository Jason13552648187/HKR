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
		<title>编辑信息</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/layui/css/layui.css">
		<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/js/jquery-1.7.2.min.js"></script>



	</head>
	<body>
		<!--表单开始-->
		<div id="layform" class="layui-form  layui-form-pane"style="width: auto;" lay-filter="layform">
			<fieldset class="layui-elem-field layui-field-title" style="margin:30px 0;">
				<legend >员工基本信息</legend>
			<div class="layui-form-item" style="margin:20px 0;">
				<div class="layui-inline">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-inline">
						<input class="layui-input" onclick="layer.alert('姓名不支持修改！')" disabled="disabled" readonly="readonly" name="username" id="username" lay-verify="required" type="text" autocomplete="off"/>
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-inline">
						<select name="sex" lay-filter="" id="sex">
							<option value="女">女</option>
							<option value="男">男</option>
						</select>
					</div>
				</div>


				<div class="layui-inline">
					<label class="layui-form-label">年龄</label>
					<div class="layui-input-inline">
						<input class="layui-input" name="age" id="age" lay-verify="required" type="text" autocomplete="off" />
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-inline">
						<input class="layui-input" onclick="layer.alert('身份证号不支持修改！')" disabled="disabled" readonly="readonly" name="idcard" id="idcard" lay-verify="required" type="text" autocomplete="off" placeholder="" />
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
				    <label class="layui-form-label">名族</label>
				    <div class="layui-input-inline">
				      <select name="nationa"  lay-filter="nationa" lay-verify="required" id="nationa">
						<option value=""></option>
						<option value="汉族">汉族</option>
						<option value="壮族">壮族</option>
						<option value="满族">满族</option>
						<option value="回族">回族</option>
						<option value="苗族">苗族</option>
						<option value="维吾尔族">维吾尔族</option>
						<option value="土家族">土家族    </option>
						<option value="彝族">彝族      </option>
						<option value="蒙古族">蒙古族    </option>
						<option value="藏族">藏族      </option>
						<option value="布依族">布依族    </option>
						<option value="侗族">侗族      </option>
						<option value="瑶族">瑶族      </option>
						<option value="朝鲜族">朝鲜族    </option>
						<option value="白族">白族      </option>
						<option value="哈尼族">哈尼族    </option>
						<option value="哈萨克族">哈萨克族  </option>
						<option value="黎族">黎族      </option>
						<option value="傣族">傣族      </option>
						<option value="畲族">畲族      </option>
						<option value="傈僳族">傈僳族    </option>
						<option value="仡佬族">仡佬族    </option>
						<option value="东乡族">东乡族    </option>
						<option value="高山族">高山族    </option>
						<option value="拉祜族">拉祜族    </option>
						<option value="水族">水族      </option>
						<option value="佤族">佤族      </option>
						<option value="纳西族">纳西族    </option>
						<option value="羌族">羌族      </option>
						<option value="土族">土族      </option>
				      </select>
				    </div>
				</div>
				
				    <div class="layui-inline">
				      <label class="layui-form-label">出生年月</label>
						<div class="layui-input-inline">
							<input readonly="readonly" name="birthday" id="birthday" title="出生日期" class="layui-input lydate"/>
						</div>
				    </div>

				<div class="layui-inline">
					<label class="layui-form-label">联系电话</label>
					<div class="layui-input-inline">
						<input class="layui-input" name="phoneNumber" id="phoneNumber" lay-verify="required" type="text" autocomplete="off"  />
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-inline">
						<input class="layui-input" name="email" id="email" lay-verify="required" type="text" autocomplete="off"  />
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">微信号</label>
					<div class="layui-input-inline">
						<input class="layui-input" name="wechat" id="wechat" type="text" autocomplete="off"  />
					</div>
				</div>
			</div>
			<!--基本信息结束-->
			</fieldset>



            <!--教育信息-->
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  			<legend>教育信息</legend>
			 <div class="layui-form-item" style="margin:20px 0;">
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
					<div class="layui-input-inline" style="width: auto;">
						<input type="text" readonly="readonly"  id="gradutime" id="gradutime" name="gradutime" class="layui-input lydate" lay-verify="required"/>
					</div>

				</div>
				
				
				
				
				<div class="layui-inline">
				 	<label class="layui-form-label">学历水平</label>
				 	<div class="layui-input-inline">
				 		<select name="edulevel" id="edulevel" lay-filter="edulevel" lay-verify="required">
					        <option value=""></option>
					        <option value="专科">专科</option>
					        <option value="本科">本科</option>
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
				 	<label class="layui-form-label" style="width:150px;">证明人联系方式</label>
				 	<div class="layui-input-inline"  >
				 		<input type="text" name="edutelnumber" id="edutelnumber" class="layui-input"  />
				 	</div>
				</div>
				 	
				 	
			 </div>
			</fieldset>



            <!--历史工作信息-->
			<!--公司名称、职位、工作起始日期、工作结束日期、工作任务简述-->
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  			<legend>工作信息</legend>
			<div class="layui-form-item" style="margin:20px 0;">
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
						<label class="layui-form-label">工作起始日期</label>
						<div class="layui-input-inline">
							<input  type="text" readonly="readonly" class="layui-input lydate" name="starttime"  id="starttime" />
						</div>
					</div>
					
					
					<div class="layui-inline">
						<label class="layui-form-label">工作结束日期</label>
						<div class="layui-input-inline">
							<input  type="text" readonly="readonly"  class="layui-input" name="endtime"  id="endtime" />
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




			<!--父母联系方式-->
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  			    <legend>父母联系方式</legend>
                <div class="layui-form-item" style="margin:20px 0;">
                    <div class="layui-inline">
                        <label class="layui-form-label">联系人</label>
                        <div class="layui-input-block">
                            <input name="contact"  class="layui-input" lay-verify="required" id="contact"/>
                        </div>
                    </div>



                    <div class="layui-inline">
                        <label class="layui-form-label">与本人关系</label>
                        <div class="layui-input-block">
                            <select name="relation" lay-filter="relation" lay-verify="required" id="relation">
                                <option value=""></option>
                                <option value="母亲">母亲</option>
                                <option value="父亲">父亲</option>
                            </select>
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">工作单位</label>
                        <div class="layui-input-block">
                            <input name="unit"  class="layui-input" id="unit"/>
                        </div>
                    </div>


                    <div class="layui-inline">
                        <label class="layui-form-label">职务</label>
                        <div class="layui-input-block">
                            <input name="workjob"  class="layui-input" id="workjob"/>
                        </div>
                    </div>


                    <div class="layui-inline">
                        <label class="layui-form-label">联系电话</label>
                        <div class="layui-input-block">
                            <input name="telphone"  class="layui-input" lay-verify="required" id="telphone"/>
                        </div>
                    </div>

                </div>

				<%--财务状况：仅限行政人员可修改和添加--%>
				<%
					if(request.getSession().getAttribute("triod").toString().equals("2")){
				%>
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
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


				<div class="layui-form-item" align="center">
                    <div class="layui-input-block">
                      <button class="layui-btn" lay-submit lay-filter="formDemo">保存</button>
    <%--			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
                    </div>
                </div>
			</fieldset>
		</div>
<script>

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/edit.js"></script>
		
		
		
	</body>
</html>
