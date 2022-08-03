package com.bit.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.proyecto.modelo.dto.LoginSessionDto;
import com.bit.proyecto.modelo.dto.SessionDto;
import com.bit.proyecto.rest.Output;
import com.bit.proyecto.security.JwtTokenUtil;

@Service
public class SessionService {

    @Autowired
    private SessionRepository repoSession;

    public Output flushDataOuput(Output response, String sms, String code, Object entity) {
        response.setMensaje(sms);
        response.setCodigo(code);
        response.setEntidad(entity);
        return response;
    }

    public LoginSessionDto getSessionToExpose(SessionDto sessionDto) {
        JwtTokenUtil getToken = new JwtTokenUtil();
        String token = getToken.getJWTToken(sessionDto.getUsuarioSession());

        LoginSessionDto session = new LoginSessionDto(sessionDto.getUsuarioSession(), token, sessionDto.getRolSession(),
                sessionDto.getIpSession(), 10.0);
        return session;
    }
}
