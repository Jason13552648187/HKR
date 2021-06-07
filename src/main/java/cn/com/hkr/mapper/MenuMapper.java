package cn.com.hkr.mapper;

import cn.com.hkr.bean.Menu;
import javafx.scene.input.Mnemonic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jason
 * @date 2021/5/11-12:01
 */
@Mapper
public interface MenuMapper {

    public List<Menu> getAllMenu();

    public List<Menu> getMenuById(String id);

    public List<Menu> getParentMenu();

    public List<Menu> getChilrenById(String id);

    public List<Menu> commonSelect(Menu menu);

    public void addMenu(Menu menu);
}
