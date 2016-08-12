package br.pos.unipe.unipeJet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pos.unipe.unipeJet.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

}
