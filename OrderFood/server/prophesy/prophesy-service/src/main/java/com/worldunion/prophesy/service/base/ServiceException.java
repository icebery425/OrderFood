package com.worldunion.prophesy.service.base;

/**
 * 业务层的异常类
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
