package com.example.demo.service.impl;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName()))
        {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectedNumber = areaDao.insertArea(area);
                if (effectedNumber >0){
                    return true;
                }else{
                    throw new RuntimeException("Failed to add new area!");
                }
            }catch (Exception e){
                throw new RuntimeException("Failed to add new area! Error: " + e.getMessage());
            }
        } else{
            throw new RuntimeException("Area Name can't be null!");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0){
            area.setLastEditTime(new Date());
            try{
                int effectedNumber = areaDao.updateArea(area);
                if (effectedNumber >0){
                    return true;
                }else{
                    throw new RuntimeException("Failed to update area!");
                }
            }catch (Exception e){
                throw new RuntimeException("Failed to update area! Error: "+e.getMessage());
            }
        }else {
            throw  new RuntimeException("Area Id can't be null!");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0){
            try{
                int effectedNumber = areaDao.deleteArea(areaId);
                if (effectedNumber >0){
                    return true;
                }else{
                    throw new RuntimeException("Failed to delete area!");
                }
            }catch (Exception e){
                throw new RuntimeException("Failed to delete area! Error: "+e.getMessage());
            }
        }else {
            throw  new RuntimeException("Area Id can't be null!");
        }
    }
}
