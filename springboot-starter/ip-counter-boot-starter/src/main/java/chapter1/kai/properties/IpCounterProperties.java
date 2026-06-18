package chapter1.kai.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("tools.ip")
@Component
public class IpCounterProperties {
    private String display = DisplayMode.SIMPLE.value;

    public enum DisplayMode {
        SIMPLE("simple"),
        DETAIL("detail");

        private final String value;

        public String getValue() {
            return value;
        }

//        public void setValue(String value) {
//            this.value = value;
//        }

        DisplayMode(String value) {
            this.value = value;
        }
    }
}
