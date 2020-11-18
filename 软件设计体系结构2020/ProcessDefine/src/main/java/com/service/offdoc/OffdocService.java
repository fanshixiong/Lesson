package com.service.offdoc;

import com.pojo.offdoc.Offdocform;

import java.util.Date;
import java.util.List;

public interface OffdocService {
    List<Offdocform> getAlloffdocforms(String name);

    int addoffdoc(Offdocform offdocform);

    int deloffdoc(String id);

    List<Offdocform> getoffdocBySstate(int state);

    int updateoffdocSstate(String id, int state, Date date);
}
