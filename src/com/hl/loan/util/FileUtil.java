package com.hl.loan.util;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class FileUtil {

	public static void upload(String filePath, File file) throws Exception {
		File savefile = new File(filePath);
		if (!savefile.getParentFile().exists())
			savefile.getParentFile().mkdirs();
		FileUtils.copyFile(file, savefile);
	}

	public static void deleteuploadfile(String absolutpath) throws Exception {
		File file = new File(absolutpath);
		if (file.exists())
			file.delete();
	}
}