package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTaskPhoneCaptchaLog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/13 15:41
 * @description
 */
public interface GcsTaskPhoneCaptchaLogRepository extends MyRepository<GcsTaskPhoneCaptchaLog,Integer>{
    @Transactional
    @Modifying
    @Query("update GcsTaskPhoneCaptchaLog g set g.captcha =:captcha where g.gcsTaskId =:taskId and g.phoneCaptchaChannelId =:captchaChannelId and g.phoneNumber =:phoneNumber")
    void updateCaptchaByTaskIdAndAndPhoneCaptchaChannelIdAndPhoneNumber(@Param("captcha") String captcha,
                                                                        @Param("taskId") Integer taskId,
                                                                        @Param("captchaChannelId") Integer captchaChannelId,
                                                                        @Param("phoneNumber") String phoneNumber);
}
