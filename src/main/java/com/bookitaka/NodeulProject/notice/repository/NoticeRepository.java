package com.bookitaka.NodeulProject.notice.repository;

import com.bookitaka.NodeulProject.notice.domain.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends PagingAndSortingRepository<Notice,Integer> {

    @Modifying
    @Query("update Notice n set n.noticeHit = n.noticeHit + 1 where n.noticeNo = :noticeNo")
    int updateHit(@Param("noticeNo") Integer noticeNo);

   Page<Notice> findByNoticeTitleContainingOrNoticeContentContaining(String titleKeyword, String contentKeyword, Pageable pageable);

}
