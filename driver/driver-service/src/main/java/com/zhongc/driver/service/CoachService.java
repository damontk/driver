package com.zhongc.driver.service;

import com.zhongc.driver.domain.order.coach.CoachAddOrder;
import com.zhongc.driver.domain.order.coach.CoachQueryOrder;
import com.zhongc.driver.domain.order.coach.CoachUpdateOrder;
import com.zhongc.driver.result.CommonEntityResult;
import com.zhongc.driver.result.CommonPageResult;
import com.zhongc.driver.result.CommonResult;

/**
 * @Filename CoachService.java
 * @Description
 * @Version 1.0
 * @Author zhongc
 * @Email zhong_ch@foxmail.com
 * @History <li>Author: zhongc</li>
 * <li>Date: 2015-11-14</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public interface CoachService {

    /**
     * 添加教练信息
     * @param order
     * @return
     */
    CommonResult addCoach(CoachAddOrder order);

    /**
     * 修改教练信息
     * @param order 修改条件
     * @return
     */
    CommonResult modifyCoachInfo(CoachUpdateOrder order);

    /**
     * 删除教练信息
     * @param coachId 教练id
     * @return
     */
    CommonResult deleteCoach(String coachId);

    /**
     * 根据教练id查询教练详细信息
     * @param coachId
     * @return
     */
    CommonEntityResult findCoachByCoachId(String coachId);

    /**
     * 根据条件分页插叙教练信息
     * @param order 查询条件
     * @return
     */
    CommonPageResult findCoachs(CoachQueryOrder order);
}
