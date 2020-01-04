package com.xyz.uploadfilesdemo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

   @RequestMapping(value = "/index",method = RequestMethod.GET)
   public String index(){
      return "index";
   }

   @RequestMapping(value = "/upload", method = RequestMethod.POST)
   public @ResponseBody String upload(HttpServletRequest request, MultipartFile file) throws IOException {
      //上传文件路径
      String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
      //如果文件不存在，自动创建
      File dir = new File(uploadDir);
      if(!dir.exists()) {
         dir.mkdir();
      }
      executeUpload(uploadDir, file);

      return "上传成功";
   }

   private void executeUpload(String uploadDir, MultipartFile file) throws IOException {
      String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
      String fileName = UUID.randomUUID() +suffix;
      File serverFile = new File(uploadDir + fileName);
      file.transferTo(serverFile);
   }

}
