package com.cai.live.anchor.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/v1/anchor/")
class AnchorController {

    @PostMapping("/multiUpload")
    @ResponseBody
    String multiUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = "/Users/itinypocket/workspace/temp/";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                println("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                println(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }

        return "上传成功";

    }
}
