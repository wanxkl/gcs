package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.RemainCurve;
import com.learning.gcs.common.entity.RemainCurveDetail;
import com.learning.gcs.common.repository.RemainCurveDetailRepository;
import com.learning.gcs.common.repository.RemainCurveRepository;
import com.learning.gcs.web.service.RemainCurveService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class RemainCurveServiceImpl implements RemainCurveService{
    @Autowired
    EntityManager entityManager;
    @Autowired
    RemainCurveDetailRepository detailRepository;
    @Autowired
    RemainCurveRepository remainCurveRepository;
    private org.slf4j.Logger logger = LoggerFactory.getLogger("RemainCurveServiceImpl");
    @Override
    public void saveRemainDetail(String[] datas ,String remainName,int remainType) {
        List<String> list = new ArrayList();
        for (int i=0;i<datas.length;i++){
            list.add(datas[i]);
        }
        RemainCurve remainCurve = new RemainCurve();
        remainCurve.setRemainName(remainName);
        remainCurve.setRemainType(remainType);
        List<RemainCurveDetail> details = new ArrayList<RemainCurveDetail>();
        for (int i =0;i<list.size();i++){
            RemainCurveDetail remainCurveDetail = new RemainCurveDetail();
            remainCurveDetail.setRemainCurve(remainCurve);
            remainCurveDetail.setDistance(i);
            remainCurveDetail.setPercent(Float.parseFloat(list.get(i).toString()));
            details.add(remainCurveDetail);
        }

        remainCurve.setRemainCurveDetails(details);
        remainCurveRepository.save(remainCurve);
    }

    @Override
    public List getRemainDetail() {
        List<RemainCurve> curves = remainCurveRepository.findAll();
        return curves;
       /* List<RemainCurveDetail> list = detailRepository.findAll();
        Iterator iterator = list.iterator();
        List dayIncreases = new ArrayList();
        List dayRemains = new ArrayList();
        List weekRemain = new ArrayList();
        List lists = new ArrayList();
        int i = 0;
        int j = 0;
        dayIncreases.add("日新增（%/小时）");
        dayRemains.add("日留存（%/小时）");
        weekRemain.add("周留存（%/天）");
        while (iterator.hasNext()){
            RemainCurveDetail remainCurveDetail =(RemainCurveDetail) iterator.next();
            String remainName = remainCurveDetail.getRemainCurve().getRemainName();
            int distance = remainCurveDetail.getDistance();
            if (remainName.equals("通用新增日曲线")){
                if (i==distance){
                    dayIncreases.add(remainCurveDetail.getPercent());
                }
                i++;
            }else if (remainName.equals("通用留存日曲线")){
                if (j==distance){
                    dayRemains.add(remainCurveDetail.getPercent());
                }
                j++;
            }else{
                weekRemain.add(remainCurveDetail.getPercent());
            }

        }
        for (int k=7;k<24;k++){
            weekRemain.add("-");
        }
        lists.add(dayIncreases);
        lists.add(dayRemains);
        lists.add(weekRemain);
        System.out.println(list.size()+"   "+dayIncreases+"天增"+dayRemains+"天留"+weekRemain+"周留");
        return lists;*/
    }

    @Override
    public RemainCurve findOne(int id) {
        return remainCurveRepository.findOne(id);
    }

    @Override
    public void updateRemainDetail(String remainName,int remainType,int id,String[] pencents) {
        RemainCurve remainCurve = new RemainCurve();
        if(remainCurveRepository.findOne(id)!=null){
            remainCurve = remainCurveRepository.findOne(id);
            for (int i=0;i<pencents.length;i++){
                RemainCurveDetail remainCurveDetail = new RemainCurveDetail();
                remainCurveDetail.setPercent(Float.parseFloat(pencents[i]));
                remainCurveDetail.setDistance(i);
                remainCurveDetail.setRemainCurve(remainCurve);
                detailRepository.updateRemainDetailCurveById(i,Float.parseFloat(pencents[i]),remainCurve);
            }
        }else{
            return;
        }
    }

    @Override
    public void deleteRemain(int id) {
        remainCurveRepository.delete(id);
    }
}
