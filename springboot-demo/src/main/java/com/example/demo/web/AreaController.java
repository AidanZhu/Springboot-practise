package com.example.demo.web;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    public Map<String,Object> listArea(){
        Map<String,Object> hashMap = new HashMap<>();
        List<Area> areaList = areaService.getArea();
        hashMap.put("areaList",areaList);
        return hashMap;
    }

    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    public Map<String,Object> getAreaById(@RequestParam Integer areaId){
        Map<String,Object> hashMap = new HashMap<>();
        Area area = areaService.getAreaById(areaId);
        hashMap.put("area",area);
        return hashMap;
    }

    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    public Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("success",areaService.addArea(area));
        return hashMap;
    }

    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    public Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("success",areaService.modifyArea(area));
        return hashMap;
    }

    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    public Map<String,Object> removeArea(@RequestParam Integer areaId){
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("success",areaService.deleteArea(areaId));
        return hashMap;
    }

}
