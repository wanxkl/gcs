package com.learning.gcs.web.Service.impl;

import com.learning.gcs.common.entity.RemainCurve;
import com.learning.gcs.common.entity.RemainCurveDetail;
import com.learning.gcs.common.repository.RemainCurveDetailRepository;
import com.learning.gcs.common.repository.RemainCurveRepository;
import com.learning.gcs.web.Service.RemainCurveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RemainCurveServiceImpl implements RemainCurveService{
    @Autowired
    EntityManager entityManager;
    @Autowired
    RemainCurveDetailRepository detailRepository;
    @Autowired
    RemainCurveRepository remainCurveRepository;
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
        System.out.println(curves.get(0).getRemainCurveDetails().get(1).getId());
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
    public void updateRemainDetail(List list) {

    }

    @Override
    public void deleteRemain(int id) {
        remainCurveRepository.delete(id);
    }
}
