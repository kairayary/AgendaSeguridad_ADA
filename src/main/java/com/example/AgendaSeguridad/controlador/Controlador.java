package com.example.AgendaSeguridad.controlador;

import com.example.AgendaSeguridad.entidad.Persona;
import com.example.AgendaSeguridad.servicio.PersonaServicio;
import com.example.AgendaSeguridad.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class Controlador {
    @Autowired
    private PersonaServicio servicio;

    @Autowired
    private UsuarioServicio Uservicio;


    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo){
        modelo.addAttribute("usuarios", Uservicio.listarUsuarios());
        return "index";
    }


    //Pagina de inicio del sistema
    @GetMapping("/home")
    public String home(){
        return "home";
    }


    //Trae la lista de personas registradas en el html denominado "index"
    @GetMapping("/lista")
    public String listar(Model model){
        List<Persona> personas = servicio.listarTodosLasPersonas();

        model.addAttribute("personas", personas);
        return "lista";
    }


    //Direcciona a un nuevo formulario denominado "crearPersona"
    @GetMapping("/new")
    public String Agregar(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona",persona);
        return "crearPersona";
    }


    //Permite enviar o guardar a la BD "registros" los datos que se completo en el formulario
    @PostMapping("/save")
    public String Guardar(@ModelAttribute("persona") Persona persona){
        servicio.guardarPersona(persona);
        return "redirect:/lista";
    }

    //Direcciona a un nuevo formulario denominado "editarPersona"
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Integer id, Model model){

        model.addAttribute("persona", servicio.obtenerPersonaPorId(id));

        return "editarPersona";
    }

    //Permite enviar o guardar a la BD "registros" actualizados
    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Integer id, @ModelAttribute("persona")
    Persona persona, Model model){

        Persona personaExistente = servicio.obtenerPersonaPorId(id);

        personaExistente.setId(id);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setTelefono(persona.getTelefono());

        servicio.actualizarPersona(personaExistente);

        return "redirect:/lista";
    }

    //Permite eliminar los registros con los botones
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Integer id) {
        servicio.eliminarPersona(id);
        return "redirect:/lista";
    }
}
