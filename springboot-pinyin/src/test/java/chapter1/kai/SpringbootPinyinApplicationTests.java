package chapter1.kai;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootPinyinApplicationTests {

    public String convert(String str) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer py = new StringBuffer();
        // 拼音格式对象
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        // 不要声调
        // format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // 后置声调（在每个拼音后显示声调）
        // format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
        // 定置声调
        format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);   // 定制声调需要修改v为ü
        // 拼音大写
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        // 转换
        String[] array = PinyinHelper.toHanyuPinyinStringArray(str.toCharArray()[0], format);
        py.append(array[0]);
        return py.toString();
    }

    @Test
    public void test() throws BadHanyuPinyinOutputFormatCombination {
        String words = "這是一個測試";
        String regex = "^[\\u4e00-\\u9fff]+$";
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < words.length(); i++) {
            String word = words.substring(i, i + 1);
            if (word.matches(regex)) {
                // 得到它的拼音
                word = convert(word);
            }
            buffer.append(word);
        }
        System.out.println(buffer);
    }

}
