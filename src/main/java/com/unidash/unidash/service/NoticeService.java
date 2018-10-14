package com.unidash.unidash.service;

import com.unidash.unidash.entity.Notices;
import com.unidash.unidash.repo.NoticeRepository;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeService {
    private NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public void saveNotice(Notices notice) {
        noticeRepository.save(notice);
    }
}
