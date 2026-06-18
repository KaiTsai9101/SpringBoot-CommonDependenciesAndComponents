package chapter1.kai.service.impl;

import chapter1.kai.properties.IpCounterProperties;
import chapter1.kai.service.IpCounterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IpCounterServiceImpl implements IpCounterService {
    @Autowired
    private HttpServletRequest request;

    private Map<String, Integer> map = new HashMap<>();

    @Autowired
    private IpCounterProperties properties;

    @Override
    public void record() {
        // ip
        String ip = request.getRemoteAddr();
        // 访问次数
        Integer i = map.get(ip);
        i = Objects.isNull(i) ? 1 : ++i;
        // 更新
        map.put(ip, i);
        // 输出
        map.forEach((key, value) -> {
            if (properties.getDisplay().equals(IpCounterProperties.DisplayMode.DETAIL.getValue())) {
                System.out.println("\t\t\tip访问监控");
                System.out.println("+-----------ip-----------+----count----+");
                System.out.println("|\t\t" + key + "\t\t\t" + value);
                System.out.println("+------------------------+-------------+");
            } else {
                System.out.println("ip: " + key + "\tcount: " + value);
            }
//            System.out.println("ip: " + key + "\tcount: " + value);
        });
    }
}
