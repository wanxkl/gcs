package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.PhoneCaptcha;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 16:43
 * @description
 */
public interface PhoneCaptchaRepository extends MyRepository<PhoneCaptcha,Integer>{

    Integer countByPhoneNumber(String phoneNumber);

    @Query("SELECT p from PhoneCaptcha p  where p.id not in (select g.phoneCaptchaId from GcsTaskPhoneCaptcha g where g.gcsTaskId =:taskId) order by p.createTime desc")
    List<PhoneCaptcha> findByTaskId(@Param("taskId") Integer taskId);

    PhoneCaptcha findByPhoneNumber(String phoneNumber);
}
