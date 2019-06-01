package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("test1",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("test3");
        area.setPriority(3);
        assertEquals(1,areaDao.insertArea(area));
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("test33");
        area.setAreaId(3L);
        assertEquals(1,areaDao.updateArea(area));
    }

    @Test
    @Ignore
    public void deleteArea() {
        assertEquals(1,areaDao.deleteArea(3));
    }
}