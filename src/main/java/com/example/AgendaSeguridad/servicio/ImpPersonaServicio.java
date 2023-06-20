package com.example.AgendaSeguridad.servicio;

import com.example.AgendaSeguridad.entidad.Persona;
import com.example.AgendaSeguridad.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImpPersonaServicio implements PersonaServicio{
    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public List<Persona> listarTodosLasPersonas() {
        return personaRepositorio.findAll();
    }

    @Override
    public Persona guardarPersona(Persona persona) {

        return personaRepositorio.save(persona);
    }

    @Override
    public Persona obtenerPersonaPorId(Integer id) {
        return personaRepositorio.findById(id).get();
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return personaRepositorio.save(persona);
    }

    @Override
    public void eliminarPersona(Integer id) {
        personaRepositorio.deleteById(id);
    }
}
