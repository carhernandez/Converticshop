package com.Converticshop.Converticshop.Controller;
import com.Converticshop.Converticshop.Services.UsuarioService;

import com.Converticshop.Converticshop.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("")
    public String registro() {


        return "/administrador/LOGIN";
    }

    @DeleteMapping("/delete/{idUsuarios}")
    public ResponseEntity<Map<String, Boolean>> deleteUsuario(@PathVariable Integer idUsuarios) {
        return usuarioService.deleteUsuario(idUsuarios);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping(value = "/register", consumes = {"application/x-www-form-urlencoded",
            "text/plain", "multipart/form-data", "application/json", "text/plain;charset=UTF-8"})
    public ResponseEntity<Usuario> createUsuarios(@RequestBody Usuario usuarios) {
        return usuarioService.createUsuario(usuarios);
    }

    @GetMapping("/{idUsuarios}")
    public ResponseEntity<Usuario> getUsuariosById(@PathVariable Integer idUsuarios) {
        return usuarioService.getUsuariosById(idUsuarios);
    }

    @PutMapping("/{idUsuarios}")
    public ResponseEntity<Usuario> updateUsuarios(@PathVariable Integer idUsuarios, @RequestBody Usuario usuarios) {
        return usuarioService.updateUsuarios(idUsuarios, usuarios);
    }

    @GetMapping("/" +
            "")
    public ResponseEntity<List<Usuario>> getUsuarioAndPassword(@RequestParam int idUsuarios,
                                                                @RequestParam String contrasena) {
        return usuarioService.getIdUsuarioAndPassword(idUsuarios, contrasena);

    }

    @DeleteMapping("/searchidNom")
    public ResponseEntity<List<Usuario>> getUsuarioOrNombres(@RequestParam String idUsuarios,
                                                              @RequestParam String nombres) {
        return usuarioService.getUsuarioOrNombres(Integer.parseInt(idUsuarios), nombres);

    }

    @Autowired
    private UsuarioService usuarioService;


    /*public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Usuarios());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Usuarios user) {

        ResponseEntity<List<Usuarios>> oauthUser = usuariosServices.getCorreoElectronicoAndContrasena
        (user.getCorreoElectronico(), user.getContrasena());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/";

        } else {
            return "redirect:/login";
        }
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/login";

    }*/

}
