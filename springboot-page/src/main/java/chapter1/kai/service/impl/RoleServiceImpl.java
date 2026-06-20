package chapter1.kai.service.impl;

import chapter1.kai.dao.RoleDao;
import chapter1.kai.entity.Role;
import chapter1.kai.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Map rolePage(Integer currentPage, Integer pageSize) {
//        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(Role::getRoleName, "人员");
        Page<Role> rolePage = roleDao.selectPage(new Page<>(currentPage, pageSize), null);
        List<Role> records = rolePage.getRecords();     // 分页的数据集合
        long total = rolePage.getTotal();               // 分页的总数据量
        Map map = new HashMap();
        map.put("records", records);
        map.put("total", total);
        return map;
    }
}
