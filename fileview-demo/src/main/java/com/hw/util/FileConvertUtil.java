package com.hw.util;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

import java.io.*;
import java.nio.file.Files;

/**
 * 文件格式转换工具类
 */
public class FileConvertUtil {

    /**
     * 默认转换后文件后缀
     */
    private static final String DEFAULT_SUFFIX = "pdf";
    /**
     * 端口
     */
    private static final Integer OPENOFFICE_PORT = 8100;

    /**
     * office文档转换为PDF(处理本地文件)
     *
     * @param sourcePath 源文件路径
     * @param suffix     源文件后缀
     * @return InputStream 转换后文件输入流
     */
    public static InputStream convertLocaleFile(String sourcePath, String suffix) throws Exception {
        File inputFile = new File(sourcePath);
        InputStream inputStream = Files.newInputStream(inputFile.toPath());
        return covertCommonByStream(inputStream, suffix);
    }


    /**
     * 将文件以流的形式转换
     *
     * @param inputStream 源文件输入流
     * @param suffix      源文件后缀
     * @return InputStream 转换后文件输入流
     */
    public static InputStream covertCommonByStream(InputStream inputStream, String suffix) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(OPENOFFICE_PORT);
        connection.connect();
        DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
        DefaultDocumentFormatRegistry formatReg = new DefaultDocumentFormatRegistry();
        DocumentFormat targetFormat = formatReg.getFormatByFileExtension(DEFAULT_SUFFIX);
        DocumentFormat sourceFormat = formatReg.getFormatByFileExtension(suffix);
        converter.convert(inputStream, sourceFormat, out, targetFormat);
        connection.disconnect();
        return outputStreamConvertInputStream(out);
    }

    /**
     * outputStream转inputStream
     */
    public static ByteArrayInputStream outputStreamConvertInputStream(final OutputStream out) throws Exception {
        ByteArrayOutputStream outputStream = (ByteArrayOutputStream) out;
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

}