package org.example.quan_ly_ban_hang.service.detail;

import org.example.quan_ly_ban_hang.dto.DetailCreate;
import org.example.quan_ly_ban_hang.dto.DetailDTO;

import java.util.List;

public interface IDetailService {
    List<DetailDTO> getAllDetail();

    void addDetail(DetailCreate detail);
}
