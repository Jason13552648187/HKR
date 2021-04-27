package cn.com.hkr.service;

import cn.com.hkr.bean.Menu;
import cn.com.hkr.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class MenuService {

    //设置菜单缓存区（除非做增、删、改在更新这里的缓存:获取键是allMenu）
    private static Map<String,Object> menuCache = new HashMap<String,Object>();

    @Autowired
    public MenuDao menuDao;

    public List<Menu> getAllMenu(){

        if (null != menuCache.get("allMenu")){
            return (List<Menu>) menuCache.get("allMenu");
        }

        List<Menu> allMenu = menuDao.getParentMenu();
        for (Menu parent : allMenu){
            List<Menu> childlist = getChildrenById(parent.getId());
            parent.setChilds(childlist);
            //给所有子类对象赋值父对象
            setParent(parent,childlist);
        }

        menuCache.put("allMenu",allMenu);
        return allMenu;
    }

    /**
     * 设置父对象
     * @param parent
     * @param childlist
     */
    private void setParent(Menu parent,List<Menu> childlist){
        for(Menu child : childlist){
            child.setParent(parent);
        }
    }


    public Menu getMenuById(String id){
        return menuDao.getMenuById(id);
    }

    /**
     * 通过父id查找所有子id
     * @param id
     * @return
     */
    public List<Menu> getChildrenById(String id){
        return menuDao.getChilrenById(id);
    }

}
