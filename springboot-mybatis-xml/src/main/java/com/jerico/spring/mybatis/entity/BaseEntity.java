package com.jerico.spring.mybatis.entity;

import java.time.LocalDateTime;
import jdk.jfr.DataAmount;
import lombok.Data;

/**
 * @className: BaseEntity
 * @description:
 * @author: jerico
 * @date: 2020-03-13 00:53
 * @version:
 */
@Data
public class BaseEntity {
  private Integer createdBy;
  private LocalDateTime createTime;
  private Integer lastUpdatedBy;
  private LocalDateTime lastUpdateTime;
}
