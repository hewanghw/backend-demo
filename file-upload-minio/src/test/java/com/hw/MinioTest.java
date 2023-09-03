package com.hw;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.RemoveObjectArgs;
import io.minio.UploadObjectArgs;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;

/**
 * @description 测试minio的sdk
 */
public class MinioTest {
    // 获取minio对象
    MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://localhost:9000")
                    .credentials("minioadmin", "minioadmin")
                    .build();

    /**
     * 上传文件
     */
    @Test
    public void test_upload() throws Exception {
        //通过扩展名得到媒体资源类型 mimeType
        //根据扩展名取出mimeType
        ContentInfo extensionMatch = ContentInfoUtil.findExtensionMatch(".jpg");
        String mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;//通用mimeType，字节流
        if (extensionMatch != null) {
            mimeType = extensionMatch.getMimeType();
        }

        // 上传文件的参数信息
        UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder()
                .bucket("testbucket")// 指定上传的桶
                .filename("E:\\aa.jpg") // 指定本地上传的文件路径
                .object("aa.jpg") // 上传后文件的名称 如果是test/test.png 会放在test目录下
                .contentType(mimeType)//设置媒体文件类型
                .build();

        // 上传文件
        minioClient.uploadObject(uploadObjectArgs);

        // todo: 校验文件的完整性
    }

    /**
     * 删除文件
     */
    @Test
    public void test_delete() throws Exception {
        // 要删除文件的参数信息
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                .bucket("testbucket")
                .object("aa.png")
                .build();

        // 删除文件
        minioClient.removeObject(removeObjectArgs);
    }

    /**
     * 查询文件下载 从minio中下载
     */
    @Test
    public void test_getFile() throws Exception {
        // 需要获取的文件的参数信息
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                .bucket("testbucket")
                .object("aa.jpg")
                .build();

        // 获取文件输入流
        FilterInputStream inputStream = minioClient.getObject(getObjectArgs);

        // 指定输出流
        FileOutputStream outputStream = new FileOutputStream("E:\\testbucket-download\\aa.jpg");

        // 把输入流拷贝给输出流
        IOUtils.copy(inputStream, outputStream);

        // 通过md5 校验文件的完整性
        String source_md5 = DigestUtils.md5Hex(inputStream);
        // 获取下载的文件的输入流
        FileInputStream fileInputStream = new FileInputStream("E:\\testbucket-download\\aa.jpg");
        String local_md5 = DigestUtils.md5Hex(fileInputStream);
        if (source_md5.equals(local_md5)) {
            System.out.println("下载成功");
        }
    }
}
