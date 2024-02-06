package com.hw.service;

import com.hw.util.FileConvertUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class PreviewService {

    public void onlinePreview(String path, HttpServletResponse response) {

        try {
            InputStream in = FileConvertUtil.convertLocaleFile(path, "doc");
            OutputStream outputStream = response.getOutputStream();
            // 创建存放文件内容的数组
            byte[] buff = new byte[1024];
            // 所读取的内容使用n来接收
            int n;
            // 当没有读取完时,继续读取,循环
            while ((n = in.read(buff)) != -1) {
                // 将字节数组的数据全部写入到输出流中
                outputStream.write(buff, 0, n);
            }
            // 强制将缓存区的数据进行输出
            outputStream.flush();
            // 关闭流
            outputStream.close();
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
