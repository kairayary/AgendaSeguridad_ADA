package com.example.AgendaSeguridad.servicio;

import com.example.AgendaSeguridad.dto.UsuarioRegistroDTO;
import com.example.AgendaSeguridad.entidad.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService {
    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    public List<Usuario> listarUsuarios();

}
