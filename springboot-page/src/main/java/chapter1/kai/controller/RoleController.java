package chapter1.kai.controller;

import chapter1.kai.mode.ResponseModel;
import chapter1.kai.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/roleList")
    public ResponseModel roleList(Integer currentPage, Integer pageSize) {
        Map map = roleService.rolePage(currentPage, pageSize);
        long total = (long) map.get("total");
        return total > 0 ? ResponseModel.success(map) : ResponseModel.failure(map);
    }
}
