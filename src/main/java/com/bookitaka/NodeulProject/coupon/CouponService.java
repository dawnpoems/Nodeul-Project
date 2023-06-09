package com.bookitaka.NodeulProject.coupon;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface CouponService {
//    Coupon addToCoupon(Coupon coupon);
    List<Coupon> getCouponByMemberEmail(String memberEmail);

    int getCountByMemberEmail(String memberEmail);

    List<Coupon> getAllCouponsByMemberEmail(CouponCri cri, String memberEmail);

    int getValidCouponCntByMemberEmail(String memberEmail);

    boolean couponCheck(String memberEmail);

    boolean useCoupon(Long couponNo, int amount);
}