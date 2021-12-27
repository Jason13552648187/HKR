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
    <title>员工详情信息</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/layui/css/layui.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/list.js"></script>
</head>
<body>
<!--表单开始-->
<div id="layform" class="layui-form  layui-form-pane"style="width: auto;" lay-filter="layform">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>员工基本信息</legend>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="username" readonly="true" style="background:#ffffff;" disabled="disabled" id="username" lay-verify="required" type="text" autocomplete="off"/>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline">
                    <input name="sex"  class="layui-input" lay-filter="relation"  id="sex"  readonly="true" style="background:#ffffff;" disabled="disabled"/>

                </div>
            </div>


            <div class="layui-inline">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="age" id="age" readonly="true" style="background:#ffffff;" disabled="disabled" lay-verify="required" type="text" autocomplete="off" />
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">身份证号</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="idcard" readonly="true" style="background:#ffffff;" disabled="disabled" id="idcard" lay-verify="required" type="text" autocomplete="off" placeholder="" />
                </div>
            </div>



            <!--下拉选项-->

            <div class="layui-inline">
                <label class="layui-form-label">籍贯</label>
                <div  class="layui-input-inline">
                    <input class="layui-input" name="rawaddress" id="rawaddress" readonly="true" style="background:#ffffff;" disabled="disabled" lay-verify="required" type="text" autocomplete="off" placeholder="居住地址" />

                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">名族</label>
                <div class="layui-input-inline">
                    <input name="nationa"  class="layui-input" lay-filter="relation"  id="nationa"  readonly="true" style="background:#ffffff;" disabled="disabled"/>


                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">出生年月</label>
                <div class="layui-input-inline">
                    <input type="text" name="birthday" id="birthday"  readonly="true" style="background:#ffffff;" disabled="disabled" title="出生日期" class="layui-input lydate"/>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="phoneNumber" id="phoneNumber"  readonly="true" style="background:#ffffff;" disabled="disabled" lay-verify="required" type="text" autocomplete="off"  />
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="email" id="email"  readonly="true" style="background:#ffffff;" disabled="disabled" lay-verify="required" type="text" autocomplete="off"  />
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">微信号</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="wechat" id="wechat"  readonly="true" style="background:#ffffff;" disabled="disabled" type="text" autocomplete="off"  />
                </div>
            </div>
        </div>
        <!--基本信息结束-->

    </fieldset>
    <!--教育信息-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>教育信息</legend>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">毕业院校</label>
                <div class="layui-input-inline">
                    <input type="text" name="school" id="school"  readonly="true" style="background:#ffffff;" disabled="disabled" title="毕业院校" class="layui-input" lay-verify="required"/>
                </div>
            </div>


            <div class="layui-inline">
                <label class="layui-form-label">专业</label>
                <div class="layui-input-inline">
                    <input type="text" name="professional" id="professional"  readonly="true" style="background:#ffffff;" disabled="disabled" title="所学专业" class="layui-input" lay-verify="required"/>
                </div>
            </div>



            <div class="layui-inline">
                <label class="layui-form-label">毕业时间</label>
                <div class="layui-input-inline" style="width: auto;">
                    <input type="text" id="gradutime" id="gradutime"  readonly="true" style="background:#ffffff;" disabled="disabled" name="gradutime" class="layui-input lydate" lay-verify="required"/>
                </div>

            </div>


            <div class="layui-inline">
                <label class="layui-form-label">学历水平</label>
                <div class="layui-input-inline">
                    <input name="edulevel"  class="layui-input" lay-filter="relation"  id="edulevel"  readonly="true" style="background:#ffffff;" disabled="disabled"/>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">毕业证明人</label>
                <div class="layui-input-inline">
                    <input type="text" name="educonfirm" id="educonfirm" readonly="true" style="background:#ffffff;" disabled="disabled" class="layui-input"  />
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label" style="width:150px;">证明人联系方式</label>
                <div class="layui-input-inline"  >
                    <input type="text" name="edutelnumber" id="edutelnumber"  readonly="true" style="background:#ffffff;" disabled="disabled" class="layui-input"  />
                </div>
            </div>


        </div>
    </fieldset>
    <!--历史工作信息-->
    <!--公司名称、职位、工作起始日期、工作结束日期、工作任务简述-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>工作信息</legend>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">公司名称</label>
                <div class="layui-input-inline">
                    <input  type="text" class="layui-input" name="company" id="company"  readonly="true" style="background:#ffffff;" disabled="disabled" />

                </div>
            </div>



            <div class="layui-inline">
                <label class="layui-form-label">所在职位</label>
                <div class="layui-input-inline">
                    <input  type="text" class="layui-input" name="job"  id="job" readonly="true" style="background:#ffffff;" disabled="disabled" />
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">工作起始日期</label>
                <div class="layui-input-inline">
                    <input  type="text" class="layui-input lydate" name="starttime"  readonly="true" style="background:#ffffff;" disabled="disabled" id="starttime" />
                </div>
            </div>


            <div class="layui-inline">
                <label class="layui-form-label">工作结束日期</label>
                <div class="layui-input-inline">
                    <input  type="text" class="layui-input lydate" name="endtime"  id="endtime"  readonly="true" style="background:#ffffff;" disabled="disabled" />
                </div>
            </div>


        </div>
        <div class="layui-form-item layui-form-text" style="width:90%">
            <label class="layui-form-label">工作任务简述</label>
            <div class="layui-input-block">
                <textarea name="workdetail" id="workdetail" class="layui-textarea"  readonly="true" style="background:#ffffff;" disabled="disabled"></textarea>
            </div>
        </div>
    </fieldset>
    <!--父母联系方式-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>父母联系方式</legend>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">联系人</label>
                <div class="layui-input-block">
                    <input name="contact"  class="layui-input" lay-verify="required" id="contact"  readonly="true" style="background:#ffffff;" disabled="disabled"/>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">与本人关系</label>
                <div class="layui-input-block">

                    <input name="relation"  class="layui-input" lay-filter="relation"  id="relation"  readonly="true" style="background:#ffffff;" disabled="disabled"/>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">工作单位</label>
                <div class="layui-input-block">
                    <input name="unit"  class="layui-input" id="unit"  readonly="true" style="background:#ffffff;" disabled="disabled"/>
                </div>
            </div>


            <div class="layui-inline">
                <label class="layui-form-label">职务</label>
                <div class="layui-input-block">
                    <input name="workjob"  class="layui-input" id="workjob" readonly="true" style="background:#ffffff;" disabled="disabled"/>
                </div>
            </div>


            <div class="layui-inline">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-block">
                    <input name="telphone"  class="layui-input" id="telphone" readonly="true" style="background:#ffffff;" disabled="disabled"/>
                </div>
            </div>

        </div>

    </fieldset>

    <%
        String rid = request.getSession().getAttribute("triod").toString();
        if (rid.equals("2") || rid.equals("0")){
    %>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>财务基本情况</legend>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" >财务状态</label>
                <div class="layui-input-block">
                    <input name="compactname"  class="layui-input" lay-verify="required" id="compactname"  readonly="true" style="background:#ffffff;" disabled="disabled"/>
                </div>
            </div>
        </div>
    </fieldset>

    <%
        }
    %>


</div>



<script>


    //获取当前时间格式
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
    var form,layer,laydate;
    /*给表单注册登录事件*/
    layui.use(["form","layer",'laydate'],function(){
        form = layui.form;
        layer = layui.layer;
        laydate = layui.laydate;


        laydate.render({
            elem:"#gradutime",
            type:"date"

        });
        laydate.render({
            elem:"#birthday",
            type:"date",
            max:getNowFormatDate()
        });
        laydate.render({
            elem:"#starttime",
            type:"date",
            max:getNowFormatDate()
        });
        laydate.render({
            elem:"#endtime",
            type:"date",
            max:getNowFormatDate()
        });





    });




</script>





</body>
</html>
