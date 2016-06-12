package com.zhongc.driver.web.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cst on 2016/4/19 0019.
 */
public class GetHtmlResources {
    private static final String URL = "http://blog.nosqlfan.com/html/4209.html";
    /**
     * pdf下载地址匹配
     */
    private static final String REGEX_PDF = "\\b(([\\w-]+://?|www[.])[^\\s()<>]+(?:\\([\\w\\d]+\\)|([^[:punct:pdf]\\s]|/)))";
    /**
     * 包含在li 中
     */
    private static final String REGEX_LI = "<li.<a.*?>(?)</li>";

    public static void main(String[] args) {
        try {
            String html = getHtml();
            Map<String, String> map = marchNameAndUrl(html);
            Down(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        charReplace();

    }

    public static String getHtml() throws IOException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer sb = new StringBuffer("");
        String line = "";
        while (null != (line = read.readLine())) {
            sb.append(line);
            System.out.println(line);
        }
        read.close();
        inputStream.close();
        return sb.toString();
    }

    public static Map<String, String> marchNameAndUrl(String html) {
        Pattern pattern_li = Pattern.compile(REGEX_LI);
        Pattern pattern_pdf = Pattern.compile(REGEX_PDF);
        Matcher matcher_li = pattern_li.matcher(html);
        Map<String, String> map = new HashMap<>();
        while (matcher_li.find()) {
            String li = matcher_li.group();
            Matcher matcher_pdf = pattern_pdf.matcher(li);
            while (matcher_pdf.find()) {
                String url = matcher_pdf.group();
                if (url.endsWith(".pdf")) {
                    System.out.println(url);
                    String name = li.substring(li.indexOf("target=\"_blank\">") + 16, li.indexOf("</a>"));
                    map.put(name, url);
                }
            }
        }
        return map;
    }

    public static void Down(Map<String, String> map) {
        URL url = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String name_ = entry.getKey().trim();
            String url_ = entry.getValue();
            if (url_.endsWith(".pdf"))
                try {
                    System.out.println("开始下载...");
                    url = new URL(url_);
                    System.out.println(url);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream read = connection.getInputStream();
                    //文件保存位置
                    String path = "";
                    String name = "";
                    if (name_.lastIndexOf("/") != -1) {
                        path = name_.substring(0, name_.lastIndexOf("/"));
                        name = name_.substring(name_.lastIndexOf("/") + 1);
                    } else {
                        name = name_;
                    }
                    File saveDir = new File("D:\\pdf下载\\" + path);
//                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    if (!saveDir.exists()) {
                        makeDir(saveDir);
                    }
                    File file = new File(saveDir + File.separator + name);
                    FileOutputStream fileOut = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    int read_ = 0;
                    while ((read_ = read.read(buffer)) != -1) {
                        fileOut.write(buffer, 0, read_);
                    }
//                    bos.close();
//                    fileOut.write(bos.toByteArray());
                    fileOut.close();
                    read.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void makeDir(File dir) {
        if (!dir.getParentFile().exists()) {
            makeDir(dir.getParentFile());
        }
        dir.mkdir();
    }

    public static void charReplace() {
        String regex = ".pdf";
        String regex_ = "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9]{0,60})?\\.)+pdf$";
        String li = "<li.<a.*?>(?)</li>";
//        String a = "<a.*?>(?)</a>";
        String regex__ = "<a.*?>\\b(([\\w-]+://?|www[.])[^\\s()<>]+(?:\\([\\w\\d]+\\)|([^[:punct:pdf]\\s]|/)))";
        Pattern pattern = Pattern.compile(li);
        Matcher matcher = pattern.matcher("<li><a href=\"http://topic.it168.com/factory/DTCC2013/doc/a1.pdf\" target=\"_blank\">大asdfasdf数据革命.pdf</a></li>");
        String name = "";
        while (matcher.find()) {
            name = matcher.group();
            System.out.println(name);
        }
        // 获取pdf下载链接
        Pattern pattern_ = Pattern.compile(REGEX_PDF);
        Matcher matcher_ = pattern_.matcher(name);
        if (matcher_.find()) {
            System.out.println(matcher_.group());
        }
        // 获取名称
        String name_ = name.substring(name.indexOf("target=\"_blank\">") + 16, name.indexOf("</a>"));
        System.out.println(name_);
        String a = "/asdfaf/asdfadgfqegt/adsf.jpg";
        String path = a.substring(a.lastIndexOf("/") + 1);
        System.out.println(path);

//
//        String s = matcher.replaceAll("/");
//        System.out.println(s);
    }
}
