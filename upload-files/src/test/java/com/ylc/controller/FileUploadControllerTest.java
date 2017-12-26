package com.ylc.controller;

import com.ylc.exception.StorageFileNotFoundException;
import com.ylc.service.StorageService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/12/26 23:35
 * @description: xxx
 * own: Aratek
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FileUploadControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StorageService storageService;

    @Test
    public void listUploadedFiles() throws Exception {
        //此处定义调用storageService.loadAll()方法后返回的值
        BDDMockito.given(storageService.loadAll()).willReturn(Stream.of(Paths.get("abc.txt"), Paths.get("bcd.txt")));
        //设置mvc请求，并对返回页面model中的数据进行比对校验
        mvc.perform(get("/")).andExpect(status().isOk()).andExpect(model().attribute("files", Matchers.contains("http://localhost/files/abc.txt", "http://localhost/files/bcd.txt")));
    }

    @Test
    public void handleFileUpload() throws Exception {
        //构造需要上传的文件对象
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file","test.txt","text/plain","yuan lincheng".getBytes());
        //使用MVC构造文件上传请求，并对返回状态和http头进行及比对校验
        mvc.perform(fileUpload("/").file(mockMultipartFile)).andExpect(status().isFound()).andExpect(header().string("Location", "/"));
        //对文件进行存储
        then(storageService).should().store(mockMultipartFile);
    }

    @Test
    public void handleStorageFileNotFound() throws Exception {
        given(storageService.loadAsResource("test.txt")).willThrow(StorageFileNotFoundException.class);
        mvc.perform(get("/files/test.txt")).andExpect(status().isNotFound());
    }

}