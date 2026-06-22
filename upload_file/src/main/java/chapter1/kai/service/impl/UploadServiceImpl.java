package chapter1.kai.service.impl;

import chapter1.kai.model.ResponseModel;
import chapter1.kai.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public ResponseModel upload(MultipartFile file) throws IOException {
        Integer code = 200;
        String msg = "success";
        String data = null;
        // 文件是否为空
        if (file.isEmpty()) {
            code = 500;
            msg = "failure";
        } else {
            // 获取文件名（上传文件的原始名字）
            String originalFilename = file.getOriginalFilename();
            // 获取文件后缀名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 生成新的文件名（保存在服务器里使用的文件名）
            String fileName = UUID.randomUUID().toString() + suffix;
            String savePath = ResourceUtils.getURL("upload").getPath();
            savePath = savePath + File.separator + fileName;
            // 上传文件
            file.transferTo(new File(savePath));
        }
        return new ResponseModel(code,msg,data);
    }
}
