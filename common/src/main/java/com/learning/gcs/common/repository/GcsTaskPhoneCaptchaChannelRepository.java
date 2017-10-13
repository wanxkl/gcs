package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTaskPhoneCaptchaChannel;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/13 10:28
 * @description
 */
public interface GcsTaskPhoneCaptchaChannelRepository extends MyRepository<GcsTaskPhoneCaptchaChannel,Integer>{

    GcsTaskPhoneCaptchaChannel findTopByGcsTaskIdAndStatus(Integer gcsTaskId,Integer status);
}
