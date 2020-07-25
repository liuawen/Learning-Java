package com.dalaoyang.service.impl;

import com.dalaoyang.entity.Lock;
import com.dalaoyang.repository.LockRepository;
import com.dalaoyang.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


@Service
public class LockServiceImpl implements LockService {

    private final Integer DEFAULT_EXPIRED_SECONDS = 10;

    @Autowired
    private LockRepository lockRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean tryLock(String tag, Integer expiredSeconds) {
        if (StringUtils.isEmpty(tag)) {
            throw new NullPointerException();
        }
        Lock lock = lockRepository.findByTag(tag);
        if (Objects.isNull(lock)) {
            lockRepository.save(new Lock(tag, this.addSeconds(new Date(), expiredSeconds), Lock.LOCKED_STATUS));
            return true;
        } else {
            Date expiredTime = lock.getExpirationTime();
            Date now = new Date();
            if (expiredTime.before(now)) {
                lock.setExpirationTime(this.addSeconds(now, expiredSeconds));
                lockRepository.save(lock);
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void unlock(String tag) {
        if (StringUtils.isEmpty(tag)) {
            throw new NullPointerException();
        }
        lockRepository.deleteByTag(tag);
    }

    private Date addSeconds(Date date, Integer seconds) {
        if (Objects.isNull(seconds)){
            seconds = DEFAULT_EXPIRED_SECONDS;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }
}
