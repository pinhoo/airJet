package br.pos.unipe.unipeJet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pos.unipe.unipeJet.model.Aeronave;

public interface Aeronaves extends JpaRepository<Aeronave, Long> {

}
