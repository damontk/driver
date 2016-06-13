//package com.zhongc.driver.common;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.InputStream;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.lang.RandomStringUtils;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import com.born.keap.util.spsuntil.Dates;
//
///**
// *
// * @标题:
// * @版权:
// * @版本: v1.0
// * @创建人: wangjifa
// * @创建时间: 2014-7-2 上午9:34:20
// * @修改人:
// * @修改时间:
// * @功能点: <p></p>
// * @描述: <p></p>
// */
//public class AbstractFileOperationController {
//
//	static Logger logger = LoggerFactory.getLogger(AbstractFileOperationController.class);
//
//	public static enum FileType {
//		EXCEL, CSV
//	}
//
//	/** 文件上传默认配置 */
//	protected UploadConfig uploadConfig = new UploadConfig();
//
////	protected String getFileStorageRoot() {
////		return storageRoot + File.separator + Constants.MEDIA_STORAGE_CUSTOMER;
////	}
//
//	/**
//	 * 上传处理
//	 *
//	 * @param request
//	 * @return key --> 请求的表单参数名称, value ---> 上传结果
//	 */
//	protected Map<String, UploadResult> doUpload(HttpServletRequest request) throws Exception {
//		UploadConfig uploadConfig = getUploadConfig();
//		Map<String, UploadResult> uploadResults = new HashMap<String, UploadResult>();
//		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//		Map<String, MultipartFile> multipartFiles = multiRequest.getFileMap();
//		UploadResult result = null;
//		for (Map.Entry<String, MultipartFile> entry : multipartFiles.entrySet()) {
//			MultipartFile mfile = entry.getValue();
//			String filename = mfile.getOriginalFilename();
//			if (mfile.getSize() > uploadConfig.getMaxSize()) {
//				throw new RuntimeException("图片大小不能超过" + uploadConfig.getMaxSize() / 1024 / 1024
//						+ "M");
//			}
//			String fileExtention = getFileExtention(filename);
//			if (!StringUtils.containsIgnoreCase(uploadConfig.getAllowExtentions(), fileExtention)) {
//				throw new RuntimeException("图片类型不支持，支持类型:" + uploadConfig.getAllowExtentions());
//			}
//
//			if (uploadConfig.isUseMemery()) {
//				// 内存方式，不转存到服务器存储，直接返回流给调用端
//				result = new UploadResult(entry.getKey(), filename, mfile.getSize(), mfile.getInputStream());
//			} else {
//				// 转存到服务器，返回服务器文件
//				File destFile = new File(getUploadFileName(filename, uploadConfig));
//				InputStream is = mfile.getInputStream();
//				BufferedImage bi=ImageIO.read(is);
//				mfile.transferTo(destFile);
//				result = new UploadResult(entry.getKey(), filename, mfile.getSize(), destFile);
//				result.setImgWidth(bi.getWidth());
//				result.setImgHeight(bi.getHeight());
//			}
//			uploadResults.put(entry.getKey(), result);
//		}
//		return uploadResults;
//	}
//
//	/*private FileType getFileType(UploadResult uploadResult){
//		String ext = getFileExtention(uploadResult.getName());
//		if (StringUtils.equalsIgnoreCase(ext, "xls")) {
//			return FileType.EXCEL;
//		} else if (StringUtils.equalsIgnoreCase(ext, "csv")) {
//			return FileType.CSV;
//		} else {
//			return null;
//		}
//	}*/
//
//	protected String getUploadFileName(String originalFileName, UploadConfig uploadConfig) {
//		String fileName = originalFileName;
//		if (uploadConfig.isNeedRemaneToTimestamp()) {
//			fileName = buildUploadFileName() + "." + getFileExtention(fileName);
//		}
//		return buildUploadStoragePath(uploadConfig.getStorageRoot(), uploadConfig.isNeedTimePartPath(), null)
//				+ File.separator + fileName;
//	}
//
//	protected String buildUploadStoragePath(String storageRoot, boolean needTimePartPath, Date baseDate) {
//		String path = storageRoot;
//		try {
//			if (needTimePartPath) {
//				Date d = baseDate;
//				if (d == null) {
//					d = new Date();
//				}
//				String pathTimestamp = Dates.format(d, Dates.DATETIME_NOT_SEPARATOR);
//				String yearPart = StringUtils.left(pathTimestamp, 4);
//				String monthPart = StringUtils.substring(pathTimestamp, 4, 6);
//				String dayPart = StringUtils.substring(pathTimestamp, 6, 8);
//				String subPath = File.separator + yearPart + File.separator + monthPart + File.separator + dayPart;
//
//				path += subPath;
//			}
//			File pathFile = new File(path);
//			if (!pathFile.exists()) {
//				pathFile.mkdirs();
//			}
//		} catch (Exception e) {
//			logger.warn("Build path failure --> ", e);
//		}
//		return path;
//
//	}
//
//
//	protected String buildUploadFileName() {
//		return Dates.format(new Date(), Dates.DATETIME_NOT_SEPARATOR) + RandomStringUtils.randomNumeric(4);
//	}
//
//	private String getFileExtention(String filePath) {
//		return StringUtils.substringAfterLast(filePath, ".");
//	}
//
//	protected UploadConfig getUploadConfig() {
//		return this.uploadConfig;
//	}
//
//
//	protected static class UploadResult {
//		private String name;
//		private long size;
//		private File file;
//		private String parameterName;
//		private InputStream inputStream;
//		private int imgWidth;
//		private int imgHeight;
//		public UploadResult() {
//			super();
//		}
//
//		public UploadResult(String parameterName, String name, long size, File file) {
//			super();
//			this.name = name;
//			this.size = size;
//			this.file = file;
//			this.parameterName = parameterName;
//		}
//
//		public UploadResult(String parameterName, String name, long size, InputStream inputStream) {
//			super();
//			this.name = name;
//			this.size = size;
//			this.parameterName = parameterName;
//			this.inputStream = inputStream;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public long getSize() {
//			return size;
//		}
//
//		public void setSize(long size) {
//			this.size = size;
//		}
//
//		public File getFile() {
//			return file;
//		}
//
//		public void setFile(File file) {
//			this.file = file;
//		}
//
//		public String getParameterName() {
//			return parameterName;
//		}
//
//		public void setParameterName(String parameterName) {
//			this.parameterName = parameterName;
//		}
//
//		public InputStream getInputStream() {
//			return inputStream;
//		}
//
//		public void setInputStream(InputStream inputStream) {
//			this.inputStream = inputStream;
//		}
//
//		public int getImgWidth() {
//			return imgWidth;
//		}
//
//		public void setImgWidth(int imgWidth) {
//			this.imgWidth = imgWidth;
//		}
//
//		public int getImgHeight() {
//			return imgHeight;
//		}
//
//		public void setImgHeight(int imgHeight) {
//			this.imgHeight = imgHeight;
//		}
//
//	}
//
//	protected static class UploadConfig {
//		private long maxSize = 1024 * 1024 * 32;
//		private String allowExtentions = "txt,zip,csv,xls,jpg,gif,png";
//		private String storageRoot = System.getenv("java.tmp");
//		private boolean useMemery = true;
//		private boolean needTimePartPath = true;
//		private boolean needRemaneToTimestamp = true;
//
//		public boolean isUseMemery() {
//			return useMemery;
//		}
//
//		public void setUseMemery(boolean useMemery) {
//			this.useMemery = useMemery;
//		}
//
//		public long getMaxSize() {
//			return maxSize;
//		}
//
//		public void setMaxSize(long maxSize) {
//			this.maxSize = maxSize;
//		}
//
//		public String getAllowExtentions() {
//			return allowExtentions;
//		}
//
//		public void setAllowExtentions(String allowExtentions) {
//			this.allowExtentions = allowExtentions;
//		}
//
//		public String getStorageRoot() {
//			return storageRoot;
//		}
//
//		public void setStorageRoot(String storageRoot) {
//			this.storageRoot = storageRoot;
//		}
//
//		public boolean isNeedTimePartPath() {
//			return needTimePartPath;
//		}
//
//		public void setNeedTimePartPath(boolean needTimePartPath) {
//			this.needTimePartPath = needTimePartPath;
//		}
//
//		public boolean isNeedRemaneToTimestamp() {
//			return needRemaneToTimestamp;
//		}
//
//		public void setNeedRemaneToTimestamp(boolean needRemaneToTimestamp) {
//			this.needRemaneToTimestamp = needRemaneToTimestamp;
//		}
//	}
//
//	/**
//	 * 过滤反斜杠
//	 *
//	 * @param storageRoot
//	 * @param targetFilePath
//	 * @return
//	 */
//	protected String tempFilePath(UploadResult uploadResults, String storageRoot) {
//		storageRoot = storageRoot.replaceAll("\\\\", "/");
//		File file = uploadResults.getFile();
//		String filePath = file.getPath();
//		filePath = filePath.replaceAll("\\\\", "/");
//		String tempFilePath = StringUtils.substringAfter(filePath, storageRoot);
//		tempFilePath = tempFilePath.replaceAll("\\\\", "/");
//		return tempFilePath;
//	}
//
//}
