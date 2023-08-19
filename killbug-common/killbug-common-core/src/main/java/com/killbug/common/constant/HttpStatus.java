package com.killbug.common.constant;

/**
 * @author Zch
 * @date 2023/8/19
 **/
public interface HttpStatus {

    int SUCCESS = 200;

    /**
     * argument list error
     */
    int BAD_REQUEST = 400;

    /**
     * unauthorized
     */
    int UNAUTHORIZED = 401;

    /**
     * restricted access / expired authorization
     */
    int FORBIDDEN = 403;

    /**
     * server error
     */
    int ERROR = 500;

}
