package com.bit.proyecto.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.SessionDao;
import com.bit.proyecto.modelo.Session;
import com.bit.proyecto.modelo.dto.SessionDto;



@Repository
public class SessionRepository {

    @Autowired
    private SessionDao sessionDao;

    public SessionDto verifyCredentials(String user, String password) {
        List<Session> sessions = sessionDao.findAllByUsuarioSession(user.toLowerCase());
        if (sessions.isEmpty() || sessions.size() > 1) {
            return null;
        } else {
            Session session = sessions.get(0);
            return new SessionDto(session.getCodigoSession(), session.getUsuarioSession(), session.getPasswordSession(),
                    session.getTokenSession(),
                    session.getFechaOperacion(), session.getFechaSolicitudToken(), session.getIpSession(),
                    session.getNavegadorSession(), session.getRolSession());
        }
    }

    public String updateSession(SessionDto sessionDto) {
        Optional<Session> session = sessionDao.findByUsuarioSession(sessionDto.getUsuarioSession());
        if (session.isPresent()) {
            Session objSes = session.get();
            objSes.setPasswordSession(sessionDto.getPasswordSession());
            objSes.setRolSession(sessionDto.getRolSession());
            objSes.setFechaOperacion(sessionDto.getFechaOperacion());
            objSes.setFechaSolicitudToken(sessionDto.getFechaSolicitudToken());
            objSes.setTokenSession(sessionDto.getTokenSession());
            objSes.setUsuarioSession(sessionDto.getUsuarioSession());
            objSes.setIpSession(sessionDto.getIpSession());
            objSes.setNavegadorSession(sessionDto.getNavegadorSession());

            sessionDao.save(objSes);
            return "OK";
        } else {
            return "Session no encontrada";
        }
    }
}
