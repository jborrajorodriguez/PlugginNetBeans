/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.Modulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.juan.Modulo.Funcion"
)
@ActionRegistration(
        iconBase = "com/juan/Modulo/github.png",
        displayName = "#CTL_Funcion"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_Funcion=Herramienta Git")
public final class Funcion implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String usuario=JOptionPane.showInputDialog("Introduce el Usuario");
            JPasswordField contraseña = new JPasswordField();
            JOptionPane.showConfirmDialog(null, contraseña, "Introduce la contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            GitHub github = GitHub.connectUsingPassword(usuario, new String(contraseña.getPassword()));
            GHRepository builder = github.createRepository(JOptionPane.showInputDialog("Introduce el nombre del repositorio"),JOptionPane.showInputDialog("Introduce la descripcion del repositorio"), " ", true);
            //JOptionPane.showMessageDialog(null, builder.getGitTransportUrl());
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }
}
