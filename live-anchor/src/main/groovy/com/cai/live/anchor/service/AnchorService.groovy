package com.cai.live.anchor.service

import com.cai.live.common.MultiUploadSetting
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class AnchorService {

    @Autowired
    MultiUploadSetting multiUploadSetting

    String multiUpload(List<MultipartFile> files){
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(multiUploadSetting.path + fileName);
            try {
                file.transferTo(dest);
                println("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                println e.printStackTrace()
                return "上传第" + (i++) + "个文件失败";
            }
        }

        return "上传成功";


    }
}
