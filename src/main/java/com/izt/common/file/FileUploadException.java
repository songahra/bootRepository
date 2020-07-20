package com.izt.common.file;

public class FileUploadException extends RuntimeException{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
    
    // 파일 업로드 exception
    public FileUploadException() {
        super("File Upload Exception");
    }

    public FileUploadException(String message) {
        super(message);
    }
}