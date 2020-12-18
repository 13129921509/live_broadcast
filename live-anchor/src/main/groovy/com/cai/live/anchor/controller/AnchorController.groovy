package com.cai.live.anchor.controller

import com.cai.live.anchor.service.AnchorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
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

    @Autowired
    AnchorService anchorService

    @PostMapping("/multiUpload")
    @ResponseBody
    String multiUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        return anchorService.multiUpload(files)
    }
}
