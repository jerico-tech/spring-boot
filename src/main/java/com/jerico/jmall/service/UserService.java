package com.jerico.jmall.service;

import com.github.pagehelper.PageInfo;

/**
 * @className: UserService
 * @description:
 * @author: jerico
 * @date: 2019-09-19 01:12
 * @version:
 */
public interface UserService {
    PageInfo listUsers(int pageNum, int pageSize);
}
