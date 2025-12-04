package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VentanaPrincipal extends JPanel {

    private CardLayout cardLayout;
    private VentanaLogin ventanaLogin;
    private VentanaRegistro ventanaRegistro;
    private VentanaPerfiles ventanaPerfiles;
    private VentanaNuevoPerfil ventanaNuevoPerfil;
    private VentanaInfoPelicula ventanaInfoPelicula;
    private VentanaBienvenida ventanaBienvenida;
    private VentanaCalificarPelicula ventanaCalificarPelicula;
    
    
    public VentanaPrincipal() {
    	cardLayout = new CardLayout();
    	this.setLayout(cardLayout);
        
        ventanaLogin = new VentanaLogin();
        ventanaRegistro = new VentanaRegistro();
        ventanaPerfiles = new VentanaPerfiles(null);
        ventanaNuevoPerfil = new VentanaNuevoPerfil();
        ventanaInfoPelicula = new VentanaInfoPelicula();
        ventanaBienvenida = new VentanaBienvenida(null);
        ventanaCalificarPelicula = new VentanaCalificarPelicula();
   
        add(ventanaLogin, VentanasEnum.LOGIN.getNombre());
        add(ventanaRegistro, VentanasEnum.REGISTRO.getNombre());
        add(ventanaPerfiles, VentanasEnum.PERFILES.getNombre());
        add(ventanaNuevoPerfil, VentanasEnum.NUEVOPERFIL.getNombre());
        add(ventanaInfoPelicula, VentanasEnum.INFOPELICULA.getNombre());
        add(ventanaBienvenida, VentanasEnum.BIENVENIDA.getNombre());
        add(ventanaCalificarPelicula, VentanasEnum.CALIFICARPELICULA.getNombre());
        
        // Mostrar la ventana de login por defecto
        mostrarCarta(VentanasEnum.LOGIN.getNombre());
    }
    
    public void mostrarCarta(String nombreCarta) {
        cardLayout.show(this, nombreCarta);
    }
    
    public void mostrarCarta(VentanasEnum ventana) {
        mostrarCarta(ventana.getNombre());
    }
    
	public VentanaLogin getVentanaLogin() {
		return ventanaLogin;
	}
	public void setVentanaLogin(VentanaLogin ventanaLogin) {
		this.ventanaLogin = ventanaLogin;
	}
	public VentanaRegistro getVentanaRegistro() {
		return ventanaRegistro;
	}
	public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
		this.ventanaRegistro = ventanaRegistro;
	}
	public VentanaPerfiles getVentanaPerfiles() {
		return ventanaPerfiles;
	}
	public void setVentanaPerfiles(VentanaPerfiles ventanaPerfiles) {
		this.ventanaPerfiles = ventanaPerfiles;
	}
	public VentanaNuevoPerfil getVentanaNuevoPerfil() {
		return ventanaNuevoPerfil;
	}
	public void setVentanaNuevoPerfil(VentanaNuevoPerfil ventanaNuevoPerfil) {
		this.ventanaNuevoPerfil = ventanaNuevoPerfil;
	}
	public VentanaInfoPelicula getVentanaInfoPelicula() {
		return ventanaInfoPelicula;
	}
	public void setVentanaInfoPelicula(VentanaInfoPelicula ventanaInfoPelicula) {
		this.ventanaInfoPelicula = ventanaInfoPelicula;
	}
	public VentanaBienvenida getVentanaBienvenida() {
		return ventanaBienvenida;
	}
	public void setVentanaBienvenida(VentanaBienvenida ventanaBienvenida) {
		this.ventanaBienvenida = ventanaBienvenida;
	}
	public VentanaCalificarPelicula getVentanaCalificarPelicula() {
		return ventanaCalificarPelicula;
	}
	public void setVentanaCalificarPelicula(VentanaCalificarPelicula ventanaCalificarPelicula) {
		this.ventanaCalificarPelicula = ventanaCalificarPelicula;
	}
    
    
    
}
