package com.xyz.thymeleafdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;


@RestController
public class FileController {

   private static final Logger logger = LoggerFactory.getLogger(FileController.class);

   @RequestMapping("/upload")
   public String upload(@RequestParam("file")MultipartFile file) {
      try {
         if(file.isEmpty()) {
            return "文件为空";
         }

         //获取文件名称
         String fileName = file.getOriginalFilename();
         logger.info("文件名称:" + fileName);

         //获取文件名的后缀
         String suffixName = fileName.substring(fileName.lastIndexOf("."));
         fileName = UUID.randomUUID() + suffixName;

         String filePath = "D:\\upload\\";
         String path = filePath + fileName;
         File dest = new File(path);
         //判断路径是否存在，如不存在，则创建
         if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
         }
         file.transferTo(dest);
         return "上传成功";
      } catch (IOException e) {
         e.printStackTrace();
      }
      return "上传失败";
   }

   @GetMapping("/download")
   public String download(HttpServletRequest request, HttpServletResponse response) {
      String fileName = "test.txt";// 文件名
      if (fileName != null) {
         //设置文件路径
         File file = new File("D:\\upload\\test.txt");
         //File file = new File(realPath , fileName);
         if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
               fis = new FileInputStream(file);
               bis = new BufferedInputStream(fis);
               OutputStream os = response.getOutputStream();
               int i = bis.read(buffer);
               while (i != -1) {
                  os.write(buffer, 0, i);
                  i = bis.read(buffer);
               }
               return "下载成功";
            } catch (Exception e) {
               e.printStackTrace();
            } finally {
               if (bis != null) {
                  try {
                     bis.close();
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
               }
               if (fis != null) {
                  try {
                     fis.close();
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
               }
            }
         }
      }
      return "下载失败";
   }

   @PostMapping("/batch")
   public String handleFileUpload(HttpServletRequest request) {
      List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
      MultipartFile file = null;
      BufferedOutputStream stream = null;
      for (int i = 0; i < files.size(); ++i) {
         file = files.get(i);
         String filePath = "D:\\upload\\";
         if (!file.isEmpty()) {
            try {
               byte[] bytes = file.getBytes();
               stream = new BufferedOutputStream(new FileOutputStream(
                       new File(filePath + file.getOriginalFilename())));//设置文件路径及名字
               stream.write(bytes);// 写入
               stream.close();
            } catch (Exception e) {
               stream = null;
               return "第 " + i + " 个文件上传失败 ==> "
                       + e.getMessage();
            }
         } else {
            return "第 " + i
                    + " 个文件上传失败因为文件为空";
         }
      }
      return "上传成功";
   }

}
