package org.lvtinger.paladin.account.impl;

import org.lvtinger.paladin.account.api.SessionService;
import org.lvtinger.paladin.account.api.entity.Session;
import org.lvtinger.paladin.account.repo.SessionRepository;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Result<Long> val(String token) {
        Session session = this.sessionRepository.getSessionByToken(token);
        if (session.dead()) {
            return Result.<Long>warning().touchMessage("登录状态错误");
        }
        return Result.success(session.getUserId());
    }

    @Override
    public Result<String> set(Long userId, String device) {
        Session session = sessionRepository.getSessionByUserIdAndDevice(userId, device);
        if (session == null) {
            session = Session.build(userId, device);
        } else {
            session = session.refresh();
        }
        sessionRepository.save(session);
        return Result.success(session.getToken());
    }

    @Override
    public Result<Boolean> exp(String token) {
        Session session = this.sessionRepository.getSessionByToken(token);
        if (session != null) {
            session.setDisable(true);
        }
        return Result.success(true);
    }

    @Override
    public Result<Boolean> exp(Long userId) {
        List<Session> sessions = this.sessionRepository.getSessionsByUserId(userId);
        if (CollectionUtils.isEmpty(sessions)) {
            return Result.success(true);
        }
        sessions.forEach(x -> {
            x.setDisable(true);
            sessionRepository.save(x);
        });
        return Result.success(true);
    }
}
