package cn.com.hkr.service;

import cn.com.hkr.bean.Menu;
import cn.com.hkr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    //设置菜单缓存区（除非做增、删、改在更新这里的缓存:获取键是allMenu）
    private static Map<String, List<Menu>> menuCache = new HashMap<String, List<Menu>>();

    /*添加一个任务菜单*/
    @Transactional
    public void addMenu(Menu menu){
        menuMapper.addMenu(menu);
    }


    /*通用查询*/
    public List<Menu>  commonSelect(Menu menu){
        if (null != menuCache && null ==  menu && !menuCache.isEmpty()){
            System.out.println("菜单缓存--------------" + menuCache);
            return menuCache.get("menuList");
        }else{
            // 若缓存数据没有，则更新缓存
            return menuMapper.commonSelect(menu);
        }
    }


    /*
    * 得到所有一级，并且已经封装好的二级菜单
    * 并且更新菜单缓存
    * */
    public List<Menu> getSealMenus(){
        //获取所有一级菜单
        List<Menu> parents = findOriginMenus(null);
        for(Menu parent :parents){
            //获取当前父类菜单下的子类菜单
            List<Menu> childs = findOriginMenus(parent.getId());
            //将子类菜单封装到父类里
            parent.setChilds(childs);
        }

        return parents;

    }


    /*
    * 更新菜单缓存
    * */
    private void updateMenuCache(){
        List<Menu> sealMenus = getSealMenus();
        menuCache.clear();
        menuCache.put("menuList",sealMenus);
        System.out.println("菜单缓存更新完成！");

    }



    /*
    * 通过pid查询所有菜单。
    * 若pid为null或者pid是空的，则是查询所一级菜单
    * 若pid不为空，则就是查询当前一级菜单下的二级菜单。
    *
    * */
    private List<Menu> findOriginMenus(String pid){
        Menu menu;
        if(null == pid  ||  pid.trim().length() == 0){
            List<Menu> parents = menuMapper.getParentMenu();
            return parents;
        }else{
            menu = new Menu();
            menu.setPid(pid);
            List<Menu> childs = menuMapper.commonSelect(menu);
            return childs;
        }
    }
}
