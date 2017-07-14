package com.wechat.https;

/**
 * 判断请求体的类型
 * @author user
 *
 */

public class GetFileExt {

	public static String getFileExt(String contentType) {
		String fileExt = "";
		if ("image/jpeg".equals(contentType)) {
			fileExt = ".jpg";
		} else if ("audio/mpeg".equals(contentType)) {
			fileExt = ".mp3";

		} else if ("audio/amr".equals(contentType)) {
			fileExt = ".amr";

		} else if ("audio/wav".equals(contentType)) {
			fileExt = ".wav";
		} else if ("video/mp4".equals(contentType)) {

			fileExt = ".mp4";
		} else if ("video/mpeg4".equals(contentType)) {

			fileExt = ".mp4";
		}

		return fileExt;
	}

}
