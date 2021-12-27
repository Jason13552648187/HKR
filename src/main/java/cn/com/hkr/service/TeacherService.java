package cn.com.hkr.service;

import cn.com.hkr.bean.*;
import cn.com.hkr.exception.ParamException;
import cn.com.hkr.exception.SelectException;
import cn.com.hkr.exception.UpdateException;
import cn.com.hkr.mapper.*;

import cn.com.hkr.utils.SendEmailUtils;
import cn.com.hkr.utils.StaticUtils;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jason
 * @date 2020/10/23-15:59
 */
@Service
public class TeacherService extends BaseService{
    /*用户相关的缓存map数据库*/
//    private static String verify_mail = "你好，这是您的验证码:<b>{0}</b>！有效时间五分钟！打死都不要告诉别人！";
//    private static String register_mail = new String("你好，您已成功注册账号，请点击连接完成激活:<a href='%s'>点击这里</a>");

    private static String verify_mail;
    private static String register_mail;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private WorkHistoryMapper workHistoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private StaffInfoMapper staffInfoMapper;


    @Autowired
    private SendEmailUtils sendEmailUtils;

    @Autowired
    private CompactMapper compactMapper;

    @Autowired
    private  SectionMapper sectionMapper;

    static{

        //用于初始化读取邮件发送的模板数据
        InputStream input = UserService.class.getClassLoader().getResourceAsStream("mail.properties");

        Properties properties = new Properties();
        if (null != input){
            try {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(properties.get("verify_mail"));
        verify_mail = (String )properties.get("verify_mail");
        register_mail = (String) properties.get("register_mail");
    }


    public List<Teacher> findAll() {
        return teacherMapper.selectCommon(null);
    }

    public Teacher getUserByPhoneNumber(String phoneNumber) {
        return teacherMapper.getUserByPhone(phoneNumber);
    }

    public Teacher getUserByNameAndPassword(String username, String password) {
        return teacherMapper.getUserByNameAndPassword(username, password);
    }

    /**
     * 用户注册业务
     * @param user
     * @param contentPath
     * @return
     */
    /*@Transactional
    public Map register(Teacher teacher, String contentPath) {
        String mail =  teacher.getEmail();
        try {
            if (null == teacher) {
                msg.put("msg", "信息不能为空!");
                msg.put("success", false);
                return msg;
            }else if (emailIsExist(mail)) {
                msg.put("msg", "该邮箱已被注册!");
                msg.put("success", false);
                return msg;
            } else if (phoneIsExists(teacher.getPhoneNumber())) {
                msg.put("msg", "该手机号已被注册!");
                msg.put("success", false);
                return msg;
            }

            *//*正常注册逻辑*//*
            teacher.setUid(StaticUtils.getUUID());
            teacher.setGraduation(2);
            teacher.setStatus(0);
            teacher.setRegisterDate(new Date());

            //先发送一封激活邮件，先向数据库里插入数据
            try {
                String active_code = StaticUtils.getMD5String(user.getUserInfo().getEmail() + user.getPassword() + user.getUserInfo().getPhoneNumber());
                String subject = "账号激活连接!";
                String active_link = contentPath + "/user/active?acid=" + active_code;
                String email_content = String.format(register_mail, active_link);
                sendEmailUtils.sendMail(user.getUserInfo().getEmail(),
                        subject,
                        email_content ,
                        new String[]{"C:\\Users\\jason\\Pictures\\picture.jpg"}
                );

                //将激活码存一份到数据库
                teacherMapper.insertVerify(StaticUtils.getUUID(),user.getUid(),active_code);
            }catch (Exception e){
                *//*如果发送邮件数据失败则会返回错误提示，不在添加数据库*//*
                msg.put("msg","邮件发送失败!请稍后重试!");
                msg.put("success",false);
                e.printStackTrace();
                return msg;
            }
            *//*正常添加用户数据*//*
            teacherMapper.addTeacher(teacher);
            msg.put("msg", "添加成功!");
            msg.put("success", true);
        } catch (Exception e) {
            msg.put("msg", "注册失败!请稍后重试!");
            msg.put("success", false);
            e.printStackTrace();
            return msg;
        }
        return msg;
    }*/

    /**
     * 系统核心登陆业务
     * @param teacher
     * @return
     */
    public Map login(Teacher teacher) {
        try {
            if (null == teacher) {
                msg.put("msg", "信息不能为空!");
                msg.put("success", false);
                return msg;
            }

            /*检测密码是否正确*/
            List<Teacher> list = teacherMapper.selectCommon(teacher);
            if (null != list && list.size() != 0){
                Teacher u = list.get(0);
                if (u.getStatus() == UserStatus.USER_STATUS_UNACTIVTE){
                    msg.put("msg", "对不起，您还未激活!请到您的邮箱里完成激活配置!");
                    msg.put("success", false);
                    msg.put("code",781);
                    return msg;
                }
                msg.put("data",list.get(0));
                msg.put("success",true);
                return msg;
            }
            msg.put("code",779);
            msg.put("msg","邮箱或密码错误!");
            msg.put("success",false);
            return msg;

        } catch (Exception e) {
            msg.put("code",778);
            msg.put("msg","登陆发生未知错误!");
            msg.put("success",false);
            return msg;
        }
    }

    /*
     *发送校验的Email邮件（具体的什么业务逻辑要发的验证码）
     * 并存入数据库中进行校验
     * */
    @Transactional
    public String sendVerifyEmail(String email) throws Exception {

        String verifyCode = StaticUtils.getVerifyCode(6);

        sendEmailUtils.sendMail(email,
                "这是一封激活邮件!",
                MessageFormat.format(verify_mail,verifyCode),
                null);
        return verifyCode;
    }


    /*
     * 修改密码
     * */

    @Transactional
    public Boolean modifyPassword(String email,String newPassword){
        try {
            teacherMapper.modifyPass(email,newPassword);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



    /*查询邮箱是否存储在*/
    private  Boolean emailIsExist(String email){
        Teacher u = new Teacher();
        u.setEmail(email);
        System.out.println(email);
        List<Teacher> list = teacherMapper.selectCommon(u);
        if (null != list && list.size() != 0) return true;
        return false;
    }

    /*查询手机号是否存在*/
    private Boolean phoneIsExists(String phone){
        Teacher u = new Teacher();
        u.setPhoneNumber(phone);

        List<Teacher> list = teacherMapper.selectCommon(u);

        if (null != list  && list.size() != 0) return true;
        return false;
    }


    /*
     * 统一的查询方法
     * */
    public List<Teacher> commonSelect(Teacher teacher){
        return teacherMapper.selectCommon(teacher);
    }

    /**
     *
     * 带有权限的查询数据
     * @param
     * @return
     */
    public List<Map> commonSelectUserMap(Map map,Teacher teacher){

        if (null == teacher || null == map) return null;

        //第一步做权限校验，查看是什么级别的
        List<Teacher> teachers = teacherMapper.selectCommon(teacher);
        if (null == teachers){
            return null;
        }
        List<Map> data = userMapper.unionSelectCommonMap(map);
        Integer role_id = teachers.get(0).getRole_id();
        //若是行政或者根用户，可见财务状况
        if (role_id == TeacherStatus.PA || role_id == TeacherStatus.SYSTEMROLE){
            List<Map> commonselect = compactMapper.commonselect(map);

            for(Map m : data){
                for (Map m1 : commonselect){
                    if (m.get("uid").equals(m1.get("uid"))){
                        m.putAll(m1);
                    }
                }
            }
            return data;
        }else{  //否则就是普通查询
            return data;
        }

    }




    /*
     * 用户激活
     * */
    @Transactional
    public Map active(String acid){
        Map map = teacherMapper.commonSelectVerify(acid);

        //激活连接无效
        if (null == map  || map.size() == 0){
            msg.put("success",false);
            msg.put("msg","激活连接无效!");
            msg.put("code",925);
            return msg;
        }

        //重复激活
        if ((Integer) map.get("status") == 1){
            msg.put("success",false);
            msg.put("msg","该用户已经激活!请勿重新激活!");
            msg.put("code",924);
            return msg;
        }


        //激活连接已经失效
        if ((Integer) map.get("isVariable") == 1){
            msg.put("success",false);
            msg.put("msg","激活连接已经失效!");
            msg.put("code",925);
            return msg;
        }else{
            //正常激活
            teacherMapper.updateUserStatus((String)map.get("uid"),1);
            msg.put("success",true);
            msg.put("msg","激活成功!");
            msg.put("code",925);
            return msg;
        }

    }

    /**
     * 添加员工信息
     * @param map
     * @return
     */
    @Transactional
    public Map addStaff(HashMap map) {
        String  mapString = JSON.toJSONString(map);

        //数据提取
        User user = JSON.parseObject(mapString, User.class);

        UserEducation userEducation = JSON.parseObject(mapString, UserEducation.class);
        UserInfo userInfo = JSON.parseObject(mapString, UserInfo.class);

        System.out.println("-------------------" + userInfo);
        //判断之前是否已经添加过(电话号码和身份证)
        UserInfo userInfo1;
        userInfo1 = new UserInfo();
        userInfo1.setIdcard(userInfo.getIdcard());
        List<Map> list = staffInfoMapper.selectCommon(userInfo1);
        userInfo1 = new UserInfo();
        userInfo1.setEmail(userInfo.getEmail());
        List<Map> list1 =  staffInfoMapper.selectCommon(userInfo1);
        userInfo1 = new UserInfo();
        userInfo1.setPhoneNumber(userInfo.getPhoneNumber());
        List<Map> list2 =  staffInfoMapper.selectCommon(userInfo1);
        if(null != list && list.size() > 0){
            msg.put("code","784");
            msg.put("msg","用户身份证信息已存在！");
            msg.put("data",null);
            msg.put("success",false);
            return msg;
        }else if(null !=  list1 && null != list2 && (list1.size() > 0 || list2.size() > 0)){
            msg.put("code","786");
            msg.put("msg","邮箱或者电话号码已存在！");
            msg.put("data",list1);
            msg.put("success",false);

            return msg;
        }

        UserWorkHistory userWorkHistory = JSON.parseObject(mapString, UserWorkHistory.class);
        UserContact userContact = JSON.parseObject(mapString, UserContact.class);
        //填充数据
        String uid  = StaticUtils.getUUID();
        user.setUid(uid);
        user.setGraduation(UserStatus.USER_ACTIVE);
        user.setRegisterDate(new Date());
        user.setStatus(1);




        userEducation.setUid(uid);
        userInfo.setUid(uid);
        userWorkHistory.setUid(uid);

        userContact.setUid(uid);
        userContact.setCid(StaticUtils.getUUID());


        //查询第一次添加的财务状态
        HashMap statusMap =  new HashMap();
        String ctname = (String) map.get("compactname");
        //如果前端添加用户的时候有财务状态，就直接添加。
        if (null != map.get("compactname") && (ctname.equals(CompactStatus.COMPACT_SPLIT)
                || ctname.equals(CompactStatus.COMPACT_BETRAY)|| ctname.equals(CompactStatus.COMPACT_BETRAY)
                || ctname.equals(CompactStatus.COMPACT_UNFINISH))){
            statusMap.put("compactname",ctname);

        }else {  //如果添加员工信息的时候，没有选择财务状态，就默认为  未完成。
            statusMap.put("compactname", CompactStatus.COMPACT_UNFINISH);
        }


        Compact compact = compactMapper.selectBycompact(statusMap);
        String cid = compact.getCid();
        HashMap compactmap = new HashMap();
        compactmap.put("uid",uid);
        compactmap.put("cid",cid);


        //添加数据
        try {
            educationMapper.add(userEducation);
            workHistoryMapper.add(userWorkHistory);
            staffInfoMapper.add(userInfo);
            contactMapper.add(userContact);
            userMapper.addUser(user);
            compactMapper.addCompactStatus(compactmap);

            //单独更新结束时间和请假天数：这个问题后期要修改
            //      {"enddate":"2021-12-23","leavedays":"23","graduation":"已就业","uid":"3feb51be3eb44507b2d78f31796139e4","secname":"第一阶段"}
            Map promap = new HashMap();
            promap.put("uid",uid);
            promap.put("graduation","在籍");
            Calendar cale = Calendar.getInstance();
            cale.add(Calendar.MONTH,3);
            promap.put("enddate",new SimpleDateFormat("yyyy-MM-dd").format(cale.getTime()));
            promap.put("leavetotal",0);
            promap.put("secname","第一阶段");
            updateProcess(promap);


        } catch (Exception e) {
            msg.put("code","785");
            msg.put("msg","用户添加失败！");
            msg.put("data",e.getMessage());
            msg.put("success",false);
            return msg;
        }
        msg.put("code","788");
        msg.put("msg","用户添加成功！");
        msg.put("data",null);
        msg.put("success",true);
        return msg;

    }

    /**
     * 查询用户信息
     * @param map
     * @return
     */
    public List<Map> findDataByUser(Map map,Teacher teacher) {
        String  mapString = JSON.toJSONString(map);

        //数据提取
        User user = JSON.parseObject(mapString, User.class);

        if (null == teacher || null == map) return null;

        //第一步做权限校验，查看是什么级别的
        List<Teacher> teachers = teacherMapper.selectCommon(teacher);
        if (null == teachers){
            return null;
        }
        List<Map> data = userMapper.unionSelectCommonMap(map);
        Integer role_id = teachers.get(0).getRole_id();
        //若是行政或者根用户，可见财务状况
        if (role_id == TeacherStatus.PA || role_id == TeacherStatus.SYSTEMROLE){
            List<Map> commonselect = compactMapper.commonselect(map);

            for(Map m : data){
                for (Map m1 : commonselect){
                    if (m.get("uid").equals(m1.get("uid"))){
                        m.putAll(m1);
                    }
                }
            }
            return data;
        }else{  //否则就是普通查询
            return data;
        }


    }

    /**
     * 更新员工信息
     * @param map
     * @return
     */
    @Transactional
    public List<HashMap> updateStaff(Map map) {
        String  mapString = JSON.toJSONString(map);
        System.out.println("要更新的数据为：" + mapString);

        //数据提取
        User user = JSON.parseObject(mapString, User.class);
        UserEducation userEducation = JSON.parseObject(mapString, UserEducation.class);
        UserInfo userInfo = JSON.parseObject(mapString, UserInfo.class);


        //查看修改的内容是否有compact财务状态
        Compact compact = JSON.parseObject(mapString,Compact.class);

        System.out.println(compact);

        //判断财务状态是否合法
        //在下面判断是否要修改这个人的财务状态
        boolean flag = false;
        Map compactUserMap = new HashMap();
        if (null !=  compact){
            String compactName = compact.getCompactname();
            if (null != compactName  && (compactName.equals(CompactStatus.COMPACT_UNFINISH) ||
                compactName.equals(CompactStatus.COMPACT_BETRAY) ||
                compactName.equals(CompactStatus.COMPACT_SPLIT) ||
                compactName.equals(CompactStatus.COMPACT_FINISH))){
                flag = true;

            }/*else{//如果compactname不等于空，并且也不是财务的规定状态，那么就是非法修改
                throw new ParamException("Compact status is avalid!");
            }*/
        }


        if(null == userInfo.getIdcard() || userInfo.getIdcard().equals("")){
             throw new SelectException("身份编号异常！");
        }


        UserWorkHistory userWorkHistory = JSON.parseObject(mapString, UserWorkHistory.class);
        UserContact userContact = JSON.parseObject(mapString, UserContact.class);

        //填充数据
        System.out.println("-----------------" + userInfo);
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setIdcard(userInfo.getIdcard());
        List<Map> maps  = staffInfoMapper.selectCommon(userInfo1);
        System.out.println("-----------------" + maps);
        if (null == maps || maps.size() == 0){
            throw new SelectException("参数错误！");
        }

        //获取用户身份证编号
        String uid = (String) maps.get(0).get("uid");
        user.setUid(uid);

        userEducation.setUid(uid);
        userInfo.setUid(uid);

        userWorkHistory.setUid(uid);
        userContact.setUid(uid);


        //更新数据
        //是否要修改财务状态
        if (flag){

            compactUserMap.put("uid",uid);
            compactUserMap.put("compactname",compact.getCompactname());
            Compact compact1 = compactMapper.selectBycompact(compactUserMap);
            compactUserMap.put("cid",compact1.getCid());

        }
        try {
            userMapper.updateUser(user);
            educationMapper.updateData(userEducation);
            workHistoryMapper.updateData(userWorkHistory);
            contactMapper.updateData(userContact);
            staffInfoMapper.updateData(userInfo);

            //判断是否要修改财务状态
            if (flag){
                compactMapper.updateCompactStatus(compactUserMap);
            }

        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return null;

    }


    /**
     * 通过uid查询这个人的每个阶段详情
     * @param map  --> uid
     * @param tea   --> tid
     * @return
     */
    public Map findUserAllSec(Map map, Teacher tea){
        //提取用户uid，获取用户当前有几个阶段
        String uid = (String) map.get("uid");

        //获取用户经历了几个阶段 {sid,secname,detailname,cursection}{sid,secname,detailname,cursection}
        List<Map> sectionMap = sectionMapper.getUserAllSidByUid(uid);
        Map evalauteList = new HashMap();
        Map result = new HashMap();
        for(Map m : sectionMap){

            String sid = (String) m.get("sid");
            Map secMap = new HashMap();
            List<Map> maps = selectSectionDetailByuidAndsid(uid, sid);//[{},{}]
            List<Map> maps1 = selectSectionRebelByuidAndsid(uid, sid);//[{},{}]

            int j  = 0;
            Map rebelList = new HashMap();

            Map<String,Map> managerMap = new HashMap();
            for (Map p  :  maps){
                String manager = (String) p.get("submanager");
                int i  = 0;
                if (managerMap.containsKey(manager)){
                    managerMap.get(manager).put(StaticUtils.getUUID().substring(0,15),p.get("evaluate"));
                }else{
                    Map li = new HashMap();
                    li.put(StaticUtils.getUUID().substring(0,15),p.get("evaluate"));
                    managerMap.put(manager,li);
                }
            }

            for(Map rp : maps1){
                rebelList.put(StaticUtils.getUUID().substring(0,15),rp.get("evaluate"));
            }

            //单独目前详情
            Map curMap  = new HashMap();
            curMap.put("evaluate",managerMap);
            curMap.put("rebel",rebelList);
            curMap.put("secname",m.get("secname"));

            secMap.put("curProcess",curMap);
            secMap.put("sid",m.get("sid"));

            evalauteList.put(m.get("sid"),secMap);
        }

        //查询用户是否用权限修改学籍状态：[除了代理：3之外，项目经理:1，行政:2，根用户:0]
        Map teacher = teacherMapper.findByTid(tea);
        Integer role_id = (Integer) teacher.get("role_id");
        if (role_id == TeacherStatus.USER) //代理人员不允许做任何修改
        {
            result.put("auth",false); //不可修改数据
        }else{
            result.put("auth",true);
        }

        //查询用户的进度表
        Map processMap = new HashMap();
        processMap.put("uid",uid);
        Map userProcess = sectionMapper.getUserProcess(processMap);
        result.put("curProcess",userProcess);
        result.put("allDetail",evalauteList);

        return result;

    }

    /**
     * 通过uid得知用户项目进度
     * @return
     */
    public Map getUserProcessByUid(Map map){
        return sectionMapper.getUserProcess(map);
    }


    /**
     * 通过uid和sid查询阶段的详细情况
     * @param uid
     * @param sid
     * @return
     */
    public List<Map> selectSectionDetailByuidAndsid(String uid ,String sid){
        if (null == uid || null == sid)return null;

        List<Map> maps = sectionMapper.selectSectionDetailByuidAndsid(uid, sid);

        return maps;

    }


    /**
     * 通过uid和sid来查询用户的当前阶段的违规情况
     * @param uid  用户编号
     * @param sid  用户阶段编号
     * @return
     */
    public List<Map> selectSectionRebelByuidAndsid(String uid,String sid){
        if (null ==  uid || null == sid) return null;

        return sectionMapper.selectSectionRebelByuidAndsid(uid,sid);
    }



    /**
     * 通过uid得知用户项目进度
     * @return
     */
    public Map findUserProcessByUid(Map map){
        return sectionMapper.getUserProcess(map);
    }

    /**
     * 判断财务状态是否有效
     * @param map
     * @return
     */
    private boolean isValidCompact(Map map){
        if (null == map || map.size() == 0 ||
                null == map.get("compactname") ||
                ((String)map.get("compactname")).trim().equals("")){
            return false;
        }
        //查看修改的内容是否有compact财务状态
        Compact compact = JSON.parseObject(JSON.toJSONString(map),Compact.class);
        String compactName = compact.getCompactname();
        if (compactName.equals(CompactStatus.COMPACT_UNFINISH) ||
                compactName.equals(CompactStatus.COMPACT_BETRAY) ||
                compactName.equals(CompactStatus.COMPACT_SPLIT) ||
                compactName.equals(CompactStatus.COMPACT_FINISH)){
                return  true;

        }else{//如果compactname不等于空，并且也不是财务的规定状态，那么就是非法修改
            return false;
        }

    }

    /**
     * 查询用户的结束时间
     * @param map
     * @return
     */
    public Map findUserEndtime(Map map) {
        String  mapString = JSON.toJSONString(map);

        //数据提取
        User user = JSON.parseObject(mapString, User.class);

        if (null != user.getUid() || !user.getUid().equals("")){

            return userMapper.findUserEndtime(map);

        }else{
            throw new SelectException("查询参数异常,请稍后重试！");
        }



    }

    /**
     * 修改用户的项目进度
     * @param map
     * @return
     */
    @Transactional
    public void updateProcess(Map map) {

        //{"enddate":"2021-12-23","leavedays":"23","graduation":"已就业","uid":"3feb51be3eb44507b2d78f31796139e4","secname":"第一阶段"}
        //t_user   t_sec_detail
        if (null == map || null == map.get("uid") || null ==  map.get("secname")) throw new UpdateException("进度参数异常!");
        //进行数据参数校验
        if (!SectionStatus.SECTIONS.contains((String)map.get("secname"))){
            throw new ParamException("阶段状态非法！");
        }

        List<Section> sections = sectionMapper.commonSelectSection(map);
        if (sections != null){ //去数据库库查询“第xx阶段对应的数据编号od”
            Integer od = sections.get(0).getOd();
            map.put("status",od); //在把数据编号加到map里，status:od
        }else{
            throw new ParamException("阶段名称不合法！");
        }


        userMapper.updateUserMap(map);




    }

    /**
     * 添加当前用户的项目评价详情
     * @param map
     * @param tea
     */
    @Transactional
    public void addSecDetail(Map map, Teacher tea) {


        System.out.println("********************************" + map);
        System.out.println("********************************" + tea);

        if (null == map || null == map.get("uid") || null ==  map.get("secname")) throw new UpdateException("添加项目记录异常!");
        //进行数据参数校验
        if (!SectionStatus.SECTIONS.contains((String)map.get("secname"))){
            throw new ParamException("阶段状态非法！");
        }

        List<Section> sections = sectionMapper.commonSelectSection(map);
        if (sections != null){ //去数据库库查询“第xx阶段对应的数据编号od”
            String sid = sections.get(0).getSid();
            map.put("sid",sid); //在把数据编号加到map里，status:od
        }else{
            throw new ParamException("阶段名称不合法！");
        }

        String teacherName = (String) teacherMapper.findByTid(tea).get("teacherName");
        map.put("submanager",teacherName);
        map.put("did",StaticUtils.getUUID());
        map.put("leavedays",0);

        Map map1 = sectionMapper.commonSelectUserSection(map);
        if (null == map1 || map1.size() == 0){
            sectionMapper.addUserSection(map);
        }
        sectionMapper.addSectionDetail(map);


    }



    /**
     * 添加当前用户的项目评价详情
     * @param map
     * @param tea
     */
    @Transactional
    public void addSectionRebel(Map map, Teacher tea) {


        System.out.println("********************************" + map);
        System.out.println("********************************" + tea);

        if (null == map || null == map.get("uid") || null ==  map.get("secname")) throw new UpdateException("添加项目违规异常!");
        //进行数据参数校验
        if (!SectionStatus.SECTIONS.contains((String)map.get("secname"))){
            throw new ParamException("阶段状态非法！");
        }

        List<Section> sections = sectionMapper.commonSelectSection(map);
        if (sections != null){ //去数据库库查询“第xx阶段对应的数据编号od”
            String sid = sections.get(0).getSid();
            map.put("sid",sid); //在把数据编号加到map里，status:od
        }else{
            throw new ParamException("阶段名称不合法！");
        }

        String teacherName = (String) teacherMapper.findByTid(tea).get("teacherName");

        map.put("rid",StaticUtils.getUUID());
        Map map1 = sectionMapper.commonSelectUserSection(map);
        if (null == map1 || map1.size() == 0){
            sectionMapper.addUserSection(map);
        }
        sectionMapper.addSectionRebel(map);


    }
}
