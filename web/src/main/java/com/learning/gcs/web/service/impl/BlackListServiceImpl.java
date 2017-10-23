package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.BlackList;
import com.learning.gcs.common.repository.BlackListRepository;
import com.learning.gcs.web.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlackListServiceImpl implements BlackListService {
    @Autowired
    BlackListRepository blackListRepository;

    @Override
    public void save(String blackName) {
        BlackList blackList = new BlackList();
        blackList.setBlackName(blackName);
        blackListRepository.save(blackList);
    }

    @Override
    public List<BlackList> findAll() {
        return blackListRepository.findAll();
    }

    @Override
    public void updateById(int id,String blackName) {
        blackListRepository.updateById(id, blackName);
    }

    @Override
    public void delete(int id) {
        blackListRepository.delete(id);
    }

    @Override
    public BlackList findOne(int id) {
        return blackListRepository.findOne(id);
    }
}
