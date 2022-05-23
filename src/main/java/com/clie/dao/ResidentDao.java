package com.clie.dao;

import com.clie.domain.Resident;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResidentDao {
    @Select("select resident_id,resident_name,resident_gender,resident_password,resident_role_id," +
            "resident_phone,create_time,is_delete from resident")
    List<Resident> selectAll();
}
