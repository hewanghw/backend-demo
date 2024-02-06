package com.hw.controller;

import com.hw.service.PreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PreviewController {

    @Autowired
    private PreviewService previewService;

    @GetMapping("/onlinePreview")
    public void onlinePreview(HttpServletResponse response) throws Exception{
        String path = "C:\\Users\\wanghe02\\Desktop\\Doc1.doc";
        previewService.onlinePreview(path,response);
    }
}
